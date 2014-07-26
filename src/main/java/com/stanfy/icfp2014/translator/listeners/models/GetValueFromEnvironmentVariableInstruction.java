package com.stanfy.icfp2014.translator.listeners.models;

import com.stanfy.icfp2014.translator.listeners.ECMAFunctionContext;
import com.stanfy.icfp2014.translator.listeners.ECMAVariable;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class GetValueFromEnvironmentVariableInstruction implements ECMATranslable{
  private ECMAFunctionContext context;
  private ECMAVariable variable;

  public GetValueFromEnvironmentVariableInstruction(ECMAFunctionContext context, ECMAVariable variable) {
    this.context = context;
    this.variable = variable;
  }

  @Override
  public String translate() {
    // TODO : Inside context
    System.out.println("" + context);
    System.out.println("" + context.localVariables);
    System.out.println("" + variable);

    return "LD 0 " + context.localVariables.indexOf(variable) + " ;  Load  " + variable.name + " to stack";
  }

}
