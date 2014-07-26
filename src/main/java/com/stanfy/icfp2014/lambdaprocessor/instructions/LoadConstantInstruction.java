package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LoadConstantInstruction implements LambdaManProcessorInstruction{

  public Integer constant;

  @Override
  public void processOn(LambdaManProcessor processor) {
    processor.s.add(constant);
    processor.c += 1;
  }

  @Override
  public String textRespresentation() {
    return "LDC " + constant;
  }

  public static LoadConstantInstruction with(int i) {
    LoadConstantInstruction instruction = new LoadConstantInstruction();
    instruction.constant = i;
    return instruction;
  }
}
