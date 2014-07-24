package com.stanfy.icfp2014;

/**
 * Entry point.
 */
public final class Main {

  private static void test() {
    RemoveMe foo = new RemoveMe();
    // RxJava
    foo.intRx().subscribe(System.out::println);

    // Java 8 streams
    foo.intStream().forEach(System.out::println);
  }

  public static void main(final String[] args) {
    test();
  }

}
