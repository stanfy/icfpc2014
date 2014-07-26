package com.stanfy.icfp2014.lambdaprocessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public enum InstructionResult {
  /** Normal. */
  SUCCESS,

  FAILURE_TAG_MISMATCH,

  FAILURE_FRAME_MISMATCH,

  FAILURE_CONTROL_MISMATCH,

  MACHINE_STOP,

}
