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

  }
}