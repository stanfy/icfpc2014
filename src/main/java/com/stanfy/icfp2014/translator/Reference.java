package com.stanfy.icfp2014.translator;

class Reference extends Sequence {

  private int address = -1;

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