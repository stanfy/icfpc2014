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
      //System.out.println(p);
      ArrayList<LambdaManProcessorInstruction> instructions = LambdaManProcessor.parseAsmProgram(p);
      return new LambdaManProcessor(instructions);
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

}
