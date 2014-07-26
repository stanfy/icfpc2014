package com.stanfy.icfp2014.translator.listeners;

import com.stanfy.icfp2014.ecmascript4.ECMAScriptBaseListener;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptListener;
import com.stanfy.icfp2014.ecmascript4.ECMAScriptParser;
import okio.Sink;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by ptaykalo on 7/26/14.
 */
public class ECMAScriptToLListener implements ECMAScriptListener {

  public ECMAScriptToLListener(Sink output) {

  }

  @Override
  public void enterPropertyExpressionAssignment(@NotNull ECMAScriptParser.PropertyExpressionAssignmentContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyExpressionAssignment " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPropertyExpressionAssignment(@NotNull ECMAScriptParser.PropertyExpressionAssignmentContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyExpressionAssignment " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterInExpression(@NotNull ECMAScriptParser.InExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterInExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitInExpression(@NotNull ECMAScriptParser.InExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitInExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterEos(@NotNull ECMAScriptParser.EosContext ctx) {
     System.out.println("RuleContext visited : " + " enterEos " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitEos(@NotNull ECMAScriptParser.EosContext ctx) {
     System.out.println("RuleContext visited : " + " exitEos " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterSourceElements(@NotNull ECMAScriptParser.SourceElementsContext ctx) {
     System.out.println("RuleContext visited : " + " enterSourceElements " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitSourceElements(@NotNull ECMAScriptParser.SourceElementsContext ctx) {
     System.out.println("RuleContext visited : " + " exitSourceElements " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterGreaterThanExpression(@NotNull ECMAScriptParser.GreaterThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterGreaterThanExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitGreaterThanExpression(@NotNull ECMAScriptParser.GreaterThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitGreaterThanExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterProgram(@NotNull ECMAScriptParser.ProgramContext ctx) {
     System.out.println("RuleContext visited : " + " enterProgram " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitProgram(@NotNull ECMAScriptParser.ProgramContext ctx) {
     System.out.println("RuleContext visited : " + " exitProgram " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterArgumentList(@NotNull ECMAScriptParser.ArgumentListContext ctx) {
     System.out.println("RuleContext visited : " + " enterArgumentList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitArgumentList(@NotNull ECMAScriptParser.ArgumentListContext ctx) {
     System.out.println("RuleContext visited : " + " exitArgumentList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterArgumentsExpression(@NotNull ECMAScriptParser.ArgumentsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterArgumentsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitArgumentsExpression(@NotNull ECMAScriptParser.ArgumentsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitArgumentsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterIdentifierName(@NotNull ECMAScriptParser.IdentifierNameContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentifierName " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitIdentifierName(@NotNull ECMAScriptParser.IdentifierNameContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentifierName " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterAndExpression(@NotNull ECMAScriptParser.AndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAndExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitAndExpression(@NotNull ECMAScriptParser.AndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAndExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterInitialiser(@NotNull ECMAScriptParser.InitialiserContext ctx) {
     System.out.println("RuleContext visited : " + " enterInitialiser " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitInitialiser(@NotNull ECMAScriptParser.InitialiserContext ctx) {
     System.out.println("RuleContext visited : " + " exitInitialiser " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterTypeofExpression(@NotNull ECMAScriptParser.TypeofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterTypeofExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitTypeofExpression(@NotNull ECMAScriptParser.TypeofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitTypeofExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterBlock(@NotNull ECMAScriptParser.BlockContext ctx) {
     System.out.println("RuleContext visited : " + " enterBlock " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitBlock(@NotNull ECMAScriptParser.BlockContext ctx) {
     System.out.println("RuleContext visited : " + " exitBlock " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterExpressionStatement(@NotNull ECMAScriptParser.ExpressionStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterExpressionStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitExpressionStatement(@NotNull ECMAScriptParser.ExpressionStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitExpressionStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterBitXOrExpression(@NotNull ECMAScriptParser.BitXOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitXOrExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitBitXOrExpression(@NotNull ECMAScriptParser.BitXOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitXOrExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterNumericLiteral(@NotNull ECMAScriptParser.NumericLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterNumericLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitNumericLiteral(@NotNull ECMAScriptParser.NumericLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitNumericLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterForInStatement(@NotNull ECMAScriptParser.ForInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForInStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitForInStatement(@NotNull ECMAScriptParser.ForInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForInStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterEmptyStatement(@NotNull ECMAScriptParser.EmptyStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterEmptyStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitEmptyStatement(@NotNull ECMAScriptParser.EmptyStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitEmptyStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterLabelledStatement(@NotNull ECMAScriptParser.LabelledStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterLabelledStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitLabelledStatement(@NotNull ECMAScriptParser.LabelledStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitLabelledStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterModulusExpression(@NotNull ECMAScriptParser.ModulusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterModulusExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitModulusExpression(@NotNull ECMAScriptParser.ModulusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitModulusExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterNewExpression(@NotNull ECMAScriptParser.NewExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterNewExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitNewExpression(@NotNull ECMAScriptParser.NewExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitNewExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterIdentityEqualsExpression(@NotNull ECMAScriptParser.IdentityEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentityEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitIdentityEqualsExpression(@NotNull ECMAScriptParser.IdentityEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentityEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterWithStatement(@NotNull ECMAScriptParser.WithStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterWithStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitWithStatement(@NotNull ECMAScriptParser.WithStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitWithStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterDivideExpression(@NotNull ECMAScriptParser.DivideExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterDivideExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitDivideExpression(@NotNull ECMAScriptParser.DivideExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitDivideExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterBitAndExpression(@NotNull ECMAScriptParser.BitAndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitAndExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitBitAndExpression(@NotNull ECMAScriptParser.BitAndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitAndExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterAddExpression(@NotNull ECMAScriptParser.AddExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAddExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitAddExpression(@NotNull ECMAScriptParser.AddExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAddExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterBitOrExpression(@NotNull ECMAScriptParser.BitOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitOrExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitBitOrExpression(@NotNull ECMAScriptParser.BitOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitOrExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterVoidExpression(@NotNull ECMAScriptParser.VoidExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterVoidExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitVoidExpression(@NotNull ECMAScriptParser.VoidExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitVoidExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterTernaryExpression(@NotNull ECMAScriptParser.TernaryExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterTernaryExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitTernaryExpression(@NotNull ECMAScriptParser.TernaryExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitTernaryExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterIdentityNotEqualsExpression(@NotNull ECMAScriptParser.IdentityNotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentityNotEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitIdentityNotEqualsExpression(@NotNull ECMAScriptParser.IdentityNotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentityNotEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterArrayLiteral(@NotNull ECMAScriptParser.ArrayLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterArrayLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitArrayLiteral(@NotNull ECMAScriptParser.ArrayLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitArrayLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterNotEqualsExpression(@NotNull ECMAScriptParser.NotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterNotEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitNotEqualsExpression(@NotNull ECMAScriptParser.NotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitNotEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterElision(@NotNull ECMAScriptParser.ElisionContext ctx) {
     System.out.println("RuleContext visited : " + " enterElision " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitElision(@NotNull ECMAScriptParser.ElisionContext ctx) {
     System.out.println("RuleContext visited : " + " exitElision " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterWhileStatement(@NotNull ECMAScriptParser.WhileStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterWhileStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitWhileStatement(@NotNull ECMAScriptParser.WhileStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitWhileStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterReturnStatement(@NotNull ECMAScriptParser.ReturnStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterReturnStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitReturnStatement(@NotNull ECMAScriptParser.ReturnStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitReturnStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPreDecreaseExpression(@NotNull ECMAScriptParser.PreDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPreDecreaseExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPreDecreaseExpression(@NotNull ECMAScriptParser.PreDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPreDecreaseExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterExpressionSequence(@NotNull ECMAScriptParser.ExpressionSequenceContext ctx) {
     System.out.println("RuleContext visited : " + " enterExpressionSequence " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitExpressionSequence(@NotNull ECMAScriptParser.ExpressionSequenceContext ctx) {
     System.out.println("RuleContext visited : " + " exitExpressionSequence " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterLiteral(@NotNull ECMAScriptParser.LiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitLiteral(@NotNull ECMAScriptParser.LiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterSubtractExpression(@NotNull ECMAScriptParser.SubtractExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterSubtractExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitSubtractExpression(@NotNull ECMAScriptParser.SubtractExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitSubtractExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterDefaultClause(@NotNull ECMAScriptParser.DefaultClauseContext ctx) {
     System.out.println("RuleContext visited : " + " enterDefaultClause " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitDefaultClause(@NotNull ECMAScriptParser.DefaultClauseContext ctx) {
     System.out.println("RuleContext visited : " + " exitDefaultClause " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPostDecreaseExpression(@NotNull ECMAScriptParser.PostDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPostDecreaseExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPostDecreaseExpression(@NotNull ECMAScriptParser.PostDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPostDecreaseExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterUnaryPlusExpression(@NotNull ECMAScriptParser.UnaryPlusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterUnaryPlusExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitUnaryPlusExpression(@NotNull ECMAScriptParser.UnaryPlusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitUnaryPlusExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterForStatement(@NotNull ECMAScriptParser.ForStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitForStatement(@NotNull ECMAScriptParser.ForStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterCaseBlock(@NotNull ECMAScriptParser.CaseBlockContext ctx) {
     System.out.println("RuleContext visited : " + " enterCaseBlock " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitCaseBlock(@NotNull ECMAScriptParser.CaseBlockContext ctx) {
     System.out.println("RuleContext visited : " + " exitCaseBlock " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterCaseClauses(@NotNull ECMAScriptParser.CaseClausesContext ctx) {
     System.out.println("RuleContext visited : " + " enterCaseClauses " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitCaseClauses(@NotNull ECMAScriptParser.CaseClausesContext ctx) {
     System.out.println("RuleContext visited : " + " exitCaseClauses " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterParenthesizedExpression(@NotNull ECMAScriptParser.ParenthesizedExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterParenthesizedExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitParenthesizedExpression(@NotNull ECMAScriptParser.ParenthesizedExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitParenthesizedExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPostIncrementExpression(@NotNull ECMAScriptParser.PostIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPostIncrementExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPostIncrementExpression(@NotNull ECMAScriptParser.PostIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPostIncrementExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterObjectLiteral(@NotNull ECMAScriptParser.ObjectLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterObjectLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitObjectLiteral(@NotNull ECMAScriptParser.ObjectLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitObjectLiteral " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterThrowStatement(@NotNull ECMAScriptParser.ThrowStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterThrowStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitThrowStatement(@NotNull ECMAScriptParser.ThrowStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitThrowStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterMultiplyExpression(@NotNull ECMAScriptParser.MultiplyExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterMultiplyExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitMultiplyExpression(@NotNull ECMAScriptParser.MultiplyExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitMultiplyExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " enterVariableDeclaration " + ctx + " ( " + ctx.getText() + " ) " );
  }

  @Override
  public void exitVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " exitVariableDeclaration " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterIdentifierExpression(@NotNull ECMAScriptParser.IdentifierExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentifierExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitIdentifierExpression(@NotNull ECMAScriptParser.IdentifierExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentifierExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPropertyName(@NotNull ECMAScriptParser.PropertyNameContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyName " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPropertyName(@NotNull ECMAScriptParser.PropertyNameContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyName " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterCaseClause(@NotNull ECMAScriptParser.CaseClauseContext ctx) {
     System.out.println("RuleContext visited : " + " enterCaseClause " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitCaseClause(@NotNull ECMAScriptParser.CaseClauseContext ctx) {
     System.out.println("RuleContext visited : " + " exitCaseClause " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterVariableDeclarationList(@NotNull ECMAScriptParser.VariableDeclarationListContext ctx) {
     System.out.println("RuleContext visited : " + " enterVariableDeclarationList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitVariableDeclarationList(@NotNull ECMAScriptParser.VariableDeclarationListContext ctx) {
     System.out.println("RuleContext visited : " + " exitVariableDeclarationList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterSetter(@NotNull ECMAScriptParser.SetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterSetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitSetter(@NotNull ECMAScriptParser.SetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitSetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterFunctionDeclaration(@NotNull ECMAScriptParser.FunctionDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " enterFunctionDeclaration " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitFunctionDeclaration(@NotNull ECMAScriptParser.FunctionDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " exitFunctionDeclaration " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterEqualsExpression(@NotNull ECMAScriptParser.EqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitEqualsExpression(@NotNull ECMAScriptParser.EqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterLeftShiftArithmeticExpression(@NotNull ECMAScriptParser.LeftShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLeftShiftArithmeticExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitLeftShiftArithmeticExpression(@NotNull ECMAScriptParser.LeftShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLeftShiftArithmeticExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterGetter(@NotNull ECMAScriptParser.GetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterGetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitGetter(@NotNull ECMAScriptParser.GetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitGetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterAssignmentOperator(@NotNull ECMAScriptParser.AssignmentOperatorContext ctx) {
     System.out.println("RuleContext visited : " + " enterAssignmentOperator " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitAssignmentOperator(@NotNull ECMAScriptParser.AssignmentOperatorContext ctx) {
     System.out.println("RuleContext visited : " + " exitAssignmentOperator " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterRightShiftLogicalExpression(@NotNull ECMAScriptParser.RightShiftLogicalExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterRightShiftLogicalExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitRightShiftLogicalExpression(@NotNull ECMAScriptParser.RightShiftLogicalExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitRightShiftLogicalExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterOrExpression(@NotNull ECMAScriptParser.OrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterOrExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitOrExpression(@NotNull ECMAScriptParser.OrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitOrExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterThisExpression(@NotNull ECMAScriptParser.ThisExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterThisExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitThisExpression(@NotNull ECMAScriptParser.ThisExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitThisExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterFutureReservedWord(@NotNull ECMAScriptParser.FutureReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " enterFutureReservedWord " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitFutureReservedWord(@NotNull ECMAScriptParser.FutureReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " exitFutureReservedWord " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterStatementList(@NotNull ECMAScriptParser.StatementListContext ctx) {
     System.out.println("RuleContext visited : " + " enterStatementList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitStatementList(@NotNull ECMAScriptParser.StatementListContext ctx) {
     System.out.println("RuleContext visited : " + " exitStatementList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPropertyGetter(@NotNull ECMAScriptParser.PropertyGetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyGetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPropertyGetter(@NotNull ECMAScriptParser.PropertyGetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyGetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterKeyword(@NotNull ECMAScriptParser.KeywordContext ctx) {
     System.out.println("RuleContext visited : " + " enterKeyword " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitKeyword(@NotNull ECMAScriptParser.KeywordContext ctx) {
     System.out.println("RuleContext visited : " + " exitKeyword " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterElementList(@NotNull ECMAScriptParser.ElementListContext ctx) {
     System.out.println("RuleContext visited : " + " enterElementList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitElementList(@NotNull ECMAScriptParser.ElementListContext ctx) {
     System.out.println("RuleContext visited : " + " exitElementList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterBitNotExpression(@NotNull ECMAScriptParser.BitNotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitNotExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitBitNotExpression(@NotNull ECMAScriptParser.BitNotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitNotExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPropertySetter(@NotNull ECMAScriptParser.PropertySetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertySetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPropertySetter(@NotNull ECMAScriptParser.PropertySetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertySetter " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterLiteralExpression(@NotNull ECMAScriptParser.LiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLiteralExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitLiteralExpression(@NotNull ECMAScriptParser.LiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLiteralExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterArrayLiteralExpression(@NotNull ECMAScriptParser.ArrayLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterArrayLiteralExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitArrayLiteralExpression(@NotNull ECMAScriptParser.ArrayLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitArrayLiteralExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterMemberDotExpression(@NotNull ECMAScriptParser.MemberDotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterMemberDotExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitMemberDotExpression(@NotNull ECMAScriptParser.MemberDotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitMemberDotExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterMemberIndexExpression(@NotNull ECMAScriptParser.MemberIndexExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterMemberIndexExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitMemberIndexExpression(@NotNull ECMAScriptParser.MemberIndexExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitMemberIndexExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterFormalParameterList(@NotNull ECMAScriptParser.FormalParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " enterFormalParameterList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitFormalParameterList(@NotNull ECMAScriptParser.FormalParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " exitFormalParameterList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterForVarInStatement(@NotNull ECMAScriptParser.ForVarInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForVarInStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitForVarInStatement(@NotNull ECMAScriptParser.ForVarInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForVarInStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPropertySetParameterList(@NotNull ECMAScriptParser.PropertySetParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertySetParameterList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPropertySetParameterList(@NotNull ECMAScriptParser.PropertySetParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertySetParameterList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterAssignmentOperatorExpression(@NotNull ECMAScriptParser.AssignmentOperatorExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAssignmentOperatorExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitAssignmentOperatorExpression(@NotNull ECMAScriptParser.AssignmentOperatorExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAssignmentOperatorExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterTryStatement(@NotNull ECMAScriptParser.TryStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterTryStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitTryStatement(@NotNull ECMAScriptParser.TryStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitTryStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterDebuggerStatement(@NotNull ECMAScriptParser.DebuggerStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterDebuggerStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitDebuggerStatement(@NotNull ECMAScriptParser.DebuggerStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitDebuggerStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterDoStatement(@NotNull ECMAScriptParser.DoStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterDoStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitDoStatement(@NotNull ECMAScriptParser.DoStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitDoStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPreIncrementExpression(@NotNull ECMAScriptParser.PreIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPreIncrementExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPreIncrementExpression(@NotNull ECMAScriptParser.PreIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPreIncrementExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterObjectLiteralExpression(@NotNull ECMAScriptParser.ObjectLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterObjectLiteralExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitObjectLiteralExpression(@NotNull ECMAScriptParser.ObjectLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitObjectLiteralExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterNotExpression(@NotNull ECMAScriptParser.NotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterNotExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitNotExpression(@NotNull ECMAScriptParser.NotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitNotExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterSwitchStatement(@NotNull ECMAScriptParser.SwitchStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterSwitchStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitSwitchStatement(@NotNull ECMAScriptParser.SwitchStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitSwitchStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterVariableStatement(@NotNull ECMAScriptParser.VariableStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterVariableStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitVariableStatement(@NotNull ECMAScriptParser.VariableStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitVariableStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterFunctionExpression(@NotNull ECMAScriptParser.FunctionExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterFunctionExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitFunctionExpression(@NotNull ECMAScriptParser.FunctionExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitFunctionExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterUnaryMinusExpression(@NotNull ECMAScriptParser.UnaryMinusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterUnaryMinusExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitUnaryMinusExpression(@NotNull ECMAScriptParser.UnaryMinusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitUnaryMinusExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterAssignmentExpression(@NotNull ECMAScriptParser.AssignmentExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAssignmentExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitAssignmentExpression(@NotNull ECMAScriptParser.AssignmentExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAssignmentExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterRightShiftArithmeticExpression(@NotNull ECMAScriptParser.RightShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterRightShiftArithmeticExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitRightShiftArithmeticExpression(@NotNull ECMAScriptParser.RightShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitRightShiftArithmeticExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterInstanceofExpression(@NotNull ECMAScriptParser.InstanceofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterInstanceofExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitInstanceofExpression(@NotNull ECMAScriptParser.InstanceofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitInstanceofExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterStatement(@NotNull ECMAScriptParser.StatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitStatement(@NotNull ECMAScriptParser.StatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterDeleteExpression(@NotNull ECMAScriptParser.DeleteExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterDeleteExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitDeleteExpression(@NotNull ECMAScriptParser.DeleteExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitDeleteExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterLessThanEqualsExpression(@NotNull ECMAScriptParser.LessThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLessThanEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitLessThanEqualsExpression(@NotNull ECMAScriptParser.LessThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLessThanEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterPropertyNameAndValueList(@NotNull ECMAScriptParser.PropertyNameAndValueListContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyNameAndValueList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitPropertyNameAndValueList(@NotNull ECMAScriptParser.PropertyNameAndValueListContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyNameAndValueList " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterForVarStatement(@NotNull ECMAScriptParser.ForVarStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForVarStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitForVarStatement(@NotNull ECMAScriptParser.ForVarStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForVarStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterSourceElement(@NotNull ECMAScriptParser.SourceElementContext ctx) {
     System.out.println("RuleContext visited : " + " enterSourceElement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitSourceElement(@NotNull ECMAScriptParser.SourceElementContext ctx) {
     System.out.println("RuleContext visited : " + " exitSourceElement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterBreakStatement(@NotNull ECMAScriptParser.BreakStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterBreakStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitBreakStatement(@NotNull ECMAScriptParser.BreakStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitBreakStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterIfStatement(@NotNull ECMAScriptParser.IfStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterIfStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitIfStatement(@NotNull ECMAScriptParser.IfStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitIfStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterReservedWord(@NotNull ECMAScriptParser.ReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " enterReservedWord " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitReservedWord(@NotNull ECMAScriptParser.ReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " exitReservedWord " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterFinallyProduction(@NotNull ECMAScriptParser.FinallyProductionContext ctx) {
     System.out.println("RuleContext visited : " + " enterFinallyProduction " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitFinallyProduction(@NotNull ECMAScriptParser.FinallyProductionContext ctx) {
     System.out.println("RuleContext visited : " + " exitFinallyProduction " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterGreaterThanEqualsExpression(@NotNull ECMAScriptParser.GreaterThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterGreaterThanEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitGreaterThanEqualsExpression(@NotNull ECMAScriptParser.GreaterThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitGreaterThanEqualsExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterCatchProduction(@NotNull ECMAScriptParser.CatchProductionContext ctx) {
     System.out.println("RuleContext visited : " + " enterCatchProduction " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitCatchProduction(@NotNull ECMAScriptParser.CatchProductionContext ctx) {
     System.out.println("RuleContext visited : " + " exitCatchProduction " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterContinueStatement(@NotNull ECMAScriptParser.ContinueStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterContinueStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitContinueStatement(@NotNull ECMAScriptParser.ContinueStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitContinueStatement " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterArguments(@NotNull ECMAScriptParser.ArgumentsContext ctx) {
     System.out.println("RuleContext visited : " + " enterArguments " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitArguments(@NotNull ECMAScriptParser.ArgumentsContext ctx) {
     System.out.println("RuleContext visited : " + " exitArguments " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterFunctionBody(@NotNull ECMAScriptParser.FunctionBodyContext ctx) {
     System.out.println("RuleContext visited : " + " enterFunctionBody " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitFunctionBody(@NotNull ECMAScriptParser.FunctionBodyContext ctx) {
     System.out.println("RuleContext visited : " + " exitFunctionBody " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterEof(@NotNull ECMAScriptParser.EofContext ctx) {
     System.out.println("RuleContext visited : " + " enterEof " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitEof(@NotNull ECMAScriptParser.EofContext ctx) {
     System.out.println("RuleContext visited : " + " exitEof " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void enterLessThanExpression(@NotNull ECMAScriptParser.LessThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLessThanExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void exitLessThanExpression(@NotNull ECMAScriptParser.LessThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLessThanExpression " + ctx + " ( " + ctx.getText() + " ) "); 
  }

  @Override
  public void visitTerminal(@NotNull TerminalNode terminalNode) {
//     System.out.println("RuleContext visited : " + " visitTerminal " + ctx + " ( " + ctx.getText() + " ) ");
  }

  @Override
  public void visitErrorNode(@NotNull ErrorNode errorNode) {
//     System.out.println("RuleContext visited : " + " visitErrorNode " + ctx + " ( " + ctx.getText() + " ) ");
  }

  @Override
  public void enterEveryRule(@NotNull ParserRuleContext parserRuleContext) {
//     System.out.println("RuleContext visited : " + " enterEveryRule " + ctx + " ( " + ctx.getText() + " ) ");
  }

  @Override
  public void exitEveryRule(@NotNull ParserRuleContext parserRuleContext) {
//     System.out.println("RuleContext visited : " + " exitEveryRule " + ctx + " ( " + ctx.getText() + " ) ");
  }
}
