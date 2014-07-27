package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.clojure.ClojureParser;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptLexer;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import okio.Buffer;
import okio.Okio;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.stanfy.icfp2014.ecmascript4.ECMAScriptParser.*;
import static com.stanfy.icfp2014.translator.Statement.NoArgs.CAR;
import static com.stanfy.icfp2014.translator.Statement.NoArgs.CDR;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptTranslator {
  public boolean verbose = false;
  private final Map<String, FuncTranslate> core = new HashMap<>();
  {
    core.put("nil", (scope, list) -> nil());

    core.put("lfirst", (scope, list) -> {
      Sequence result = new Sequence();
      result.add(CAR);
      return result;
    });

    core.put("lrest", (scope, list) -> {
      Sequence result = new Sequence();
      result.add(CDR);
      return result;
    });

  }
  private Statement nil() {
    return Statement.ldc(0);
  }

  public Result translate(final Source program) {
    try {
      ECMAScriptLexer lexer = new ECMAScriptLexer(new ANTLRInputStream(Okio.buffer(program).inputStream()));
      CommonTokenStream stream = new CommonTokenStream(lexer);
      ECMAScriptParser parser = new ECMAScriptParser(stream);

      Buffer output = new Buffer();

      Scope scope = new Scope("root");

      Program prg = new Program();
      prg.add(Statement.comment("Stanfy (c) 2014"));
      parser.program().sourceElements().sourceElement().stream()
          .map((node) -> translateNode(scope, node))
          .forEach(prg::add);

      prg.resolveLabels(0);

      output.writeUtf8(prg.asm());

      return new Result(output, prg.size());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private Statement translateNode(Scope scope, SourceElementContext node) {
    if (verbose) {
      System.out.println("Source " + node.getText());
    }
    if (node.statement() != null) {

      //  Expression
      if (node.statement().expressionStatement() != null) {
        return translateExpression(scope, node.statement().expressionStatement());
      }

      //  Expression
      if (node.statement().emptyStatement() != null) {
        return Statement.comment(node.getText());
      }

      ReturnStatementContext returnStatementContext = node.statement().returnStatement();
      if (returnStatementContext != null) {
        return translateExpressionSequence(scope, returnStatementContext.expressionSequence());
      }
    }
    throw new UnsupportedOperationException("cannot translate  node " + node.getClass() + " - " + node.getText());
  }

  private Sequence translateExpressionSequence(Scope scope, ExpressionSequenceContext expressionSequence) {
    if (verbose) {
      System.out.println("Expresssion sequence" + expressionSequence.getText());
    }
    if (expressionSequence.singleExpression() != null) {
      Sequence result = new Sequence();
      for (SingleExpressionContext expressionContext :expressionSequence.singleExpression()) {
        result.add(translateSingleEpression(scope, expressionContext));
      }
      return result;
    }
    throw new UnsupportedOperationException("cannot translate  expressionSequence " + expressionSequence.getClass() + " - " + expressionSequence.getText());
  }


  private Statement translateExpression(Scope scope, ExpressionStatementContext expression) {
    if (verbose) {
      System.out.println("Expresssion " + expression.getText() + " " + expression.getClass());
    }
    if (expression.expressionSequence() != null) {
      return translateExpressionSequence(scope, expression.expressionSequence());
    }
    throw new UnsupportedOperationException("cannot translate  expression " + expression.getClass() + " - " + expression.getText());
  }

  private Statement translateSingleEpression(Scope scope, SingleExpressionContext expressionContext) {
    if (verbose) {
      System.out.println("Single expresssion " + expressionContext.getText() + " " + expressionContext.getClass());
    }

    // Add Expression
    if (expressionContext instanceof AddExpressionContext) {
      AddExpressionContext context = (AddExpressionContext) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.ADD);
      return addSequence;
    }

    // SUB Expression
    if (expressionContext instanceof SubtractExpressionContext) {
      SubtractExpressionContext context = (SubtractExpressionContext) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.SUB);
      return addSequence;
    }

    // SUB Expression
    if (expressionContext instanceof SubtractExpressionContext) {
      SubtractExpressionContext context = (SubtractExpressionContext) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.SUB);
      return addSequence;
    }

    // DIV Expression
    if (expressionContext instanceof DivideExpressionContext) {
      DivideExpressionContext context = (DivideExpressionContext) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.DIV);
      return addSequence;
    }

    // MUL Expression
    if (expressionContext instanceof MultiplyExpressionContext) {
      MultiplyExpressionContext context = (MultiplyExpressionContext) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.MUL);
      return addSequence;
    }

    // == Expression
    if (expressionContext instanceof EqualsExpressionContext ) {
      EqualsExpressionContext  context = (EqualsExpressionContext ) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.CEQ);
      return addSequence;
    }

    // != Expression
    if (expressionContext instanceof NotEqualsExpressionContext ) {
      NotEqualsExpressionContext  context = (NotEqualsExpressionContext ) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.CEQ);
      addSequence.add(Statement.ldc(0));
      addSequence.add(Statement.NoArgs.CEQ);
      return addSequence;
    }

    // >
    if (expressionContext instanceof GreaterThanExpressionContext ) {
      GreaterThanExpressionContext  context = (GreaterThanExpressionContext ) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.CGT);
      return addSequence;
    }

    // >=
    if (expressionContext instanceof GreaterThanEqualsExpressionContext) {
      GreaterThanEqualsExpressionContext  context = (GreaterThanEqualsExpressionContext ) expressionContext;
      Sequence addSequence = new Sequence();
      for (SingleExpressionContext expression : context.singleExpression()) {
        addSequence.add(translateSingleEpression(scope, expression));
      }
      addSequence.add(Statement.NoArgs.CGTE);
      return addSequence;
    }

    // <
    if (expressionContext instanceof LessThanExpressionContext ) {
      LessThanExpressionContext  context = (LessThanExpressionContext ) expressionContext;
      Sequence addSequence = new Sequence();
      addSequence.add(translateSingleEpression(scope, context.singleExpression().get(1)));
      addSequence.add(translateSingleEpression(scope, context.singleExpression().get(0)));
      addSequence.add(Statement.NoArgs.CGT);
      return addSequence;
    }

    // <=
    if (expressionContext instanceof LessThanEqualsExpressionContext ) {
      LessThanEqualsExpressionContext  context = (LessThanEqualsExpressionContext ) expressionContext;
      Sequence addSequence = new Sequence();
      addSequence.add(translateSingleEpression(scope, context.singleExpression().get(1)));
      addSequence.add(translateSingleEpression(scope, context.singleExpression().get(0)));
      addSequence.add(Statement.NoArgs.CGTE);
      return addSequence;
    }


    // some litereal found expression
    if (expressionContext instanceof LiteralExpressionContext) {
      LiteralContext literal = ((LiteralExpressionContext) expressionContext).literal();

      if (literal.numericLiteral() != null) {
        return Statement.ldc(Integer.valueOf(literal.numericLiteral().DecimalLiteral().toString()));
      }
    }

    if (expressionContext instanceof ParenthesizedExpressionContext) {
      ParenthesizedExpressionContext parenthesizedExpressionContext = (ParenthesizedExpressionContext) expressionContext;
      Sequence result = new Sequence();
      for (SingleExpressionContext singleExpressionContext : parenthesizedExpressionContext.expressionSequence().singleExpression()) {
        result.add(translateSingleEpression(scope, singleExpressionContext));
      }
      return result;
    }

    // Functions
    if (expressionContext instanceof  FunctionExpressionContext) {
      return translateFunction(scope, (FunctionExpressionContext)expressionContext);
    }

    // Function arguments
    if (expressionContext instanceof  ArgumentsExpressionContext) {
      return translateFunctionArguments(scope, (ArgumentsExpressionContext) expressionContext);
    }



    if (expressionContext instanceof  IdentifierExpressionContext) {
      return translateIdentifier(scope, (IdentifierExpressionContext) expressionContext);
    }

    if (expressionContext instanceof  ArrayLiteralExpressionContext) {
      return translateArray(scope, (ArrayLiteralExpressionContext) expressionContext);
    }

    if (expressionContext instanceof  MemberIndexExpressionContext) {
      return translateIndexAccess(scope, (MemberIndexExpressionContext) expressionContext);
    }

    throw new UnsupportedOperationException("cannot translate single expression " + expressionContext.getClass() + " - " + expressionContext.getText());
  }

  private Statement translateIndexAccess(Scope scope, MemberIndexExpressionContext expressionContext) {
    if (verbose) {
      System.out.println("--> Index access! " + expressionContext.getText() + " " + expressionContext.singleExpression().getText() + " " + expressionContext.expressionSequence().getText());
    }
    return null;
  }

  private Statement translateArray(Scope scope, ArrayLiteralExpressionContext arrayLiteralExpressionContext) {
    if (verbose) {
      System.out.println("--> Array! " + arrayLiteralExpressionContext.getText());
    }
    Sequence seq = new Sequence();
    for (SingleExpressionContext expressionContext : arrayLiteralExpressionContext.arrayLiteral().elementList().singleExpression()) {
      seq.add(translateSingleEpression(scope, expressionContext));
    }
    int size = arrayLiteralExpressionContext.arrayLiteral().elementList().singleExpression().size();
    for (int i = 0; i < size - 1; i++) {
      seq.add(Statement.NoArgs.CONS);
    }
    return seq;
  }


  private Statement translateIdentifier(Scope scope, IdentifierExpressionContext identifier) {
    if (verbose) {
      System.out.println("--> Identifier! " + identifier.getText());
    }
    String name = identifier.Identifier().getText();
    Scope.VarLocation varLocation = scope.var(name);
    if (varLocation == null) {
      Function func = scope.function(name);
      if (func == null) {
        FuncTranslate coreTranlation = core.get(name);
        if (coreTranlation != null) {
          return coreTranlation.translate(scope, identifier);
        }
        throw new IllegalArgumentException(name + " is not resolved in " + scope);
      }
      return Statement.ldf(func::getAddress);
    }
    return Statement.ld(varLocation.frame, varLocation.index);
  }

  private Statement translateFunction(Scope scope, FunctionExpressionContext functionContext) {
    if (verbose) {
      System.out.println("--> Translating function! " + functionContext.getText());
    }

    /*
      core.put("defn", (scope, list) -> {
      String name = list.form(1).getText();
      String[] arguments = arguments(list.form(2));

      Scope fScope = scope.push(name);
      for (int i = 0; i < arguments.length; i++) {
        fScope.var(arguments[i], i);
      }
      Function f = new Function(name, arguments.length);
      scope.function(f);
      f.setBody(translateNode(fScope, list.form(3)));

      return f;
    });
     */
    String name = functionContext.Identifier().getText();
    String[] arguments = arguments(functionContext);

    Scope fScope = scope.push(name);
    if (arguments != null) {
      for (int i = 0; i < arguments.length; i++) {
        fScope.var(arguments[i], i);
      }
    }
    Function f = new Function(name, arguments == null ? 0 : arguments.length);
    scope.function(f);

    Sequence addSequence = new Sequence();
    for (SourceElementContext sourceElement : functionContext.functionBody().sourceElements().sourceElement()) {
      addSequence.add(translateNode(fScope, sourceElement));
    }

    f.setBody(addSequence);
    return f;
  }

  private Statement translateFunctionArguments(Scope scope, ArgumentsExpressionContext argumentsExpressionContext) {
    if (verbose) {
      System.out.println("--> Translating function! arguments " + argumentsExpressionContext.getText());
    }

    // Handle all arguments and put them onto the stack
    String functionName = argumentsExpressionContext.singleExpression().getText();
    if (verbose) {
      System.out.println("--> <--" + functionName);
    }

    Sequence call = new Sequence();
    int callArgumentsCount = 0;
    if (argumentsExpressionContext.arguments() != null && argumentsExpressionContext.arguments().argumentList() != null) {
      for (SingleExpressionContext singleExpressionContext : argumentsExpressionContext.arguments().argumentList().singleExpression()) {
        call.add(translateSingleEpression(scope, singleExpressionContext));
      }
      callArgumentsCount = argumentsExpressionContext.arguments().argumentList().singleExpression().size();
    }

    // Make unction call
    Function func = scope.function(functionName);

    final Statement addressLoader;
    boolean inlinefunction = false;

    // IF function is called with arguments
    if (func == null) {
      FuncTranslate coreTranlation = core.get(functionName);
      if (coreTranlation != null) {
        // All itmes shoould be already in the scope
        call.add(coreTranlation.translate(scope, null));
        inlinefunction = true;
        addressLoader = null;
      } else {
        Scope.VarLocation location = scope.var(functionName);
        if (location == null) {
          throw new IllegalArgumentException(functionName + " is not resolved in " + scope);
        }
        addressLoader = Statement.ld(location.frame, location.index);
      }
    } else {
      addressLoader = Statement.ldf(func::getAddress);
    }

    // Inline function
    if (!inlinefunction) {
      call.add(addressLoader);
      if (func == null) {
        call.add(Statement.ap(callArgumentsCount));
      } else {
        call.add(Statement.ap(func.argsCount));
      }
    }

    if (verbose) {
      System.out.println("Sequences " + call.commands);
    }
    return call;
  }


  private String[] arguments(FunctionExpressionContext functionExpressionContext) {
    if (functionExpressionContext.formalParameterList() != null) {
      return functionExpressionContext.formalParameterList().Identifier()
          .stream().map(TerminalNode::getText).toArray(String[]::new);
    } else {
      return null;
    }
  }

  private interface FuncTranslate {
    Statement translate(Scope scope, ParserRuleContext list);
  }
}
