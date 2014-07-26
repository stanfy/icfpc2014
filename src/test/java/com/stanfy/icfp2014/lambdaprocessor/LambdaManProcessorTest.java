package com.stanfy.icfp2014.lambdaprocessor;

import com.stanfy.icfp2014.lambdaprocessor.instructions.LoadConstantInstruction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaManProcessorTest {

  private  LambdaManProcessor processor = null;
  @Before
  public void setUp() throws Exception {
    processor = new LambdaManProcessor();
  }

  @Test
  public void testLoadConstantInstruction() throws Exception {
    int counter = processor.c;
    LoadConstantInstruction loadConstantInstruction = LoadConstantInstruction.with(3);
    loadConstantInstruction.processOn(processor);
    assertTrue(processor.c == counter + 1);
    assertTrue(processor.topStackValue() == Integer.valueOf(3));

  }


}