package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Closure;
import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CallFunctionInstruction implements LambdaManProcessorInstruction {

  public int argumensCount;

  public CallFunctionInstruction(int argumensCount) {
    this.argumensCount = argumensCount;
  }

  @Override
  public boolean processOn(LambdaManProcessor processor) {
/**
 *  $x,%s := POP(%s)            ; get and examine function closure
 if TAG($x) != TAG_CLOSURE then FAULT(TAG_MISMATCH)
 $f := CAR_CLOSURE($x)
 $e := CDR_CLOSURE($x)
 $fp := ALLOC_FRAME($n)      ; create a new frame for the call
 FRAME_PARENT($fp) := $e
 $i := $n-1
 while $i != -1 do           ; copy n values from the stack into the frame in reverse order
 begin
 $y,%s := POP(%s)
 FRAME_VALUE($fp,$i) := $y
 $i := $i-1
 end
 %d := PUSH(%e,%d)                     ; save frame pointer
 %d := PUSH(SET_TAG(TAG_RET,%c+1),%d)  ; save return address
 %e := $fp                             ; establish new environment
 %c := $f                              ; jump to function

 */
    Closure x = (Closure) processor.popStackValue();
    if (!(x instanceof Closure)) {
      return false;
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
    processor.d.add(e);
    processor.d.add(processor.c + 1); // Address of return
    processor.e = fp;
    processor.c = f;
  }


  @Override
  public String textRepresentation() {
    return "AP " + argumensCount;
  }
}
