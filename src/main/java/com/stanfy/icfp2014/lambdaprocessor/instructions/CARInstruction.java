package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.Cons;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CARInstruction implements LambdaManProcessorInstruction {

//  $x,%s := POP(%s)
//  if TAG($x) != TAG_CONS then FAULT(TAG_MISMATCH)
//  $y := CAR($x)
//  %s := PUSH($y,%s)
//  %c := %c+1
  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    Object x = processor.popStackValue();
    if (!(x instanceof Cons)) {
      return InstructionResult.FAILURE_TAG_MISMATCH;
    }

    Object y = ((Cons) x).first;
    processor.pushStackValue(y);
    processor.c += 1;

    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "CAR";
  }
}
