package com.stanfy.icfp2014;

import com.stanfy.icfp2014.translator.Result;
import com.stanfy.icfp2014.translator.Translator;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

import java.io.File;
import java.io.IOException;

/**
 * Entry point.
 */
public final class Main {

  public static void main(final String[] args) throws IOException {
    String input = args.length > 0 ? args[0] : "src/main/clojure/man.clj";
    Translator t = new Translator();
    Source source = Okio.source(new File(input));
    Result res = t.translate(source);
    source.close();

    BufferedSink out = Okio.buffer(Okio.sink(System.out));
    out.writeAll(res.getCode());
    out.flush();
  }

}
