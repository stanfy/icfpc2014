package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Cons;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ConsInstruction implements LambdaManProcessorInstruction {
  @Override
  public void processOn(LambdaManProcessor processor) {
    Integer y = (Integer) processor.popStackValue();
    Integer x = (Integer) processor.popStackValue();
    processor.pushStackValue(new Cons(x, y));
    processor.c +=1;
  }

  @Override
  public String textRepresentation() {
    return "CONS";
  }
}
