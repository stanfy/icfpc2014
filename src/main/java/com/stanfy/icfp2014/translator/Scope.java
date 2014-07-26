package com.stanfy.icfp2014.translator;

import java.util.HashMap;

class Scope {

  private final HashMap<String, Integer> vars = new HashMap<>();
  private final HashMap<String, Function> functions = new HashMap<>();

  private final Scope parent;

  private final String name;

  public Scope(String name) {
    this.parent = null;
    this.name = name;
  }
  private Scope(String name, Scope parent) {
    this.name = name;
    this.parent = parent;
  }

  public void var(final String name, final int address) {
    vars.put(name, address);
  }

  public int varIndex(final String name) {
    Scope scope = this;
    while (scope != null) {
      Integer result = scope.vars.get(name);
      if (result != null) {
        return result;
      }
      scope = scope.parent;
    }
    throw new IllegalStateException(name + " is not resolved");
  }

  public int varFrame(final String name) {
    Scope scope = this;
    int i = 0;
    while (scope != null) {
      if (scope.vars.containsKey(name)) {
        return i;
      }
      i++;
      scope = scope.parent;
    }
    return -1;
  }

  public void function(final Function func) {
    functions.put(func.name, func);
  }

  public Function function(final String name) {
    Scope scope = this;
    while (scope != null) {
      Function result = scope.functions.get(name);
      if (result != null) {
        return result;
      }
      scope = scope.parent;
    }
    return null;
  }

  public Scope push(String name) {
    return new Scope(name, this);
  }

  public Scope pop() {
    return parent;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    Scope scope = this;
    while (scope != null) {
      result.insert(0, ">").insert(0, scope.name);
      scope = scope.parent;
    }
    return result.toString();
  }

}
