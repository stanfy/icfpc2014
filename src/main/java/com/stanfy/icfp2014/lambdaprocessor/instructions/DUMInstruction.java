package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.EnvironmentFrame;
import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class DUMInstruction implements LambdaManProcessorInstruction {
  public int size;

  public DUMInstruction(int size) {
    this.size = size;
  }

  @Override
  public void processOn(LambdaManProcessor processor) {
//    $fp := ALLOC_FRAME($n)       ; create a new empty frame of size $n
//    FRAME_PARENT($fp) := %e      ; set its parent frame
//    FRAME_TAG($fp) := TAG_DUM    ; mark the frame as dummy
//        %e := $fp                    ; set it as the new environment frame
//        %c := %c+1
    EnvironmentFrame fp = new EnvironmentFrame();
    fp.parent = processor.e;
    processor.e = fp;
    processor.c += 1;
  }

  @Override
  public String textRepresentation() {
    return "DUM " + size;
  }
}
