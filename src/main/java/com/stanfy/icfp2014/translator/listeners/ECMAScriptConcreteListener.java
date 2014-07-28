package com.stanfy.icfp2014.translator.listeners;

import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import com.stanfy.icfp2014.translator.listeners.models.*;
import okio.Buffer;
import okio.Sink;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptConcreteListener extends ECMAScriptToLListener {

  private final Sink output;
  public ArrayList<ECMAFunctionContext> functionContext = new ArrayList<>();
  public ECMAFunctionContext currentFunctionContext = null;
  public ArrayList<ECMATranslatable> programItems = new ArrayList<>();

  public ECMAScriptConcreteListener(Sink output) {
    super(output);
    ECMAFunctionContext mainFunctionContext = new ECMAFunctionContext();
    functionContext.add(mainFunctionContext);
    currentFunctionContext = mainFunctionContext;

    this.output = output;
  }

  @Override
  public void enterVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
    super.enterVariableDeclaration(ctx);

    // Let's start to push variable
    ECMAVariable variable = new ECMAVariable();
    variable.name = ctx.Identifier().getText();
    currentFunctionContext.localVariables.add(variable);
    currentFunctionContext.variables.put(variable.name, variable);
  }

  @Override
  public void exitVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
    super.exitVariableDeclaration(ctx);
    // Here we should put calculation
    programItems.add(new StoreToEnvironmentVariableInstruction(currentFunctionContext, currentFunctionContext.localVariables.get(currentFunctionContext.localVariables.size() - 1)));
  }

  @Override
  public void exitPostIncrementExpression(@NotNull ECMAScriptParser.PostIncrementExpressionContext ctx) {
    super.exitPostIncrementExpression(ctx);
    programItems.add(new LoadConstantInstruction("1"));
    programItems.add(new AddOperationInstruction());

    if (ctx.singleExpression() instanceof ECMAScriptParser.IdentifierExpressionContext) {
      ECMAScriptParser.IdentifierExpressionContext identifierExpressionContext = (ECMAScriptParser.IdentifierExpressionContext) ctx.singleExpression();
      // TODO : get variable from all contexts
      String variableName = identifierExpressionContext.Identifier().getText();
      programItems.add(new StoreToEnvironmentVariableInstruction(currentFunctionContext, currentFunctionContext.variables.get(variableName)));
    }
    System.out.println(ctx.singleExpression().getClass() + " ++");
  }

  @Override
  public void enterNumericLiteral(@NotNull ECMAScriptParser.NumericLiteralContext ctx) {
    programItems.add(new LoadConstantInstruction(ctx.getText()));
  }

  @Override
  public void enterSourceElement(@NotNull ECMAScriptParser.SourceElementContext ctx) {
    super.enterSourceElement(ctx);
    programItems.add(new CommentInstruction(ctx.getText()));

  }

  @Override
  public void exitAddExpression(@NotNull ECMAScriptParser.AddExpressionContext ctx) {
    super.exitAddExpression(ctx);
    programItems.add(new AddOperationInstruction());
  }

  @Override
  public void exitIdentifierExpression(@NotNull ECMAScriptParser.IdentifierExpressionContext ctx) {
    super.exitIdentifierExpression(ctx);
    // Make sure we have an variable or function with this name
    // TODO : find variable in all contexts
    System.out.println("Getting variable Identifier '" + ctx.getText() + "'");
    String variableName = ctx.getText();
    ECMAVariable variableRef = currentFunctionContext.variables.get(variableName);
    System.out.println("Getting variable Identifier " + currentFunctionContext.variables.keySet() + " -->" + variableRef);

//    programItems.add(new GetValueFromEnvironmentVariableInstruction(currentFunctionContext, variableRef));
  }

  @Override
  public void exitProgram(@NotNull ECMAScriptParser.ProgramContext ctx) {
    // Generate global variables for the current program
    // Now we know, how many functions and variables we have :) so let's start to create an environment to store them

    // Collect all variables
    if (currentFunctionContext.variables.size() > 0) {
      programItems.add(0, new EnvironmentFrameAllocationInstruction(currentFunctionContext.variables.size()));
    }

    // Create
    Buffer source = new Buffer();
    for (ECMATranslatable t : programItems) {
      source.writeString( t.translate() + "\n", Charset.defaultCharset());
     }
    try {
      output.write(source, source.size());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
