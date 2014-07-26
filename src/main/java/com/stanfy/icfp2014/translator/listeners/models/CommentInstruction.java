package com.stanfy.icfp2014.translator.listeners.models;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class CommentInstruction implements ECMATranslable {
  private String comment;

  public CommentInstruction(String comment) {
    this.comment = comment;
  }

  @Override
  public String translate() {
    return " ; " + comment;
  }
}
