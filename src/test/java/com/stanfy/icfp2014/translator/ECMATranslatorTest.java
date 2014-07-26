package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import com.stanfy.icfp2014.lambdaprocessor.instructions.LambdaManProcessorInstruction;
import okio.Buffer;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

  private LambdaManProcessor loadProgramToProcessor(final String prog) {
    Buffer source = new Buffer(), output = new Buffer();
    source.writeUtf8(prog);
    translator.translate(source, output);

    ArrayList<LambdaManProcessorInstruction> instructions = null;
    try {
      instructions = LambdaManProcessor.parseAsmProgram(output.readUtf8());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new LambdaManProcessor(instructions);

  }

  @Test
  public void adding() {

    LambdaManProcessor processor = loadProgramToProcessor("2 + 3");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(5);
  }

  @Test
  public void substracting() {

    LambdaManProcessor processor = loadProgramToProcessor("5-3");
    processor.run();
    assertThat(processor.topStackValue()).isEqualTo(2);
  }

}
