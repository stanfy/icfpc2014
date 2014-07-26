package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Cons;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ConsInstruction implements LambdaManProcessorInstruction {
//  $y,%s := POP(%s)
//  $x,%s := POP(%s)
//  $z := ALLOC_CONS($x,$y)
//  %s := PUSH(SET_TAG(TAG_CONS,$z),%s)
//  %c := %c+1
  @Override
  public void processOn(LambdaManProcessor processor) {
    Object y =  processor.popStackValue();
    Object x = processor.popStackValue();
    processor.pushStackValue(new Cons(x, y));
    processor.c +=1;
  }

  @Override
  public String textRepresentation() {
    return "CONS";
  }
}
