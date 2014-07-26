package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Closure;
import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by hdf on 26.07.14.
 */
public class TRAPInstruction implements LambdaManProcessorInstruction {

  public int argumensCount;

  public TRAPInstruction(int argumensCount) {
    this.argumensCount = argumensCount;
  }

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
     /*

  $x,%s := POP(%s)            ; get and examine function closure
  if TAG($x) != TAG_CLOSURE then FAULT(TAG_MISMATCH)
  $f := CAR_CLOSURE($x)
  $fp := CDR_CLOSURE($x)
  if FRAME_TAG(%e) != TAG_DUM then FAULT(FRAME_MISMATCH)
  if FRAME_SIZE(%e) != $n then FAULT(FRAME_MISMATCH)
  if %e != $fp then FAULT(FRAME_MISMATCH)
  $i := $n-1
  while $i != -1 do            ; copy n values from the stack into the empty frame in reverse order
  begin
    $y,%s := POP(%s)
    FRAME_VALUE($fp,$i) := $y
    $i := $i-1
  end
  FRAME_TAG($fp) := !TAG_DUM
  %e := $fp                   ; establish new environment
  %c := $f                    ; jump to function
Notes:
  This instruction is the same as RAP but it does not push a return address

      */

    Closure x = (Closure) processor.popStackValue();
    if (!(x instanceof Closure)) {
      return InstructionResult.FAILURE_TAG_MISMATCH;
    }
    int f = x.address;
    EnvironmentFrame fp = x.frame;
    if (!(fp.isDummy)) {
      return InstructionResult.FAILURE_FRAME_MISMATCH;
    }

    // TODO: check if FRAME_SIZE(%e) != $n then FAULT(FRAME_MISMATCH)

    EnvironmentFrame e = processor.e;
    if (e != fp) {
      return InstructionResult.FAILURE_FRAME_MISMATCH;
    }
    int i = argumensCount;
    while (i != -1) {
      Object y = processor.popStackValue();
      fp.items.add(0, y);
      i--;
    }
    fp.isDummy = false;
    processor.e = fp;
    processor.c = f;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "TRAP " + argumensCount;
  }

}