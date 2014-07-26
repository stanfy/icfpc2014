package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.clojure.ClojureLexer;
import com.stanfy.icfp2014.clojure.ClojureParser;
import okio.Buffer;
import okio.Okio;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    core.put(
        "if",
        (list) -> {
          Sequence result = new Sequence();
          Function tb = Function.create(translate(list.form(2)));
          Function fb = Function.create(translate(list.form(3)));

          result.add(translate(list.form(1)));
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
          .map(this::translateList)
          .forEach(prg::add);

      output.writeUtf8(prg.asm());

      return new Result(output, prg.programCounter());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Statement translateList(final ClojureParser.ListContext list) {
    ClojureParser.FormContext first = list.form(0);
    TerminalNode symbol = first.SYMBOL();
    if (symbol != null) {
      return fromCore(symbol).translate(list);
    }
    ClojureParser.LiteralContext literal = first.literal();
    if (literal != null) {
      return fromCore(literal).translate(list);
    }
    throw new UnsupportedOperationException();
  }

  private Statement translate(final ParseTree node) {
    if (node == null) {
      throw new IllegalArgumentException("null node");
    }

    if (node instanceof ClojureParser.ListContext) {
      return translateList((ClojureParser.ListContext) node);
    }

    if (node instanceof ClojureParser.FormContext) {
      return translate(node.getChild(0));
    }

    if (node instanceof ClojureParser.LiteralContext) {
      ClojureParser.LiteralContext literal = (ClojureParser.LiteralContext) node;
      if (literal.NUMBER() != null) {
        return Statement.ldc(Integer.parseInt(literal.getText()));
      }
    }

    throw new UnsupportedOperationException("cannot translate " + node.getText());
  }

  private FuncTranslate fromCore(ParseTree node) {
    FuncTranslate result = core.get(node.getText());
    if (result == null) {
      throw new IllegalArgumentException(node.getText() + " not found in core");
    }
    return result;
  }

  private Statement twoArgs(final Statement.NoArgs op,
                            final ClojureParser.FormContext arg1, final ClojureParser.FormContext arg2) {
    Sequence seq = new Sequence();
    seq.add(translate(arg1));
    seq.add(translate(arg2));
    seq.add(op);
    return seq;
  }

  private interface FuncTranslate {
    Statement translate(ClojureParser.ListContext list);
  }

}
