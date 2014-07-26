package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * pop a stack pointer, return address and environment frame
 pointer off of the control stack;
 restore the stack and environment;
 jump to the return address
 * Created by ptaykalo on 7/26/14.
 */
public class ReturnFunctionInstruction implements LambdaManProcessorInstruction {
  @Override
  public void processOn(LambdaManProcessor processor) {
    Integer x = (Integer) processor.d.remove(processor.d.size() - 1);
    // TODO Machine stop check
    EnvironmentFrame y = (EnvironmentFrame) processor.d.remove(processor.d.size() - 1);
    processor.e = y;
    processor.c = x;
  //    $x,%d := POP(%d)            ; pop return address
  //    if TAG($x) == TAG_STOP then MACHINE_STOP
  //    if TAG($x) != TAG_RET then FAULT(CONTROL_MISMATCH)
  //        $y,%d := POP(%d)            ; pop frame pointer
  //        %e := $y                    ; restore environment
  //    %c := $x                    ; jump to return address
  }

  @Override
  public String textRepresentation() {
    return "RTN";
  }
}
