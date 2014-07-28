package com.stanfy.icfp2014.translator;

import okio.Buffer;
import okio.Source;

/**
 * Translation result.
 */
public class Result {

  private final Buffer code;

  private final int programLength;

  Result(Buffer code, int programLength) {
    this.code = code;
    this.programLength = programLength;
  }

  public Source getCode() {
    return code;
  }

  public int getProgramLength() {
    return programLength;
  }

}
