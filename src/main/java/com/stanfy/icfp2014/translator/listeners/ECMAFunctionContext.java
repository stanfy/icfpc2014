package com.stanfy.icfp2014.translator.listeners;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAFunctionContext {
  public String name;
  public HashMap<String, ECMAVariable> variables = new HashMap<>();
  public ArrayList<ECMAVariable> localVariables = new ArrayList<>();

}
