package com.stanfy.icfp2014.translator;

import java.util.concurrent.atomic.AtomicInteger;

import static com.stanfy.icfp2014.translator.Statement.NoArgs.RTN;

class Function extends Reference {

  private static final AtomicInteger COUNTER = new AtomicInteger();

  final String name;
  final int argsCount;

  Function(String name, int argsCount) {
    this.name = name;
    this.argsCount = argsCount;
    super.add(Statement.comment(() -> "func " + name + ", address " + getAddress()));
  }

  Function(int argsCount) {
    this("___func_".concat(String.valueOf(COUNTER.incrementAndGet())), argsCount);
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
