package com.stanfy.icfp2014.translator;

public class Program extends Sequence {

  public void add(final Statement stmt) {
    if (stmt instanceof Function) {
      if ("main".equals(((Function) stmt).name)) {
        // this is the main function, "unwrap" it
        addCommand(stmt);
        return;
      }
    }

    // ECMASCript
    if (stmt instanceof Sequence) {
      Sequence seq = (Sequence) stmt;
      if (seq.references != null  && seq.references.size() > 0 && seq.references.get(0) instanceof Function) {
        Function f = (Function) seq.references.get(0);
        if ("main".equals(f.name)) {
          // this is the main function, "unwrap" it
          addCommandAtStart(seq);
          return;
        }
      }
    }


    super.add(stmt);
  }

}
