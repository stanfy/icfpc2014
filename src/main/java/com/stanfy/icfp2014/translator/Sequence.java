package com.stanfy.icfp2014.translator;

import java.util.ArrayList;
import java.util.List;

class Sequence implements Statement {

  private ArrayList<Statement> commands;
  private ArrayList<Reference> references;

  private int size;

  public void add(final Statement stmt) {
    if (stmt instanceof Function) {
      addReference((Function) stmt);
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

  private void addReference(final Reference ref) {
    if (references == null) {
      references = new ArrayList<>();
    }
    references.add(ref);
  }

  public int size() {
    return size;
  }

  @Override
  public String asm() {
    if (references != null) {
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
    int endOffset = resolveReferencesOffset(references, startOffset + size);

    int offset = startOffset;
    for (Statement cmd : commands) {
      cmd.resolveLabels(offset);
      if (cmd instanceof Sequence) {
        offset += ((Sequence) cmd).size;
      } else if (!cmd.ignored()) {
        offset++;
      }
    }

    if (references != null) {
      commands.addAll(references);
    }
    references = null;
    size = endOffset - startOffset;
  }

  private static int resolveReferencesOffset(final List<Reference> refs, int offset) {
    if (refs == null) {
      return offset;
    }
    for (Reference st : refs) {
      st.resolveLabels(offset);
      offset += ((Sequence) st).size;
    }
    return offset;
  }

}
