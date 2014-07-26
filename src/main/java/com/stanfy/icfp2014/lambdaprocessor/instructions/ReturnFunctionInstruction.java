package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;
import com.stanfy.icfp2014.lambdaprocessor.TAGSTOP;

/**
 * pop a stack pointer, return address and environment frame
 pointer off of the control stack;
 restore the stack and environment;
 jump to the return address
 * Created by ptaykalo on 7/26/14.
 */
public class ReturnFunctionInstruction implements LambdaManProcessorInstruction {
  //    $x,%d := POP(%d)            ; pop return address
  //    if TAG($x) == TAG_STOP then MACHINE_STOP
  //    if TAG($x) != TAG_RET then FAULT(CONTROL_MISMATCH)
  //    $y,%d := POP(%d)            ; pop frame pointer
  //    %e := $y                    ; restore environment
  //    %c := $x                    ; jump to return address

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    Object o = processor.popControlValue();
    if (o instanceof TAGSTOP) {
      return InstructionResult.MACHINE_STOP;
    }
    Integer x = (Integer) o;
    // TODO Control mismatch
    EnvironmentFrame y = (EnvironmentFrame) processor.popControlValue();
    processor.e = y;
    processor.c = x;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "RTN";
  }
}
