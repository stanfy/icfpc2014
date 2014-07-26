package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Cons;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ConsFirstInstruction implements LambdaManProcessorInstruction {

  @Override
  public void processOn(LambdaManProcessor processor) {
    Cons y = (Cons) processor.popStackValue();
    processor.pushStackValue(y.first);
    processor.c +=1;
  }

  @Override
  public String textRepresentation() {
    return "CAR";
  }
}
