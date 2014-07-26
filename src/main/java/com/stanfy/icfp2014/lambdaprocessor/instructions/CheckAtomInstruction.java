package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CheckAtomInstruction implements LambdaManProcessorInstruction {

//  $x,%s := POP(%s)
//  if TAG($x) == TAG_INT then
//  $y := 1
//      else
//  $y := 0
//      %s := PUSH(SET_TAG(TAG_INT,$y),%s)
//      %c := %c+1

  @Override
  public boolean processOn(LambdaManProcessor processor) {
    Object x =  processor.popStackValue();
    if (x == null) {
      return false;
    }
    Integer z = x instanceof Integer ? 1 : 0;
    processor.pushStackValue(z);
    processor.c +=1;
    return true;

  }

  @Override
  public String textRepresentation() {
    return "ATOM";
  }

}
