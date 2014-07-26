package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.clojure.ClojureLexer;
import com.stanfy.icfp2014.clojure.ClojureParser;
import okio.Buffer;
import okio.Okio;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.stanfy.icfp2014.translator.Statement.NoArgs.CAR;
import static com.stanfy.icfp2014.translator.Statement.NoArgs.CDR;
import static com.stanfy.icfp2014.translator.Statement.NoArgs.CONS;

/**
 * Translates Clojure to GCC ASM.
 */
public class Translator {

  private final Map<String, FuncTranslate> core = new HashMap<>();
  {
    core.put("+", (list) -> twoArgs(Statement.NoArgs.ADD, list.form(1), list.form(2)));
    core.put("-", (list) -> twoArgs(Statement.NoArgs.SUB, list.form(1), list.form(2)));
    core.put("*", (list) -> twoArgs(Statement.NoArgs.MUL, list.form(1), list.form(2)));
    core.put("/", (list) -> twoArgs(Statement.NoArgs.DIV, list.form(1), list.form(2)));
    core.put(">", (list) -> twoArgs(Statement.NoArgs.CGT, list.form(1), list.form(2)));
    core.put(">=", (list) -> twoArgs(Statement.NoArgs.CGTE, list.form(1), list.form(2)));
    core.put("<", (list) -> twoArgs(Statement.NoArgs.CGTE, list.form(2), list.form(1)));
    core.put("<=", (list) -> twoArgs(Statement.NoArgs.CGT, list.form(2), list.form(1)));
    core.put("==", (list) -> twoArgs(Statement.NoArgs.CEQ, list.form(1), list.form(2)));

    core.put("quote", (list) -> {
      ClojureParser.ListContext arg = list.form(1).list();
      if (arg == null) {
        throw new IllegalStateException("quote without list!!!");
      }
      Sequence seq = new Sequence();
      seq.add(Statement.ldc(0));
      for (int i = arg.form().size() - 1; i >= 0; i--) {
        seq.add(translateNode(arg.form(i)));
        seq.add(CONS);
      }
      return seq;
    });

    core.put("first", (list) -> {
      Sequence result = new Sequence();
      result.add(translateNode(list.form(1)));
      result.add(CAR);
      return result;
    });

    core.put("last", (list) -> {
      Sequence result = new Sequence();
      result.add(translateNode(list.form(1)));
      result.add(CDR);
      return result;
    });

    core.put(
        "if",
        (list) -> {
          Sequence result = new Sequence();
          Function tb = Function.create(translateNode(list.form(2)));
          Function fb = Function.create(translateNode(list.form(3)));

          result.add(translateNode(list.form(1)));
          result.add(Statement.sel(tb, fb));
          result.add(tb);
          result.add(fb);

          return result;
        }
    );
  }

  public Result translate(final Source program) {
    try {
      ClojureLexer lexer = new ClojureLexer(new ANTLRInputStream(Okio.buffer(program).inputStream()));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      ClojureParser parser = new ClojureParser(stream);

      Buffer output = new Buffer();

      Program prg = new Program();
      prg.add(Statement.comment("Stanfy (c) 2014"));
      parser.file().list().stream()
          .map(this::translateNode)
          .forEach(prg::add);

      output.writeUtf8(prg.asm());

      return new Result(output, prg.programCounter());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Statement translateList(final ClojureParser.ListContext list) {
    ClojureParser.FormContext first = list.form(0);
    ClojureParser.LiteralContext literal = first.literal();
    if (literal != null) {
      if (literal.SYMBOL() != null) {
        return resolve(literal).translate(list);
      }
      if (literal.NUMBER() != null) {
        if (list.form().size() == 1) {
          return translateNode(literal);
        }
      }
    }
    throw new UnsupportedOperationException();
  }

  private Statement translateNode(final ParseTree node) {
    if (node == null) {
      throw new IllegalArgumentException("null node");
    }

    if (node instanceof ClojureParser.ListContext) {
      return translateList((ClojureParser.ListContext) node);
    }

    if (node instanceof ClojureParser.FormContext) {
      return translateNode(node.getChild(0));
    }

    if (node instanceof ClojureParser.LiteralContext) {
      ClojureParser.LiteralContext literal = (ClojureParser.LiteralContext) node;
      if (literal.NUMBER() != null) {
        return Statement.ldc(Integer.parseInt(literal.getText()));
      }
    }

    throw new UnsupportedOperationException("cannot translate " + node.getText());
  }

  private FuncTranslate resolve(ParseTree node) {
    FuncTranslate result = core.get(node.getText());
    if (result == null) {
      throw new IllegalArgumentException(node.getText() + " cannot be resolved");
    }
    return result;
  }

  private Statement twoArgs(final Statement.NoArgs op,
                            final ClojureParser.FormContext arg1, final ClojureParser.FormContext arg2) {
    Sequence seq = new Sequence();
    seq.add(translateNode(arg1));
    seq.add(translateNode(arg2));
    seq.add(op);
    return seq;
  }

  private interface FuncTranslate {
    Statement translate(ClojureParser.ListContext list);
  }

}
