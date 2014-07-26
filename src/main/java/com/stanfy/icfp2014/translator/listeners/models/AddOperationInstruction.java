package com.stanfy.icfp2014.translator.listeners.models;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class AddOperationInstruction implements ECMATranslable{
  @Override
  public String translate() {
    return "ADD";
  }
}
