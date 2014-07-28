package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.InstructionResult;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LoadFromEnvironmentInstruction implements LambdaManProcessorInstruction {

  public int frameIndex;
  public int variableIndex;

  public LoadFromEnvironmentInstruction(int frameIndex, int variableIndex) {
    this.frameIndex = frameIndex;
    this.variableIndex = variableIndex;
  }

//  $fp := %e
//  while $n > 0 do            ; follow chain of frames to get n'th frame
//  begin
//    $fp := FRAME_PARENT($fp)
//    $n := $n-1
//  end
//  if FRAME_TAG($fp) == TAG_DUM then FAULT(FRAME_MISMATCH)
//  $v := FRAME_VALUE($fp, $i) ; i'th element of frame
//  %s := PUSH($v,%s)          ; push onto the data stack
//  %c := %c+1

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
    Object v = fp.items.get(variableIndex);

    processor.s.add(v);
    processor.c += 1;
    return InstructionResult.SUCCESS;
  }

  @Override
  public String textRepresentation() {
    return "LD " + frameIndex + " " + variableIndex;
  }

}
