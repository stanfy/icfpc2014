package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by hdf on 26.07.14.
 */
public class TSELInstruction implements LambdaManProcessorInstruction {
    public int trueBranchAddress;
    public int falseBranchAddress;

    public TSELInstruction(int trueBranchAddress, int falseBranchAddress) {
        this.trueBranchAddress = trueBranchAddress;
        this.falseBranchAddress = falseBranchAddress;
    }

//  $x,%s := POP(%s)
//  if TAG($x) != TAG_INT then FAULT(TAG_MISMATCH)
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
      processor.c = jumpAddress;
      return InstructionResult.SUCCESS;
    }

    @Override
    public String textRepresentation() {
        return "TSEL " + trueBranchAddress + " " + falseBranchAddress;
    }

}