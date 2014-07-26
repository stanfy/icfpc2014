package com.stanfy.icfp2014.lambdaprocessor.instructions;

import com.stanfy.icfp2014.lambdaprocessor.LambdaManProcessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public interface LambdaManProcessorInstruction {

  void processOn(LambdaManProcessor processor);

  String textRepresentation();
}
