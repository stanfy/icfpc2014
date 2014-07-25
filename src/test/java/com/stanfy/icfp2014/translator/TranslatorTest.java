package com.stanfy.icfp2014.translator;

import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TranslatorTest {

  private Translator translator;

  @Before
  public void init() {
    translator = new Translator();
  }

  private void test(final String prog, final String out) {
    Buffer source = new Buffer(), output = new Buffer();
    source.writeUtf8(prog);
    translator.translate(source, output);
    try {
      assertThat(output.readUtf8()).isEqualTo(out);
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  @Test
  public void ifFunc() {
    test(
        "(if (< 2 3) 6 7)",
        "todo"
    );
  }

}
