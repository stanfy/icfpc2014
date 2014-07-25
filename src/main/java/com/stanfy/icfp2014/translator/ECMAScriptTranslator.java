package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.ecmascript4.ECMAScriptLexer;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import com.stanfy.icfp2014.translator.listeners.ECMAScriptConcreteListener;
import com.stanfy.icfp2014.translator.listeners.ECMAScriptToLListener;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptTranslator {

  public void translate(final Source program, final Sink output) {
    try {
      // Lexer
      ECMAScriptLexer lexer = new ECMAScriptLexer(new ANTLRInputStream(Okio.buffer(program).inputStream()));

      // Token Stream
      CommonTokenStream stream = new CommonTokenStream(lexer);

      // Parser
      ECMAScriptParser parser = new ECMAScriptParser(stream);
      ECMAScriptParser.ProgramContext tree = parser.program(); // parse

      ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
      ECMAScriptToLListener extractor = new ECMAScriptConcreteListener(output);
      parser.addParseListener(extractor);
      walker.walk(extractor, tree); // initiate walk of tree with listener

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
