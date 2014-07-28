package com.stanfy.icfp2014.translator;

import java.util.concurrent.atomic.AtomicInteger;

import static com.stanfy.icfp2014.translator.Statement.NoArgs.RTN;

class Function extends Reference {

  private static final AtomicInteger COUNTER = new AtomicInteger();

  final String name;
  final int argsCount;
  public int additionalArgsCount;

  Function(String name, int argsCount) {
    this.name = name;
    this.argsCount = argsCount;
  }

  Function(int argsCount) {
    this("___func_".concat(String.valueOf(COUNTER.incrementAndGet())), argsCount);
  }

  @Override
  protected String comment() {
    return "func " + name + ", " + super.comment();
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
