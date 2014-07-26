package com.stanfy.icfp2014.lambdaprocessor;

import java.util.ArrayList;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class LambdaManProcessor {

  /*
   control register (program counter / instruction pointer)
   */
  public int c;

  // Data stack
  public ArrayList<Object> s = new ArrayList<>();

  // Control stack
  public ArrayList<Object> d;

  // environment stack
  public EnvironmentFrame e = new EnvironmentFrame();

  /*
  Returns top stack value
   */
  public Object topStackValue() {
    return s.get(s.size() - 1);
  }

}
