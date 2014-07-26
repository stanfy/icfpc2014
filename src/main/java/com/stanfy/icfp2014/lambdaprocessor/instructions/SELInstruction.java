package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class SELInstruction implements LambdaManProcessorInstruction {
  public int trueBranchAddress;
  public int falseBranchAddress;

  public SELInstruction(int trueBranchAddress, int falseBranchAddress) {
    this.trueBranchAddress = trueBranchAddress;
    this.falseBranchAddress = falseBranchAddress;
  }

  @Override
  public void processOn(LambdaManProcessor processor) {
    Integer jumpAddress = trueBranchAddress;
    if ((Integer) processor.popStackValue() == 0) {
      jumpAddress = falseBranchAddress;
    }
    processor.c = jumpAddress;
  }

  @Override
  public String textRepresentation() {
    return "SEL " + trueBranchAddress + " " + falseBranchAddress;
  }

}
