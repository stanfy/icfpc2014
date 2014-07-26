package com.stanfy.icfp2014.translator;

import java.util.ArrayList;
import java.util.List;

class Sequence implements Statement {

  private ArrayList<Statement> commands;
  private ArrayList<Function> functions;

  private int size;

  public void add(final Statement stmt) {
    if (stmt instanceof Function) {
      addFunction((Function) stmt);
    } else {
      addCommand(stmt);
    }
  }

  void addCommand(final Statement stmt) {
    if (commands == null) {
      commands = new ArrayList<>();
    }
    commands.add(stmt);

    if (stmt instanceof Sequence) {
      size += ((Sequence) stmt).size;
    } else if (!stmt.ignored()) {
      size++;
    }
  }

  private void addFunction(final Function func) {
    if (functions == null) {
      functions = new ArrayList<>();
    }
    functions.add(func);
  }

  public int size() {
    return size;
  }

  @Override
  public String asm() {
    if (functions != null) {
      throw new IllegalStateException("unresolved");
    }
    StringBuilder result = new StringBuilder();
    commands.forEach((s) -> result.append(s.asm()).append("\n"));
    if (result.length() > 0) {
      result.delete(result.length() - 1, result.length());
    }
    return result.toString();
  }

  @Override
  public void resolveLabels(int startOffset) {
    int endOffset = resolveFunctionsOffset(functions, startOffset + size);

    int offset = startOffset;
    for (Statement cmd : commands) {
      cmd.resolveLabels(offset);
      if (cmd instanceof Sequence) {
        offset += ((Sequence) cmd).size;
      } else {
        offset++;
      }
    }

    if (functions != null) {
      commands.addAll(functions);
    }
    functions = null;
    size = endOffset - startOffset;
  }

  private static int resolveFunctionsOffset(final List<Function> funcs, int offset) {
    if (funcs == null) {
      return offset;
    }
    for (Function st : funcs) {
      st.resolveLabels(offset);
      offset += ((Sequence) st).size;
    }
    return offset;
  }

}
