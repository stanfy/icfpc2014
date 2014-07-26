package com.stanfy.icfp2014.translator;

class Function extends Sequence {

  final String name;
  final int argsCount;

  private int address = -1;

  private Function(String name, int argsCount) {
    this.name = name;
    this.argsCount = argsCount;
  }

  public static Function create(String name, String[] argNames, Statement body) {
    Function f = new Function(name, argNames.length);
    f.add(body);
    f.add(NoArgs.RTN);
    return f;
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
