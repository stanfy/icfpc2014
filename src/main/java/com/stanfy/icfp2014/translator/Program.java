package com.stanfy.icfp2014.translator;

class Program extends Sequence {

  public void add(final Statement stmt) {
    if (stmt instanceof Function) {
      if ("main".equals(((Function) stmt).name)) {
        // this is the main function, "unwrap" it
        addCommand(stmt);
        return;
      }
    }

    super.add(stmt);
  }

}
