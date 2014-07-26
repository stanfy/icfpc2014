package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class AddInstruction implements LambdaManProcessorInstruction{
  @Override
  public boolean processOn(LambdaManProcessor processor) {
//    $y,%s := POP(%s)
//    $x,%s := POP(%s)
//    if TAG($x) != TAG_INT then FAULT(TAG_MISMATCH)
//    if TAG($y) != TAG_INT then FAULT(TAG_MISMATCH)
//        $z := $x + $y
//        %s := PUSH(SET_TAG(TAG_INT,$z),%s)
//    %c := %c+1
    Integer y = (Integer) processor.popStackValue();
    Integer x = (Integer) processor.popStackValue();
    if (x == null || y == null || !(x instanceof Integer) || !(y instanceof Integer)) {
      return false;
    }
    Integer z = x + y;
    processor.pushStackValue(z);
    processor.c +=1;
    return true;
  }

  @Override
  public String textRepresentation() {
    return "ADD";
  }
}
