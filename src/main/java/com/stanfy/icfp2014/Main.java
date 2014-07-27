package com.stanfy.icfp2014;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import com.stanfy.icfp2014.translator.Result;
import com.stanfy.icfp2014.translator.Translator;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Entry point.
 */
public final class Main {

  public static void main(final String[] args) throws IOException {
    String input = args.length > 0 ? args[0] : "src/main/clojure/man.clj";
    Translator t = new Translator();

    Buffer allSource = new Buffer();
    Source source;
    if (!input.endsWith("small.clj")) {
      source = Okio.source(new File("src/main/clojure/funcs.clj"));
      allSource.writeAll(source);
      source.close();
    }
    source = Okio.source(new File(input));
    allSource.writeAll(source);
    source.close();

    Result res = t.translate(allSource);

    boolean execute = false;

    BufferedSink out;
    if (args.length > 1) {
      switch (args[1]) {
        case "std":
          out = Okio.buffer(Okio.sink(System.out));
          break;
        case "test":
          out = new Buffer();
          execute = true;
          break;
        default:
          throw new AssertionError(Arrays.toString(args));
      }
    } else {
      out = Okio.buffer(Okio.sink(new File("icfpcontest2014.github.io/gcc/generated.gcc")));
    }

    out.writeAll(res.getCode());
    out.flush();

    if (execute) {
      LambdaManProcessor p = new LambdaManProcessor(LambdaManProcessor.parseAsmProgram(((Buffer) out).readUtf8()));
      p.run();
      System.out.println("Result: " + p.popStackValue());
    }
  }

}
