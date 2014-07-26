package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by hdf on 26.07.14.
 */
public class STInstruction implements LambdaManProcessorInstruction {
  public int frameIndex;
  public int variableIndex;

  public STInstruction(int frameIndex, int variableIndex) {
    this.frameIndex = frameIndex;
    this.variableIndex = variableIndex;
  }

/*
  $fp := %e
  while $n > 0 do            ; follow chain of frames to get n'th frame
  begin
    $fp := FRAME_PARENT($fp)
    $n := $n-1
  end
  if FRAME_TAG($fp) == TAG_DUM then FAULT(FRAME_MISMATCH)
  $v,%s := POP(%s)           ; pop value from the data stack
  FRAME_VALUE($fp, $i) := $v ; modify i'th element of frame
  %c := %c+1

 */

  @Override
  public InstructionResult processOn(LambdaManProcessor processor) {
    EnvironmentFrame fp = processor.e;
    int n = frameIndex;
    while (n > 0)  {
      fp = fp.parent;
      n--;
    }
    if (fp.isDummy) {
      return InstructionResult.FAILURE_FRAME_MISMATCH;
    }
    Object v = processor.popStackValue();
    fp.items.set(variableIndex, v);

    processor.c += 1;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "ST " + frameIndex + " " + variableIndex;
  }
}
