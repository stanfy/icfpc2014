package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LoadConstantInstruction implements LambdaManProcessorInstruction{

  public LoadConstantInstruction(Integer constant) {
    this.constant = constant;
  }

  public Integer constant;

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    processor.s.add(constant);
    processor.c += 1;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "LDC " + constant;
  }

}
