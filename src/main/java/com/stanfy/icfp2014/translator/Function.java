package com.stanfy.icfp2014.translator;

import static com.stanfy.icfp2014.translator.Statement.NoArgs.RTN;

class Function extends Reference {

  final String name;
  final int argsCount;

  Function(String name, int argsCount) {
    this.name = name;
    this.argsCount = argsCount;
  }

  public void setBody(final Statement stmt) {
    super.add(stmt);
    super.add(RTN);
  }

  @Override
  public void add(Statement stmt) {
    throw new UnsupportedOperationException();
  }

}
