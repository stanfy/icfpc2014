package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArifmeticInstructionTest {

  private LambdaManProcessor processor = null;
  @Before
  public void setUp() throws Exception {
    processor = new LambdaManProcessor();
  }

  @Test
  public void testAddingInstruction() throws Exception {
    int counter = processor.c;

    LoadConstantInstruction constant1 = LoadConstantInstruction.with(3);
    LoadConstantInstruction constant2 = LoadConstantInstruction.with(4);
    AddInstruction addInstruction = new AddInstruction();

    constant1.processOn(processor);
    constant2.processOn(processor);

    addInstruction.processOn(processor);

    assertTrue(processor.c == counter + 3);
    assertTrue(processor.topStackValue() == Integer.valueOf(7));


  }

  @Test
  public void testSubscractingInstruction() throws Exception {
    int counter = processor.c;

    LoadConstantInstruction constant1 = LoadConstantInstruction.with(3);
    LoadConstantInstruction constant2 = LoadConstantInstruction.with(4);
    SubInstruction  addInstruction = new SubInstruction();

    constant1.processOn(processor);
    constant2.processOn(processor);

    addInstruction.processOn(processor);

    assertTrue(processor.c == counter + 3);
    assertTrue(processor.topStackValue() == Integer.valueOf(-1));


  }

  @Test
  public void testMultiplyingInstruction() throws Exception {
    int counter = processor.c;

    LoadConstantInstruction constant1 = LoadConstantInstruction.with(3);
    LoadConstantInstruction constant2 = LoadConstantInstruction.with(4);
    MulInstruction  addInstruction = new MulInstruction();

    constant1.processOn(processor);
    constant2.processOn(processor);

    addInstruction.processOn(processor);

    assertTrue(processor.c == counter + 3);
    assertTrue(processor.topStackValue() == Integer.valueOf(12));


  }

  @Test
  public void testDivInstruction() throws Exception {
    int counter = processor.c;

    LoadConstantInstruction constant1 = LoadConstantInstruction.with(10);
    LoadConstantInstruction constant2 = LoadConstantInstruction.with(4);
    DivInstruction  addInstruction = new DivInstruction();

    constant1.processOn(processor);
    constant2.processOn(processor);

    addInstruction.processOn(processor);

    assertTrue(processor.c == counter + 3);
    assertTrue(processor.topStackValue() == Integer.valueOf(2));


  }


}