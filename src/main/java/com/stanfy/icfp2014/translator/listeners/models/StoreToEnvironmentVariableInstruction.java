package com.stanfy.icfp2014.translator.listeners.models;

import com.stanfy.icfp2014.translator.listeners.ECMAFunctionContext;
import com.stanfy.icfp2014.translator.listeners.ECMAVariable;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class StoreToEnvironmentVariableInstruction implements ECMATranslatable {
  private ECMAFunctionContext context;
  private ECMAVariable variable;

  public StoreToEnvironmentVariableInstruction(ECMAFunctionContext context, ECMAVariable variable) {
    this.context = context;
    this.variable = variable;
  }

  @Override
  public String translate() {
    // TODO : Inside context
    return "ST 0 " + context.localVariables.indexOf(variable) + " ; Store " + variable.name + " from top of stack";
  }
}
