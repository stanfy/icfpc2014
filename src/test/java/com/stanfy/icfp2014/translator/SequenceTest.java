package com.stanfy.icfp2014.translator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceTest {

  private Sequence seq;

  @Before
  public void init() {
    seq = new Sequence();
  }

  @Test
  public void offsetResolution() {
    /*
       SEL 1 3
       LDC 2
       RTN
       LDC 3
       RTN
     */
    Function f1 = Function.create(Statement.ldc(2));
    Function f2 = Function.create(Statement.ldc(3));
    seq.add(Statement.sel(f1, f2));
    seq.add(f1);
    seq.add(f2);
    seq.resolveSelf(0);
    assertThat(seq.asm()).contains("SEL 1 3");
    seq.resolveSelf(5);
    assertThat(seq.asm()).contains("SEL 6 8");
  }

}
