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

  @Test
  public void testProgramWithAlotofInstructions() throws Exception {

    //(> (+ (- 3 1) (* 2 2)) (== 2 2))

    ArrayList<LambdaManProcessorInstruction> instructions =
        LambdaManProcessor.parseAsmProgram(
                "LDC 3\n"+
                "LDC 1\n"+
                "SUB\n"+
                "LDC 2\n"+
                "LDC 2\n"+
                "MUL\n"+
                "ADD\n"+
                "LDC 2\n"+
                "LDC 2\n"+
                "CEQ\n"+
                "CGT");

    processor = new LambdaManProcessor(instructions);
    processor.run();

    assert(processor.topStackValue().equals(1));


  }

  @Test
  public void testWorldGeneration() throws Exception {

    ArrayList<LambdaManProcessorInstruction> instructions =
        LambdaManProcessor.parseAsmProgram(
            "LDF 2 ; create_world \n" +
                "AP 0 \n" +
                "; -- FUNC create_world \n" +
                "LDF 12 ; create_map \n" +
                "AP 0 \n" +
                " \n" +
                "LDF 34 ; create_lambda_status \n" +
                "AP 0 \n" +
                " \n" +
                "LDC 0     ; status of all the ghosts (list or 0) \n" +
                " \n" +
                "LDC 0     ; status of fruit at the fruit location \n" +
                " \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                " \n" +
                "RTN \n" +
                " \n" +
                "; -- FUNC create_map \n" +
                "LDC 0 \n" +
                "LDC 0 \n" +
                "LDC 0 \n" +
                "LDC 0 \n" +
                "LDC 0   ; end \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                " \n" +
                "LDC 0 \n" +
                "LDC 5 \n" +
                "LDC 2 \n" +
                "LDC 2 \n" +
                "LDC 0   ; end \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                " \n" +
                "LDC 0 \n" +
                "CONS \n" +
                "CONS \n" +
                "RTN \n" +
                " \n" +
                "; -- FUNC create_lambda_status \n" +
                "LDC 0 ; vitality \n" +
                " \n" +
                "LDC 1     ; x \n" +
                "LDC 1     ; y \n" +
                "CONS      ; (x, y) \n" +
                " \n" +
                "LDC 2  ; direction  ; DIRECTION_DOWN \n" +
                " \n" +
                "LDC 3     ; number of lives \n" +
                " \n" +
                "LDC 0     ; current score \n" +
                " \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                "CONS \n" +
                " \n" +
                "RTN \n"
        );

    processor = new LambdaManProcessor(instructions);
    processor.run();

    assert(processor.topStackValue().equals(1));


  }
}