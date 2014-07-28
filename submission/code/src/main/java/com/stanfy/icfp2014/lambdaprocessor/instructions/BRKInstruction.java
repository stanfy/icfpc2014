package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by hdf on 26.07.14.
 */
public class BRKInstruction implements LambdaManProcessorInstruction {

  /*
  Synopsis: If breakpoint debugging is enabled, suspend execution and raise
          a breakpoint interrupt on the main processor. The main processor
          may inspect the state of the co-processor and can resume
          execution. If breakpoint debugging is not enabled it has no
          effect.
  */

//  %c := %c+1

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    processor.c +=1;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {  return "BRK";  }
}
