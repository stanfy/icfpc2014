package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by hdf on 26.07.14.
 */
public class DBUGInstruction implements LambdaManProcessorInstruction {

  /*
  * Synopsis: If tracing is enabled, suspend execution and raise a trace
          interrupt on the main processor. The main processor will read
          the value and resume co-processor execution. On resumption
          the value will be popped from the data stack. If tracing is not
          enabled the value is popped from the data stack and discarded.
          */

//  $x,%s := POP(%s)
//  %c := %c+1

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    Object x = processor.popStackValue();
    System.out.println("DBUG x = " + x);
    processor.c +=1;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "DBUG";
  }
}