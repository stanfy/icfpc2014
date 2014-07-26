package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Closure;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LoadFunctionInstruction implements LambdaManProcessorInstruction {

  public int address;

  public LoadFunctionInstruction(int address) {
    this.address = address;
  }

  @Override
  public void processOn(LambdaManProcessor processor) {
    Closure x = new Closure(address, processor.e);
    processor.pushStackValue(x);
    processor.c += 1;
  }

  @Override
  public String textRepresentation() {
    return "LDF " + address;
  }
}
