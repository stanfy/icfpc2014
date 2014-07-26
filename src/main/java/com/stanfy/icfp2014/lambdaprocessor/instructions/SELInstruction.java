package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
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

//  $x,%s := POP(%s)
//  if TAG($x) != TAG_INT then FAULT(TAG_MISMATCH)
//  %d := PUSH(SET_TAG(TAG_JOIN,%c+1),%d)   ; save the return address
//  if $x == 0 then
//  %c := $f
//  else
//      %c := $t

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    Integer jumpAddress = trueBranchAddress;

    Object x = processor.popStackValue();
    if (!(x instanceof Integer)) {
      return InstructionResult.FAILURE_TAG_MISMATCH;
    }
    if ((Integer) x == 0) {
      jumpAddress = falseBranchAddress;
    }
    processor.d.add(processor.c + 1);
    processor.c = jumpAddress;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "SEL " + trueBranchAddress + " " + falseBranchAddress;
  }

}
