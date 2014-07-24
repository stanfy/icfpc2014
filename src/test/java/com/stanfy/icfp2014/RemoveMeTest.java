package com.stanfy.icfp2014;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveMeTest {

  private RemoveMe foo;

  @Before
  public void init() {
    foo = new RemoveMe();
  }

  @Test
  public void rx() {
    assertThat(foo.intRx().toBlocking().getIterator())
        .containsExactly(2, 3);
  }

  @Test
  public void stream() {
    assertThat(foo.intStream().iterator())
        .containsExactly(8, 10, 12);
  }

}
