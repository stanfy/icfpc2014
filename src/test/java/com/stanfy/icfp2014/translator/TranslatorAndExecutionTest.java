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
  public void testRest() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(rest (quote ( (- 2 3) 1)))");
    processor.run();
    assertThat(processor.topStackValue().toString()).isEqualTo("(1, 0)");
  }

  @Test
  public void testIf() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram("(if (< 1 2) 3 4)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(3);

    processor = processorWithLoadedProgram("(if (> 1 2) 3 4)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(4);
  }

  @Test
  public void defnWithMain() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "(defn inc [x] (+ x 1))\n" +
        "(defn s [something_to_increment anything] (inc something_to_increment)) \n" +
        "(defn main [a b] (s 1 2))");
    ArrayList coms = new ArrayList();
    ArrayList<LambdaManProcessorInstruction> loadedProgram = processor.loadedProgram;
    int idx = 0;
    for (LambdaManProcessorInstruction instruction : loadedProgram) {
      coms.add(idx + " " + instruction.textRepresentation() + "\n");
      idx++;
    }
//    System.out.println(coms);
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(2);
  }

  @Test
  public void defnWithRecursion() throws Exception {
    LambdaManProcessor processor = processorWithLoadedProgram(
      "(defn faq [x] (if (== x 0) 1 (* x (faq (- x 1)))))" +
      "(defn main [ignored] (faq 5))"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1 * 2 * 3 * 4 * 5);
  }

  @Test
  public void let() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "(let [x] (2) (+ x 1))"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(3);
  }

  /*


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
