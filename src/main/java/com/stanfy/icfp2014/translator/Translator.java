package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.clojure.ClojureLexer;
import com.stanfy.icfp2014.clojure.ClojureParser;
import okio.Buffer;
import okio.Okio;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.stanfy.icfp2014.translator.Statement.NoArgs.*;

/**
 * Translates Clojure to GCC ASM.
 */
public class Translator {

  private final Map<String, FuncTranslate> core = new HashMap<>();
  {
    core.put("+", (scope, list) -> twoArgs(scope, Statement.NoArgs.ADD, list.form(1), list.form(2)));
    core.put("-", (scope, list) -> twoArgs(scope, Statement.NoArgs.SUB, list.form(1), list.form(2)));
    core.put("*", (scope, list) -> twoArgs(scope, Statement.NoArgs.MUL, list.form(1), list.form(2)));
    core.put("/", (scope, list) -> twoArgs(scope, Statement.NoArgs.DIV, list.form(1), list.form(2)));
    core.put(">", (scope, list) -> twoArgs(scope, Statement.NoArgs.CGT, list.form(1), list.form(2)));
    core.put(">=", (scope, list) -> twoArgs(scope, Statement.NoArgs.CGTE, list.form(1), list.form(2)));
    core.put("<", (scope, list) -> twoArgs(scope, Statement.NoArgs.CGT, list.form(2), list.form(1)));
    core.put("<=", (scope, list) -> twoArgs(scope, Statement.NoArgs.CGTE, list.form(2), list.form(1)));
    core.put("==", (scope, list) -> twoArgs(scope, Statement.NoArgs.CEQ, list.form(1), list.form(2)));

    core.put("quote", (scope, list) -> {
      ClojureParser.ListContext arg = list.form(1).list();
      if (arg == null) {
        throw new IllegalStateException("quote without list!!!");
      }
      Sequence seq = new Sequence();
      for (int i = 0; i < arg.form().size(); i++) {
        seq.add(translateNode(scope, arg.form(i)));
      }
      seq.add(Statement.ldc(0));
      for (int i = 0; i < arg.form().size(); i++) {
        seq.add(CONS);
      }
      return seq;
    });

    core.put("tuple", (scope, list) -> {
      ClojureParser.ListContext arg = list.form(1).list();
      if (arg == null) {
        throw new IllegalStateException("tuple without args in " + scope);
      }
      Sequence seq = new Sequence();
      seq.add(translateNode(scope, arg.form(0)));
      seq.add(translateNode(scope, arg.form(1)));
      seq.add(CONS);
      return seq;
    });

    core.put("first", (scope, list) -> {
      Sequence result = new Sequence();
      result.add(translateNode(scope, list.form(1)));
      result.add(CAR);
      return result;
    });

    core.put("rest", (scope, list) -> {
      Sequence result = new Sequence();
      result.add(translateNode(scope, list.form(1)));
      result.add(CDR);
      return result;
    });

    core.put("defn", (scope, list) -> {
      String name = list.form(1).getText();
      String[] arguments = list.form(2)
          .vector().form()
          .stream().map(RuleContext::getText).toArray(String[]::new);

      Scope fScope = scope.push(name);
      for (int i = 0; i < arguments.length; i++) {
        fScope.var(arguments[i], i);
      }
      Function f = new Function(name, arguments.length);
      scope.function(f);
      f.setBody(translateNode(fScope, list.form(3)));

      return f;
    });

    core.put("if", (scope, list) -> {
      Sequence result = new Sequence();
      Reference tb = new Reference(), fb = new Reference();
      tb.add(translateNode(scope, list.form(2)));
      tb.add(Statement.ldc(1));
      tb.add(Statement.tsel(() -> fb.getAddress() + fb.size(), () -> 0));
      fb.add(translateNode(scope, list.form(3)));

      result.add(translateNode(scope, list.form(1)));
      result.add(Statement.tsel(tb::getAddress, fb::getAddress));
      result.add(tb);
      result.add(fb);

      return result;
    });

    core.put("println", (scope, list) -> {
      Sequence result = new Sequence();
      result.add(translateNode(scope, list.form(1)));
      result.add(DBUG);
      result.add(Statement.ldc(0));
      return result;
    });

    core.put("isInt", (scope, list) -> {
      Sequence result = new Sequence();
      result.add(translateNode(scope, list.form(1)));
      result.add(ATOM);
      return result;
    });

  }

