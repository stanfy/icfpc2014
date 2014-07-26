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
    core.put("+", (list) -> twoInts(Statement.NoArgs.ADD, list));
    core.put("-", (list) -> twoInts(Statement.NoArgs.SUB, list));

    core.put(
        "if",
        (list) -> {
          Function f = new Function("if", "");
          // TODO
          return f;
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
          .map(this::translate)
          .forEach(prg::add);

      System.out.println("program = [" + prg.asm() + "]");

      output.writeUtf8(prg.asm());

      return new Result(output, prg.programCounter());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Statement translate(final ClojureParser.ListContext list) {
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

  private FuncTranslate fromCore(ParseTree node) {
    FuncTranslate result = core.get(node.getText());
    if (result == null) {
      throw new IllegalArgumentException(node.getText() + " not found in core");
    }
    return result;
  }

  private Statement intArg(final ClojureParser.FormContext arg) {
    ClojureParser.LiteralContext literal = arg.literal();
    if (literal != null) {
      TerminalNode number = literal.NUMBER();
      if (number != null) {
        return Statement.ldc(Integer.parseInt(number.getText()));
      }
      throw new IllegalArgumentException("Can be number only");
    }
    throw new UnsupportedOperationException();
  }

  private Statement twoInts(final Statement.NoArgs op, final ClojureParser.ListContext list) {
    Sequence seq = new Sequence();
    seq.add(intArg(list.form(1)));
    seq.add(intArg(list.form(2)));
    seq.add(op);
    return seq;
  }

  private interface FuncTranslate {
    Statement translate(ClojureParser.ListContext list);
  }

}
