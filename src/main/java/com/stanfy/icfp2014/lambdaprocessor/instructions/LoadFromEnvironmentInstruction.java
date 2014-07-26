package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
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

  @Override
  public void processOn(LambdaManProcessor processor) {
    EnvironmentFrame fp = processor.e;
    int n = frameIndex;
    while (n > 0)  {
          // follow chain of frames to get n'th frame
      fp = fp.parent;
      n--;
    }

    // null check
   //    if FRAME_TAG($fp) == TAG_DUM then FAULT(FRAME_MISMATCH)
    Object v = fp.items.get(variableIndex);
    processor.s.add(v);
    processor.c += 1;
  }

  @Override
  public String textRepresentation() {
    return "LD " + frameIndex + " " + variableIndex;
  }

}
