package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.clojure.ClojureLexer;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;

import java.io.IOException;

/**
 * Translates Clojure to GCC ASM.
 */
public class Translator {

  public void translate(final Source program, final Sink output) {
    try {
      ClojureLexer lexer = new ClojureLexer(new ANTLRInputStream(Okio.buffer(program).inputStream()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
