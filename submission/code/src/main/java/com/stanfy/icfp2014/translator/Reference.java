package com.stanfy.icfp2014.translator;

class Reference extends Sequence {

  private int address = -1;
  private String additionalComment;

  protected String comment() {
    return "address " + getAddress() + (additionalComment == null ? "" :  " " + additionalComment);
  }

  public Reference() {
    this(false);
  }

  public Reference(boolean noComment) {
    if (!noComment) {
      super.add(Statement.comment(this::comment));
    }
  }

  public Reference(String additionalComment) {
    if (additionalComment != null) {
      this.additionalComment = additionalComment;
      super.add(Statement.comment(this::comment));
    }
  }

  @Override
  public void resolveLabels(int startOffset) {
    this.address = startOffset;
    super.resolveLabels(startOffset);
  }

  public int getAddress() {
    if (address == -1) {
      throw new IllegalStateException("unresolved");
    }
    return address;
  }

}
