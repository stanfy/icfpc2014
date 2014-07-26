package com.stanfy.icfp2014.translator.listeners.models;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class EnvironmentFrameAllocationInstruction implements ECMATranslatable {
  private int size;

  public EnvironmentFrameAllocationInstruction(int size) {
    this.size = size;
  }

  @Override
  public String translate() {
    return "DUM " + size;
  }
}
