package com.stanfy.icfp2014.translator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

interface Statement {

  String asm();

  default boolean ignored() { return false; }

  default void resolve(Map<String, Integer> adresses, int offset) { }

  static Statement comment(final String comment) {
    return new Ignored("; ".concat(comment));
  }

  static Statement emptyLine() {
    return Ignored.EMPTY;
  }

  // ======= Instructions =======

  static Statement ldc(final int n) {
    return () -> "LDC ".concat(String.valueOf(n));
  }

  static Statement ld(final int n, final int i) {
    return () -> "LD " + n + " " + i;
  }

  static Statement sel(final int t, final int f) {
    return () -> "SEL " + t + " " + f;
  }
  static Statement sel(final Function t, final Function f) {
    return new Postponed("SEL", t.name, f.name);
  }

  static Statement ldf(final int f) {
    return () -> "LDF ".concat(String.valueOf(f));
  }

  static Statement ap(final int n) {
    return () -> "AP ".concat(String.valueOf(n));
  }

  static Statement dum(final int n) {
    return () -> "DUM ".concat(String.valueOf(n));
  }

  static Statement rap(final int n) {
    return () -> "RAP ".concat(String.valueOf(n));
  }

  // =========== Tail call extensions ==========
  static Statement tsl(final int t, final int f) {
    return () -> "TSEL " + t + " " + f;
  }

  static Statement tap(final int n) {
    return () -> "TAP ".concat(String.valueOf(n));
  }

  static Statement trap(final int n) {
    return () -> "TRAP ".concat(String.valueOf(n));
  }

  enum NoArgs implements Statement {
    /** Normal. */
    ADD, SUB, MUL, DIV, CEQ, CGT, CGTE, ATOM, CONS, CAR, CDR, JOIN, RTN, STOP,

    /** Debug extension. */
    DEBUG;

    @Override
    public String asm() {
      return toString();
    }
  }

  /** Comment, labels, etc. */
  static class Ignored implements Statement {

    static final Ignored EMPTY = new Ignored("");

    private final String body;

    private Ignored(String body) {
      this.body = body;
    }

    @Override
    public boolean ignored() {
      return true;
    }

    @Override
    public String asm() {
      return body;
    }
  }

  static class Postponed implements Statement {

    private final String instruction;
    private final List<String> args;
    private final List<Integer> resolvedArgs;

    Postponed(String instruction, String... args) {
      this.instruction = instruction;
      if (args.length == 0) {
        throw new IllegalArgumentException("no args!");
      }
      this.args = Arrays.asList(args);
      this.resolvedArgs = new ArrayList<>(args.length);
    }

    @Override
    public String asm() {
      if (resolvedArgs.size() != args.size()) {
        throw new IllegalStateException("not resolved");
      }
      StringBuilder result = new StringBuilder();
      result.append(instruction);
      for (Integer arg : resolvedArgs) {
        result.append(' ').append(arg);
      }
      return result.toString();
    }

    @Override
    public void resolve(Map<String, Integer> addresses, int offset) {
      resolvedArgs.clear();
      args.forEach((arg) -> resolvedArgs.add(addresses.get(arg) + offset));
    }

  }

}
