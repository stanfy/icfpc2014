package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadFromEnvironmentInstructionTest {

  private LambdaManProcessor processor = null;
  @Before
  public void setUp() throws Exception {
    processor = new LambdaManProcessor(null);
  }

  @Test
  public void testResolvingItemFromTopEnvironmentFrame() throws Exception {
    int counter = processor.c;

    processor.e.items.add(2);

    LoadFromEnvironmentInstruction loadConstantInstruction = new LoadFromEnvironmentInstruction(0, 0);
    loadConstantInstruction.processOn(processor);
    assertTrue(processor.c == counter + 1);
    assertTrue(processor.topStackValue() == Integer.valueOf(2));


  }

  @Test
  public void testResolvingItemFromTopEnvironmentFrameSecondVariable() throws Exception {
    int counter = processor.c;

    processor.e.items.add(2);
    processor.e.items.add(5);

    LoadFromEnvironmentInstruction loadConstantInstruction = new LoadFromEnvironmentInstruction(0,1);
    loadConstantInstruction.processOn(processor);
    assertTrue(processor.c == counter + 1);
    assertTrue(processor.topStackValue() == Integer.valueOf(5));

  }

  @Test
  public void testResolvingItemFromSecondEnvironmentFrameSecondVariable() throws Exception {
    int counter = processor.c;

    processor.e.items.add(2);
    processor.e.items.add(5);

    EnvironmentFrame frame = new EnvironmentFrame();
    frame.parent = processor.e;
    processor.e = frame;


    LoadFromEnvironmentInstruction loadConstantInstruction = new LoadFromEnvironmentInstruction(1, 1);
    loadConstantInstruction.processOn(processor);
    assertTrue(processor.c == counter + 1);
    assertTrue(processor.topStackValue() == Integer.valueOf(5));

  }


}