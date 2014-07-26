package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class JoinInstruction implements LambdaManProcessorInstruction{
  @Override
  public void processOn(LambdaManProcessor processor) {
    Integer d = (Integer) processor.popStackValue();
    processor.c = d;
  }

  @Override
  public String textRepresentation() {
    return "JOIN";
  }
}
