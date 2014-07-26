package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.lambdaprocessor.Cons;
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


  @Test
  public void testNestedOps() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(+ 3 (- 10 (* 5 (/ 10 2))))");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(-12);
  }

  @Test
  public void testPushing() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(2)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(2);
  }

  @Test
  public void testQuoteSimpleList() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(quote (2 3 1))");
    processor.run();
    assertThat(processor.topStackValue()).isOfAnyClassIn(Cons.class);
    assertThat(((Cons)processor.topStackValue()).toString()).isEqualTo("(2, (3, (1, 0)))");
  }

  @Test
  public void testQuoteWithCalculation() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(quote ( (- 2 3) 1))");
    processor.run();
    assertThat(processor.topStackValue()).isOfAnyClassIn(Cons.class);
    assertThat(((Cons)processor.topStackValue()).toString()).isEqualTo("(-1, (1, 0))");
  }

  @Test
  public void testFirst() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(first (quote ( (- 2 3) 1)))");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(-1);
  }

  @Test
  public void testLast() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(last (quote ( (- 2 3) 1)))");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);
  }
  /*


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
