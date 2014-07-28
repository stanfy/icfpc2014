package com.stanfy.icfp2014.lambdaprocessor;

import java.util.ArrayList;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class EnvironmentFrame {

  public boolean isDummy = false;
  public ArrayList<Object> items = new ArrayList<>();
  public EnvironmentFrame parent = null;

  @Override
  public String toString() {
    return "EnvironmentFrame{" +
        "d=" + isDummy +
        ",items=" + items +
        ", parent=" + parent +
        '}';
  }
}
