package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class JoinInstruction implements LambdaManProcessorInstruction{

//  $x,%d := POP(%d)
//  if TAG($x) != TAG_JOIN then FAULT(CONTROL_MISMATCH)
//  %c := $x

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    Integer d = (Integer) processor.popStackValue();
    processor.c = d;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "JOIN";
  }
}
