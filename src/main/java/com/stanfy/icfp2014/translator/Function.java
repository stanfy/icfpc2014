package com.stanfy.icfp2014.translator;

class Function extends Reference {

  final String name;
  final int argsCount;

  private Function(String name, int argsCount) {
    this.name = name;
    this.argsCount = argsCount;
  }

  public static Function create(String name, String[] argNames, Statement body) {
    Function f = new Function(name, argNames.length);
    f.add(body);
    f.add(NoArgs.RTN);
    return f;
  }

}
