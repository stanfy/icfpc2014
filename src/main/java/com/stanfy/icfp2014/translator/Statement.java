package com.stanfy.icfp2014.translator;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

interface Statement {

  String asm();

  default boolean ignored() { return false; }

  default void resolveLabels(int offset) { }


  static Statement comment(final String comment) {
    return new Ignored("\n; ".concat(comment));
  }
  static Statement comment(final Supplier<String> comment) {
    return new Ignored(null) {
      @Override
      public String asm() {
        return "\n; ".concat(comment.get());
      }
    };
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
  static Statement st(final int n, final int i) {
    return () -> "ST " + n + " " + i;
  }

  static Statement sel(final IntSupplier t, final IntSupplier f) {
    return () -> "SEL " + t.getAsInt() + " " + f.getAsInt();
  }

  static Statement ldf(final IntSupplier address) {
    return () -> "LDF ".concat(String.valueOf(address.getAsInt()));
  }
  static Statement ldf(final IntSupplier address, final String comment) { return () -> "LDF ".concat(String.valueOf(address.getAsInt()) + " ; " + comment);
  }

  static Statement ap(final int n) {
    return () -> "AP ".concat(String.valueOf(n));
  }
  static Statement ap(final int n, final String comment) {
    return () -> "AP ".concat(String.valueOf(n) + "\t ;      " + comment);
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

  static Statement tsel(final IntSupplier t, final IntSupplier f) {
    return () -> "TSEL " + t.getAsInt() + " " + f.getAsInt();
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
    DBUG, BRK;

    @Override
    public String asm() {
      return toString();
    }
  }

  /** Comment, labels, etc. */
  static class Ignored implements Statement {

    static final Ignored EMPTY = new Ignored(";");

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
      return  body;
    }
  }

}
