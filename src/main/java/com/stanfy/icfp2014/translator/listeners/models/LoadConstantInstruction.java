package com.stanfy.icfp2014.translator.listeners.models;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LoadConstantInstruction implements ECMATranslatable {

  private String constant;

  public LoadConstantInstruction(String constant) {
    this.constant = constant;
  }

  @Override
  public String translate() {
    return "LDC " + constant;
  }
}
