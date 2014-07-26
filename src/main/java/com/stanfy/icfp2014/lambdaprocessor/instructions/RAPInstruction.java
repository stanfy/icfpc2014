package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Closure;
import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 * Synopsis: pop a pointer to a CLOSURE cell off the data stack;
 the current environment frame pointer must point to an empty
 frame of size $n;
 fill the empty frame's body with $n values from the data stack;
 save the parent pointer of the current environment frame
 and return address to the control stack;
 set the current environment frame pointer to the environment
 frame pointer from the CLOSURE cell;
 jump to the code address from the CLOSURE cell;
 */
public class RAPInstruction implements LambdaManProcessorInstruction {

  public int argumensCount;

  public RAPInstruction(int argumensCount) {
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
  while $i != -1 do           ; copy n values from the stack into the empty frame in reverse order
  begin
    $y,%s := POP(%s)
    FRAME_VALUE($fp,$i) := $y
    $i := $i-1
  end
  $ep := FRAME_PARENT(%e)
  %d := PUSH($ep,%d)                    ; save frame pointer
  %d := PUSH(SET_TAG(TAG_RET,%c+1),%d)  ; save return address
  FRAME_TAG($fp) := !TAG_DUM            ; mark the frame as normal
  %e := $fp                             ; establish new environment
  %c := $f                              ; jump to function

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
    EnvironmentFrame ep = processor.e.parent;

    processor.d.add(ep);
    processor.d.add(processor.c + 1);

    fp.isDummy = false;
    processor.e = fp;
    processor.c = f;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "RAP " + argumensCount;
  }

}
