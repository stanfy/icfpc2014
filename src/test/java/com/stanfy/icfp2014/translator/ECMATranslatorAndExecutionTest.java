package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.lambdaprocessor.Cons;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import com.stanfy.icfp2014.lambdaprocessor.instructions.LambdaManProcessorInstruction;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMATranslatorAndExecutionTest {
  private ECMAScriptTranslator translator;

  @Before
  public void init() {
    translator = new ECMAScriptTranslator();
  }

  private LambdaManProcessor processorWithLoadedProgram(final String prog) {
    Buffer source = new Buffer();
    source.writeUtf8(prog);
    BufferedSource output = Okio.buffer(translator.translate(source).getCode());
    try {
      output.readUtf8LineStrict(); // skip first comment
      String p = output.readUtf8();
      System.out.println(p);
      ArrayList<LambdaManProcessorInstruction> instructions = LambdaManProcessor.parseAsmProgram(p);
      return new LambdaManProcessor(instructions);
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  private LambdaManProcessor processorWithLoadedProgram(final String ... prog) {
    StringBuilder asm = new StringBuilder();
    for (String line : prog)  {
      asm.append(line).append('\n');
    }
    return processorWithLoadedProgram(asm.toString());
  }

  @Test
  public void variable() {

    LambdaManProcessor processor = processorWithLoadedProgram("5");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
  }

  @Test
  public void adding() {

    LambdaManProcessor processor = processorWithLoadedProgram("2 + 3");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
  }

  @Test
  public void substracting() {

    LambdaManProcessor processor = processorWithLoadedProgram("5 - 3");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(2);

  }

  @Test
  public void multiplying() {
    LambdaManProcessor processor = processorWithLoadedProgram("5 * 4");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(20);
  }

  @Test
  public void division() {
    LambdaManProcessor processor = processorWithLoadedProgram("30 / 6");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
  }

  @Test
  public void complexExpression() {
    LambdaManProcessor processor = processorWithLoadedProgram("20 + 30 / 6");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(25);

    processor = processorWithLoadedProgram("30 / 6 + 20");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(25);

  }

  @Test
  public void orderedComplexExpression() {
    LambdaManProcessor processor = processorWithLoadedProgram("(20 + 30) / 6");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(8);

    processor = processorWithLoadedProgram("15/(3 + 10)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);

    processor = processorWithLoadedProgram("(2 + (15/(3 + 10)) * 7)");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(9);
  }

  @Test
  public void colonDelimitation() {
    LambdaManProcessor processor = processorWithLoadedProgram("(20 + 30) / 6 ; 2 +3");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
    assertThat(processor.s.size()).isEqualTo(2);

  }

  @Test
  public void colonDelimitation2() {
    LambdaManProcessor processor = processorWithLoadedProgram(";;;; 2 + 3 ; 5 ; 7");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(7);
    assertThat(processor.s.size()).isEqualTo(3);
  }

  @Test
  public void functionDefinition() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun s(a, b, c){ return a + b + c}",
        "fun main(){ s(1, 2, 3) }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(6);
    assertThat(processor.s.size()).isEqualTo(1);
  }


  @Test
  public void functionDefinition2() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun mul(a, b, c){ a * b * c}",
        "fun sum(a, b, c){ a + b + c}",
        "fun main(){ sum(1, 2, 3) + mul(1, 2, 3) }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(12);
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
  public void passFunctionAsParameter() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun mul(a, b){ a * b}",
        "fun sum(a, b){ a + b}",
        "fun logic(a,b,s,m) {s(a,b) + m(a,b)}",
        "fun main(){ logic(1,2,sum, mul) }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
  public void passArray() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun main(){ [1,nil] }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isOfAnyClassIn(Cons.class);
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
  public void lfirst() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun main(){ lfirst([1,2,3, nil]) }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1);
    assertThat(processor.s.size()).isEqualTo(1);

    processor = processorWithLoadedProgram(
        "fun main(){ lfirst([2,3,nil]) }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(2);
    assertThat(processor.s.size()).isEqualTo(1);

    processor = processorWithLoadedProgram(
        "fun main(){ lfirst([3,nil]) }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(3);
    assertThat(processor.s.size()).isEqualTo(1);

  }

  @Test
  public void rest() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun main(){ lrest([1,2,3,nil]) }"
    );
    processor.run();
    assertThat(processor.topStackValue().toString()).isEqualTo("(2, (3, 0))");
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
     public void eqExpression() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun main(){ [1 == 2 , 1 != 2, nil] }"
    );
    processor.run();
    assertThat(processor.topStackValue().toString()).isEqualTo("(0, (1, 0))");
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
  public void gtExpression() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun main(){ ",
        "[1 > 2 , 2 > 1, 2 > 2,",
        "1 >= 2, 2 >= 1, 2 >=2 ,",
        "1 < 2, 2 < 1, 2 < 2 ,",
        "1 <= 2, 2 <= 1, 2 <= 2, ",
            "nil] }"
    );
    processor.run();
    assertThat(processor.topStackValue().toString()).isEqualTo(
        "(0, (1, (0, " +
        "(0, (1, (1, " +
        "(1, (0, (0, " +
        "(1, (0, (1, " +
            "0))))))))))))");
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
  public void ifExpression() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun main(){ ",
        " if (2 > 3) { ",
        "   return 1",
        " } else {",
        "   return 2",
        "  }",
        "return 2",
        " }"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(2);
    assertThat(processor.s.size()).isEqualTo(1);

    processor = processorWithLoadedProgram(
        "fun main() {",
        "  if (3 > 2) {",
        "    return 5",
        "  }",
        "  return 7",
        "}"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
    assertThat(processor.s.size()).isEqualTo(1);

    processor = processorWithLoadedProgram(
        "fun main() {",
        "  if (3 < 2) {",
        "    return 5",
        "  }",
        "  return 7",
        "}"
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(7);
    assertThat(processor.s.size()).isEqualTo(1);

  }

  @Test
  public void variableDefinitions() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun s(p){ ",
        " var a = 2;",
        " var b = 3;",
        " return a + b + p",
        " }",

        "fun main(){ ",
        "   s(10)",
        " }",

        ""
        );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(15);
    assertThat(processor.s.size()).isEqualTo(1);
  }


  @Test
  public void variableDefinitionsInLambdas() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun s(p){ ",
        " var a = 2;",
        " var b = 3;",
        " return a + b + p",
        " }",

        "fun t(another_fun){ ",
        " another_fun(10)",
        " }",

        "fun main(){ ",
        "   t(s)",
        " }",

        ""
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(15);
    assertThat(processor.s.size()).isEqualTo(1);
  }

  @Test
  public void recursiveCall() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun fac(p){ ",
        " var s = p; ",
        " if (s == 0) {" +
        " return 1" +
         "} else {" +
        "return fac(s - 1) * s",
        " }" +
            "}",

        "fun main(){ ",
        "   fac(5)",
        " }",

        ""
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(1 * 2 * 3 * 4 * 5);
    assertThat(processor.s.size()).isEqualTo(1);
  }

  // Doesn't work
  @Ignore
  @Test
  public void functionInFunction() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun fac(p){ ",
          "fun inc(s){ ",
            "return s + 1 ",
          "}",
          "return inc(inc(p))",
        "}",

        "fun main(){ ",
        "   fac(5)",
        " }",

        ""
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(7);
    assertThat(processor.s.size()).isEqualTo(1);
  }

  // Doesn't work
  @Test
  public void arrayAccess() {
    LambdaManProcessor processor = processorWithLoadedProgram(
        "fun tup_nth(list, s){ ",
        " if (s == 0) { if (atom(list)) list else lfirst(list) } else { tup_nth(lrest(list), s-1)  }",
        "}",

        "fun fac(p){ ",
        " var j = [p , p +1, p +2];",
        " return j[2]",
        "}",

        "fun main(){ ",
        "   fac(5)",
        " }",

        ""
    );
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(7);
    assertThat(processor.s.size()).isEqualTo(1);
  }


}
