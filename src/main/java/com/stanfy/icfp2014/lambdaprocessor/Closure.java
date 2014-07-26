package com.stanfy.icfp2014.lambdaprocessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class Closure {
  public int address;
  public EnvironmentFrame frame;

  public Closure(int address, EnvironmentFrame frame) {
    this.address = address;
    this.frame = frame;
  }
}
