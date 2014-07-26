package com.stanfy.icfp2014.translator;

import java.util.HashMap;
import java.util.Map;

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

  @Override
  public String asm() {
    resolveSelf(0);
    return super.asm();
  }

  public int programCounter() {
    return pc;
  }

}
