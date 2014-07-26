package com.stanfy.icfp2014.translator;

import java.util.concurrent.atomic.AtomicInteger;

class Function extends Sequence {

  private static final AtomicInteger COUNTER = new AtomicInteger(0);

  final String name;

  private Function(String name) {
    this.name = name;
  }

  public static Function create(Statement body) {
    Function f = new Function("fn".concat(String.valueOf(COUNTER.getAndIncrement())));
    f.add(body);
    f.add(NoArgs.RTN);
    return f;
  }

}
