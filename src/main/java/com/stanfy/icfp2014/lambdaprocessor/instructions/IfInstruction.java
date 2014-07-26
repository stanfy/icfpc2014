package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class IfInstruction implements LambdaManProcessorInstruction {
  public int trueBranchAddress;
  public int falseBranchAddress;

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

  public static LoadFromEnvironmentInstruction with(int n, int i) {
    LoadFromEnvironmentInstruction instruction = new LoadFromEnvironmentInstruction();
    instruction.frameIndex = n;
    instruction.variableIndex = i;
    return instruction;
  }
}
