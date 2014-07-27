package com.stanfy.icfp2014.translator;

import java.util.ArrayList;
import java.util.HashMap;

public class Scope {

  private final HashMap<String, Integer> vars = new HashMap<>();
  private final HashMap<String, Function> functions = new HashMap<>();
  public final ArrayList<String> declaredVariables = new ArrayList<>();


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
  public void declareVariable(final String name) {vars.put(name, 0); declaredVariables.add(name);}
  public boolean hasDeclaredVariables(){return declaredVariables.size() != 0;}

  public VarLocation var(final String name) {
    Scope scope = this;
    int frame = 0;
    while (scope != null) {
      Integer index = scope.vars.get(name);
      if (index != null) {
        return new VarLocation(frame, index);
      }
      frame++;
      scope = scope.parent;
    }
    return null;
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

  static class VarLocation {
    final int frame;
    final int index;

    VarLocation(int frame, int index) {
      this.frame = frame;
      this.index = index;
    }
  }

}
