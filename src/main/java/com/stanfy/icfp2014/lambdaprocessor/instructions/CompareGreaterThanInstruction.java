package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CompareGreaterThanInstruction implements LambdaManProcessorInstruction {

//  $y,%s := POP(%s)
//  $x,%s := POP(%s)
//  if TAG($x) != TAG_INT then FAULT(TAG_MISMATCH)
//  if TAG($y) != TAG_INT then FAULT(TAG_MISMATCH)
//  if $x > $y then
//  $z := 1
//      else
//  $z := 0
//      %s := PUSH(SET_TAG(TAG_INT,$z),%s)
//      %c := %c+1

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    Integer y = (Integer) processor.popStackValue();
    Integer x = (Integer) processor.popStackValue();
    if (x == null || y == null || !(x instanceof Integer) || !(y instanceof Integer)) {
      return InstructionResult.FAILURE_TAG_MISMATCH;
    }

    Integer z = x.intValue() > y.intValue() ? 1 : 0;
        processor.pushStackValue(z);
    processor.c +=1;

    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "CGT";
  }

}
