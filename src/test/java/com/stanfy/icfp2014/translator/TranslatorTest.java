package com.stanfy.icfp2014.translator;

import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.junit.Before;
import org.junit.Ignore;
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
    Buffer source = new Buffer();
    source.writeUtf8(prog);
    BufferedSource output = Okio.buffer(translator.translate(source).getCode());
    try {
      output.readUtf8LineStrict(); // skip first comment
      assertThat(output.readUtf8()).isEqualTo(out.trim());
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  @Test
  public void addition() {
    test(
        "(+ 2 4)",

        "LDC 2\n"
      + "LDC 4\n"
      + "ADD"
    );
  }

  @Ignore
  @Test
  public void ifFunc() {
    test(
        "(if (< 2 3) 6 7)",

          "LDC 3\n"
        + "LDC 2\n"
        + "CGT\n"
        + "SEL 4 5\n"
        + "LDC 6\n"
        + "LDC 7\n"
    );
  }

}
