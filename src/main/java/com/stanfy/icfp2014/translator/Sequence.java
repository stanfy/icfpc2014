package com.stanfy.icfp2014.translator;

import java.util.ArrayList;

class Sequence implements Statement {

  private final ArrayList<Statement> commands = new ArrayList<>();

  private int size;

  public void add(final Statement stmt) {
    commands.add(stmt);
    if (!stmt.ignored()) {
      size++;
    }
  }

  public int size() {
    return size;
  }

  @Override
  public String asm() {
    StringBuilder result = new StringBuilder();
    commands.forEach((s) -> result.append(s.asm()).append("\n"));
    if (result.length() > 0) {
      result.delete(result.length() - 1, result.length());
    }
    return result.toString();
  }

}
