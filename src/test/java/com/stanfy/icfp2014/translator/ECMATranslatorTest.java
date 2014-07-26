package com.stanfy.icfp2014.translator;

import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMATranslatorTest {
  private ECMAScriptTranslator translator;

  @Before
  public void init() {
    translator = new ECMAScriptTranslator();
  }

  private void test(final String prog, final String out) {
    Buffer source = new Buffer(), output = new Buffer();
    source.writeUtf8(prog);
    translator.translate(source, output);

    // now we have output to program
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");


    // get javascript
    InputStream stream = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("com/stanfy/icfp2014/translator/game.js");
    try {
      engine.eval(new InputStreamReader(stream));
    } catch (ScriptException e) {
      e.printStackTrace();
    }

    try {
      assertThat(output.readUtf8()).isEqualTo(out);
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  @Test
  public void ifFunc() {
    test(
        "var f = 2; f++\n" +
        "var b = 3;\n" +
        "var c = b + f;" +
         "c = c + 5",
        "todo"
    );
  }
}
