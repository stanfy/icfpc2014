package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import com.stanfy.icfp2014.lambdaprocessor.instructions.LambdaManProcessorInstruction;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class TranslatorAndExecutionTest {

  private Translator translator;

  @Before
  public void init() {
    translator = new Translator();
  }

  private LambdaManProcessor processorWithLoadedProgram(final String prog) {
    Buffer source = new Buffer();
    source.writeUtf8(prog);
    BufferedSource output = Okio.buffer(translator.translate(source).getCode());
    try {
      output.readUtf8LineStrict(); // skip first comment
      String p = output.readUtf8();
      ArrayList<LambdaManProcessorInstruction> instructions = LambdaManProcessor.parseAsmProgram(p);
      return new LambdaManProcessor(instructions);
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  @Test
  public void testAdding() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(+ 2 3)");
    processor.run();

    assertThat(processor.topStackValue()).isEqualTo(5);
  }

  @Test
  public void testSubstracting() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(- 3 1)");
    processor.run();

    assertThat(processor.topStackValue()).isEqualTo(2);
  }

  @Test
  public void testMultiplication() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(* 5 2)");
    processor.run();

    assertThat(processor.topStackValue()).isEqualTo(10);
  }

  @Test
  public void testDivision() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(/ 10 2)");
    processor.run();

    assertThat(processor.topStackValue()).isEqualTo(5);
  }


  @Test
  public void testComparation() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(> 1 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(0);

    processor = processorWithLoadedProgram("(>= 1 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(0);

    processor = processorWithLoadedProgram("(< 1 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);

    processor = processorWithLoadedProgram("(< 2 1)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(0);

    processor = processorWithLoadedProgram("(< 2 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(0);

    processor = processorWithLoadedProgram("(<= 2 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);

    processor = processorWithLoadedProgram("(<= 3 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(0);

    processor = processorWithLoadedProgram("(<= 2 3)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);

    processor = processorWithLoadedProgram("(== 2 2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);

  }

  /*


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

  @Ignore
  @Test
  public void ifFunc() {
    test(
        "(if (< 2 3) 6 7)",

        "LDC 3",
        "LDC 2",
        "CGTE",
        "SEL 4 6",
        "LDC 6",
        "JOIN",
        "LDC 7",
        "JOIN",
        "TODO"
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

   */
}
