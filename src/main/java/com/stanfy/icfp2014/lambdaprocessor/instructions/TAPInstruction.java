package com.stanfy.icfp2014.lambdaprocessor.instructions;

/**
 * Created by hdf on 26.07.14.
 */

import com.stanfy.icfp2014.lambdaprocessor.Closure;
import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

public class TAPInstruction implements LambdaManProcessorInstruction {

  public int argumensCount;

  public TAPInstruction(int argumensCount) {
    this.argumensCount = argumensCount;
  }

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
/**
 *
 $x,%s := POP(%s)            ; get and examine function closure
 if TAG($x) != TAG_CLOSURE then FAULT(TAG_MISMATCH)
 $f := CAR_CLOSURE($x)
 $e := CDR_CLOSURE($x)
 $fp := ALLOC_FRAME($n)      ; create a new frame for the call
 FRAME_PARENT($fp) := $e
 $i := $n-1
 while $i != -1 do            ; copy n values from the stack into the frame in reverse order
 begin
 $y,%s := POP(%s)
 FRAME_VALUE($fp,$i) := $y
 $i := $i-1
 end
 %e := $fp                   ; establish new environment
 %c := $f                    ; jump to function
 Notes:
 This instruction is the same as AP but it does not push a return address

 */
    Closure x = (Closure) processor.popStackValue();
    if (!(x instanceof Closure)) {
      return InstructionResult.FAILURE_TAG_MISMATCH;
    }
    int f = x.address;
    EnvironmentFrame e = x.frame;
    EnvironmentFrame fp = new EnvironmentFrame();
    fp.parent = e;
    int i = argumensCount - 1;

    while (i != -1)  {
      Object y = processor.popStackValue();
      fp.items.add(0,y);
      i--;
    }
    processor.e = fp;
    processor.c = f;
    return InstructionResult.SUCCESS;
  }


  @Override
  public String textRepresentation() {
    return "TAP " + argumensCount;
  }
}
