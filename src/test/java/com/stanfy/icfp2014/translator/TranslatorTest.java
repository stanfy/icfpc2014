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

  private void test(final String prog, final String... out) {
    StringBuilder asm = new StringBuilder();
    for (String line : out)  {
      asm.append(line).append('\n');
    }
    test(prog, asm.toString());
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
    cmpTest("<", "2", "1", "CGT");
    cmpTest("<=", "2", "1", "CGTE");
    cmpTest("==", "1", "2", "CEQ");
  }

  @Test
  public void nestedOps() {
    test(
        "(> (+ (- 3 1) (* 2 2)) (== 2 2))",
        "LDC 3\n" +
        "LDC 1\n" +
        "SUB\n" +
        "LDC 2\n" +
        "LDC 2\n" +
        "MUL\n" +
        "ADD\n" +
        "LDC 2\n" +
        "LDC 2\n" +
        "CEQ\n" +
        "CGT"
    );
  }

  @Test
  public void pushingConstant() {
    test("(2)", "LDC 2");
  }

  @Test
  public void quoteSimpleList() {
    test(
        "(quote (2 3 1))",
        "LDC 0",
        "LDC 1",
        "CONS",
        "LDC 3",
        "CONS",
        "LDC 2",
        "CONS"
    );
    test(
        "(quote ((- 2 3) 1))",
        "LDC 0",
        "LDC 1",
        "CONS",
        "LDC 2",
        "LDC 3",
        "SUB",
        "CONS"
    );
  }

  @Test
  public void firstLast() {
    test(
        "(first (quote (1 2)))",
        "LDC 0",
        "LDC 2",
        "CONS",
        "LDC 1",
        "CONS",
        "CAR"
    );
    test(
        "(last (quote (1 2)))",
        "LDC 0",
        "LDC 2",
        "CONS",
        "LDC 1",
        "CONS",
        "CDR"
    );
  }

  @Test
  public void defnWithMain() {
    test(
        "(defn inc [x] (+ x 1)) (defn main [world anything] (inc world))",
        "LD 0 0",
        "LDF 4",
        "AP 1",
        "RTN",
        "LD 0 0", // inc:
        "LDC 1",
        "ADD",
        "RTN"
    );
  }

  @Test
  public void dummyMan() {
    test(
        "(defn step [state world] (tuple (0 1)))"
        + "(defn main [world anything] (tuple (0 step)))",

        "LDC 0",
        "LDF 4",
        "CONS",
        "RTN",
        "LDC 0",
        "LDC 1",
        "CONS",
        "RTN"
    );
  }

  @Test
  public void ifFunc() {
    test(
        "(if (< 2 3) 6 7)",

        "LDC 3",
        "LDC 2",
        "CGT",
        "TSEL 4 7",
        "LDC 6",
        "LDC 1",
        "TSEL 8 0",
        "LDC 7"
    );
  }

  @Ignore
  @Test
  public void fn() {
    test(
        "(fn [x y] [* x y])",
        ""
    );
  }

}
