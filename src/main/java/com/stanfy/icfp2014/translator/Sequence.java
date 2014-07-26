package com.stanfy.icfp2014.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Sequence implements Statement {

  private final ArrayList<Statement> commands = new ArrayList<>();

  final Map<String, Integer> funcLocations = new HashMap<>();

  private int resolvedOffset = -1;

  private int size;

  int offset;

  public void add(final Statement stmt) {
    commands.add(stmt);
    if (stmt instanceof Function) {
      funcLocations.put(((Function) stmt).name, size);
    }
    if (stmt instanceof Sequence) {
      ((Sequence) stmt).offset = size;
      size += ((Sequence) stmt).size;
    } else if (!stmt.ignored()) {
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

  @Override
  public void resolve(Map<String, Integer> addresses, int offset) {
    if (offset == resolvedOffset) {
      return;
    }
    resolvedOffset = offset;
    commands.forEach((cmd) -> {
      if (cmd instanceof Sequence) {
        ((Sequence) cmd).resolveSelf(offset);
      } else {
        cmd.resolve(addresses, offset + this.offset);
      }
    });
  }

  void resolveSelf(int offset) {
    resolve(funcLocations, offset);
  }

}
