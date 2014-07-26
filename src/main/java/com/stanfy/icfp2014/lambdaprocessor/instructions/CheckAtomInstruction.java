package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CheckAtomInstruction implements LambdaManProcessorInstruction {
  @Override
  public void processOn(LambdaManProcessor processor) {
    Object x =  processor.popStackValue();
    Integer z = x instanceof Integer ? 1 : 0;
    processor.pushStackValue(z);
    processor.c +=1;

  }

  @Override
  public String textRepresentation() {
    return "ATOM";
  }

}
