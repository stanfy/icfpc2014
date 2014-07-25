package com.stanfy.icfp2014.translator.listeners;

import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import okio.Buffer;
import okio.Sink;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptConcreteListener extends ECMAScriptToLListener {

  private final Sink output;
  public ArrayList<ECMAFunctionContext> functionContext = new ArrayList<ECMAFunctionContext>();
  public ECMAFunctionContext currentFunctionContext = null;

  public ECMAScriptConcreteListener(Sink output) {
    super(output);
    ECMAFunctionContext mainFunctionContext = new ECMAFunctionContext();
    functionContext.add(mainFunctionContext);
    currentFunctionContext = mainFunctionContext;

    this.output = output;
  }

  @Override
  public void enterVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
    // Let's start to push variable
    ECMAVariable variable = new ECMAVariable();
    variable.name = ctx.getText();
    currentFunctionContext.contextVariables.add(variable);
    currentFunctionContext.variables.put(variable.name, variable);
  }

  @Override
  public void exitVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
    // Here we should put calculation
  }

  @Override
  public void exitProgram(@NotNull ECMAScriptParser.ProgramContext ctx) {
    // Generate global variables for the current program
    // Now we know, how many functions and variables we have :) so let's start to create an environment to store them

    // Create
    Buffer source = new Buffer();
    source.writeString("DUM " + currentFunctionContext.variables.size(), Charset.defaultCharset());
    try {
      output.write(source, source.size());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
