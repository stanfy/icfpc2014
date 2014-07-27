package com.stanfy.icfp2014.translator;

import com.stanfy.icfp2014.ecmascript4.ECMAScriptLexer;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import com.stanfy.icfp2014.translator.Result;
import com.stanfy.icfp2014.translator.Scope;
import com.stanfy.icfp2014.translator.listeners.ECMAScriptConcreteListener;
import com.stanfy.icfp2014.translator.listeners.ECMAScriptToLListener;
import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import static com.stanfy.icfp2014.ecmascript4.ECMAScriptParser.*;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptTranslator {

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
    System.out.println("Source " + node.getText());
    if (node.statement() != null) {
      if (node.statement().expressionStatement() != null) {
        return translateExpression(scope, node.statement().expressionStatement());
      }
    }
    throw new UnsupportedOperationException("cannot translate  node " + node.getClass() + " - " + node.getText());
  }

  private Statement translateExpression(Scope scope, ExpressionStatementContext expression) {
    System.out.println("Expresssion " + expression.getText());
    if (expression.expressionSequence() != null) {
      for (SingleExpressionContext expressionContext : expression.expressionSequence().singleExpression()) {
        return translateSingleEpression(scope, expressionContext);
      }
    }
    throw new UnsupportedOperationException("cannot translate  expression " + expression.getClass() + " - " + expression.getText());
  }

  private Statement translateSingleEpression(Scope scope, SingleExpressionContext expressionContext) {
    System.out.println("Single expresssion " + expressionContext.getText());

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


    // some litereal found expression
    if (expressionContext instanceof LiteralExpressionContext) {
      LiteralContext literal = (LiteralContext) ((LiteralExpressionContext) expressionContext).literal();

      if (literal.numericLiteral() != null) {
        return Statement.ldc(Integer.valueOf(literal.numericLiteral().DecimalLiteral().toString()));
      }

    }

    throw new UnsupportedOperationException("cannot translate single expression " + expressionContext.getClass() + " - " + expressionContext.getText());
  }

}
