package com.stanfy.icfp2014;

import rx.Observable;

import java.util.stream.IntStream;

class RemoveMe {

  Observable<Integer> intRx() {
    return Observable.from(1, 2, 3)
        .filter((v) -> v >= 2);
  }

  IntStream intStream() {
    return IntStream.of(4, 5, 6)
        .map((v) -> v * 2);
  }

}
