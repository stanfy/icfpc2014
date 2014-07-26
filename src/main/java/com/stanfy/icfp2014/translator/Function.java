package com.stanfy.icfp2014.translator;

class Function extends Sequence {

  final String name;

  Function(final String name, final String description) {
    this.name = name;
    add(Statement.comment(name + " - " + description));
  }

}
