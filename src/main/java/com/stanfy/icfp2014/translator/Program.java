package com.stanfy.icfp2014.translator;

class Program extends Sequence {

  private int pc;

  public void add(final Statement stmt) {
    super.add(stmt);
    if (stmt instanceof Sequence) {
      pc += ((Sequence) stmt).size();
    } else if (!stmt.ignored()) {
      pc++;
    }
  }

  public int programCounter() {
    return pc;
  }

}
