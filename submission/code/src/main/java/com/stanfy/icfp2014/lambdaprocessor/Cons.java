package com.stanfy.icfp2014.lambdaprocessor;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class Cons {
  public Object first;
  public Object second;

  public Cons(Object first, Object second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return "("+first+", "+second+")";
  }

  public int getSize() {
    if (first == null) {
      return 0;
    }
    if (second == null) {
      return 1;
    }
    if (second instanceof Cons) {
      Cons n = (Cons) second;
      return 1 + n.getSize();
    }
    return 1;
  }
}
