package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CompareEqualInstruction implements LambdaManProcessorInstruction {
  @Override
  public void processOn(LambdaManProcessor processor) {
    Integer y = (Integer) processor.popStackValue();
    Integer x = (Integer) processor.popStackValue();
    Integer z = x.intValue() == y.intValue() ? 1 : 0;
    processor.pushStackValue(z);
    processor.c +=1;

  }

  @Override
  public String textRepresentation() {
    return "CEO";
  }
}
