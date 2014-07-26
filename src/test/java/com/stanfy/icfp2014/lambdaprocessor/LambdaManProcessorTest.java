package com.stanfy.icfp2014.lambdaprocessor;

import com.stanfy.icfp2014.lambdaprocessor.instructions.AddInstruction;
import com.stanfy.icfp2014.lambdaprocessor.instructions.LambdaManProcessorInstruction;
import com.stanfy.icfp2014.lambdaprocessor.instructions.LoadConstantInstruction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LambdaManProcessorTest {

  private  LambdaManProcessor processor = null;
  @Before
  public void setUp() throws Exception {
    processor = new LambdaManProcessor(null);
  }

  @Test
  public void testProgramParsing() throws Exception {
    ArrayList<LambdaManProcessorInstruction> instructions = LambdaManProcessor.parseAsmProgram("ADD");
    assertTrue(instructions.size() == 1);
    assertTrue(instructions.get(0) instanceof AddInstruction);

    instructions = LambdaManProcessor.parseAsmProgram("LDC 2");
    assertTrue(instructions.size() == 1);
    LambdaManProcessorInstruction loadConstantInstruction = instructions.get(0);
    assertTrue(loadConstantInstruction instanceof LoadConstantInstruction);
    assertTrue(((LoadConstantInstruction)loadConstantInstruction).constant == 2);

  }

  @Test
  public void testProgramOneStepRun() throws Exception {
    ArrayList<LambdaManProcessorInstruction> instructions =
        LambdaManProcessor.parseAsmProgram(
            "LDC 1\n" +
            "LDC 2\n" +
            "ADD");
    processor = new LambdaManProcessor(instructions);

    assertTrue(instructions.size() == 3);

    // LDC 1
    processor.step();
    assert(processor.topStackValue().equals(1));

    // LDC 2
    processor.step();
    assert(processor.topStackValue().equals(2));

    // ADD
    processor.step();
    assert(processor.topStackValue().equals(3));

  }

  @Test
  public void testProgramStopOnNoMoreInstructions() throws Exception {
    ArrayList<LambdaManProcessorInstruction> instructions =
        LambdaManProcessor.parseAsmProgram(
            "LDC 1\n" +
                "LDC 2\n" +
                "ADD");
    processor = new LambdaManProcessor(instructions);
    processor.run();

    assert(processor.topStackValue().equals(3));

    processor.step();
    assert(processor.topStackValue().equals(3));


  }



}