  public Result translate(final Source program) {
    try {
      ClojureLexer lexer = new ClojureLexer(new ANTLRInputStream(Okio.buffer(program).inputStream()));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      ClojureParser parser = new ClojureParser(stream);

      Buffer output = new Buffer();

      Scope scope = new Scope("root");

      Program prg = new Program();
      prg.add(Statement.comment("Stanfy (c) 2014"));
      parser.file().list().stream()
          .map((node) -> translateNode(scope, node))
          .forEach(prg::add);

      prg.resolveLabels(0);

      output.writeUtf8(prg.asm());

      return new Result(output, prg.size());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Statement translateList(final Scope scope, final ClojureParser.ListContext list) {
    ClojureParser.FormContext first = list.form(0);
    ClojureParser.LiteralContext literal = first.literal();
    if (literal != null) {
      if (literal.SYMBOL() != null) {
        return resolve(literal).translate(scope, list);
      }
      if (literal.NUMBER() != null) {
        if (list.form().size() == 1) {
          return translateNode(scope, literal);
        }
      }
    }
    throw new UnsupportedOperationException();
  }

  private Statement translateNode(final Scope scope, final ParseTree node) {
    if (node == null) {
      throw new IllegalArgumentException("null node");
    }

    if (node instanceof ClojureParser.ListContext) {
      return translateList(scope, (ClojureParser.ListContext) node);
    }

    if (node instanceof ClojureParser.FormContext) {
      return translateNode(scope, node.getChild(0));
    }

    if (node instanceof ClojureParser.LiteralContext) {
      ClojureParser.LiteralContext literal = (ClojureParser.LiteralContext) node;
      // atom (integer)
      String name = literal.getText();
      if (literal.NUMBER() != null) {
        return Statement.ldc(Integer.parseInt(name));
      }
      // variable
      if (literal.SYMBOL() != null) {
        int frame = scope.varFrame(name);
        if (frame == -1) {
          Function func = scope.function(name);
          if (func == null) {
            throw new IllegalArgumentException(name + " is not resolved in " + scope);
          }
          return Statement.ldf(func::getAddress);
        }
        return Statement.ld(frame, scope.varIndex(name)); // TODO: optimize
      }
    }

    throw new UnsupportedOperationException("cannot translate " + node.getText());
  }

  private FuncTranslate resolve(ParseTree node) {
    String name = node.getText();
    FuncTranslate coreTranlation = core.get(name);
    if (coreTranlation != null) {
      return coreTranlation;
    }

    // call function
    return (s, list) -> {
      Function func = s.function(name);
      if (func == null) {
        throw new IllegalArgumentException(name + " is not resolved");
      }
      Sequence call = new Sequence();
      for (int i = 0; i < func.argsCount; i++) {
        call.add(translateNode(s, list.form(i + 1)));
      }
      call.add(Statement.ldf(func::getAddress));
      call.add(Statement.ap(func.argsCount));
      return call;
    };
  }

  private Statement twoArgs(final Scope scope, final Statement.NoArgs op,
                            final ClojureParser.FormContext arg1, final ClojureParser.FormContext arg2) {
    Sequence seq = new Sequence();
    seq.add(translateNode(scope, arg1));
    seq.add(translateNode(scope, arg2));
    seq.add(op);
    return seq;
  }

  private interface FuncTranslate {
    Statement translate(Scope scope, ClojureParser.ListContext list);
  }

}
