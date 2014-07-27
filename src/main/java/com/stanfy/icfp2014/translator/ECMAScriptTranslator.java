package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.ecmascript4.ECMAScriptLexer;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import com.stanfy.icfp2014.translator.Result;
import com.stanfy.icfp2014.translator.Scope;
import com.stanfy.icfp2014.translator.listeners.ECMAScriptConcreteListener;
import com.stanfy.icfp2014.translator.listeners.ECMAScriptToLListener;
import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import static com.stanfy.icfp2014.ecmascript4.ECMAScriptParser.SourceElementContext;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptTranslator {

  public Result translate(final Source program) {
    try {
      ECMAScriptLexer lexer = new ECMAScriptLexer(new ANTLRInputStream(Okio.buffer(program).inputStream()));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      ECMAScriptParser parser = new ECMAScriptParser(stream);

      Buffer output = new Buffer();

      Scope scope = new Scope("root");

      Program prg = new Program();
      prg.add(Statement.comment("Stanfy (c) 2014"));
      parser.program().sourceElements().sourceElement().stream()
          .map((node) -> translateNode(scope, node))
          .forEach(prg::add);

      prg.resolveLabels(0);

      output.writeUtf8(prg.asm());

      return new Result(output, prg.size());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Statement translateNode(Scope scope, SourceElementContext node) {
    return null;
  }

}
