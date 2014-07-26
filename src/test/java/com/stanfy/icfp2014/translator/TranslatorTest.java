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
      String p = output.readUtf8();
//      System.out.println("prog = [" + p + "]");
      assertThat(p).isEqualTo(out.trim());
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

  @Test
  public void sub() {
    test(
        "(- 3 1)",

        "LDC 3\n"
      + "LDC 1\n"
      + "SUB"
    );
  }

  @Test
  public void mul() {
    test(
        "(* 3 2)",

        "LDC 3\n"
      + "LDC 2\n"
      + "MUL"
    );
  }

  @Test
  public void div() {
    test(
        "(/ 1 4)",

        "LDC 1\n"
      + "LDC 4\n"
      + "DIV"
    );
  }

  private void cmpTest(final String clojure, final String first, final String second, final String asmInstr) {
    test("(" + clojure + " 1 2)", "LDC " + first + "\nLDC " + second + "\n" + asmInstr);
  }

  @Test
  public void cmp() {
    cmpTest(">", "1", "2", "CGT");
    cmpTest(">=", "1", "2", "CGTE");
    cmpTest("<", "2", "1", "CGTE");
    cmpTest("<=", "2", "1", "CGT");
    cmpTest("==", "1", "2", "CEQ");
  }

  @Test
  public void ifFunc() {
    test(
        "(if (< 2 3) 6 7)",

        "LDC 3\n"
      + "LDC 2\n"
      + "CGTE\n"
      + "SEL 4 6\n"
      + "LDC 6\n"
      + "RTN\n"
      + "LDC 7\n"
      + "RTN\n"
    );
  }

  @Ignore
  @Test
  public void func() {
    test(
        "(fn [x y] [* x y])",
        ""
    );
  }

  @Ignore
  @Test
  public void main() {
    test(
        "(def test (fn [x y] (+ x y)))"
        + "(def main (fn [world undocumented] (test 1 2)))",
        "TODO"
    );
  }

}
