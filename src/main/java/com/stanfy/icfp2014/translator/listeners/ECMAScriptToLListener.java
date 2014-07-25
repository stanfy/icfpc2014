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
     System.out.println("RuleContext visited : " + " enterPropertyExpressionAssignment " + ctx); 
  }

  @Override
  public void exitPropertyExpressionAssignment(@NotNull ECMAScriptParser.PropertyExpressionAssignmentContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyExpressionAssignment " + ctx); 
  }

  @Override
  public void enterInExpression(@NotNull ECMAScriptParser.InExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterInExpression " + ctx); 
  }

  @Override
  public void exitInExpression(@NotNull ECMAScriptParser.InExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitInExpression " + ctx); 
  }

  @Override
  public void enterEos(@NotNull ECMAScriptParser.EosContext ctx) {
     System.out.println("RuleContext visited : " + " enterEos " + ctx); 
  }

  @Override
  public void exitEos(@NotNull ECMAScriptParser.EosContext ctx) {
     System.out.println("RuleContext visited : " + " exitEos " + ctx); 
  }

  @Override
  public void enterSourceElements(@NotNull ECMAScriptParser.SourceElementsContext ctx) {
     System.out.println("RuleContext visited : " + " enterSourceElements " + ctx); 
  }

  @Override
  public void exitSourceElements(@NotNull ECMAScriptParser.SourceElementsContext ctx) {
     System.out.println("RuleContext visited : " + " exitSourceElements " + ctx); 
  }

  @Override
  public void enterGreaterThanExpression(@NotNull ECMAScriptParser.GreaterThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterGreaterThanExpression " + ctx); 
  }

  @Override
  public void exitGreaterThanExpression(@NotNull ECMAScriptParser.GreaterThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitGreaterThanExpression " + ctx); 
  }

  @Override
  public void enterProgram(@NotNull ECMAScriptParser.ProgramContext ctx) {
     System.out.println("RuleContext visited : " + " enterProgram " + ctx); 
  }

  @Override
  public void exitProgram(@NotNull ECMAScriptParser.ProgramContext ctx) {
     System.out.println("RuleContext visited : " + " exitProgram " + ctx); 
  }

  @Override
  public void enterArgumentList(@NotNull ECMAScriptParser.ArgumentListContext ctx) {
     System.out.println("RuleContext visited : " + " enterArgumentList " + ctx); 
  }

  @Override
  public void exitArgumentList(@NotNull ECMAScriptParser.ArgumentListContext ctx) {
     System.out.println("RuleContext visited : " + " exitArgumentList " + ctx); 
  }

  @Override
  public void enterArgumentsExpression(@NotNull ECMAScriptParser.ArgumentsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterArgumentsExpression " + ctx); 
  }

  @Override
  public void exitArgumentsExpression(@NotNull ECMAScriptParser.ArgumentsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitArgumentsExpression " + ctx); 
  }

  @Override
  public void enterIdentifierName(@NotNull ECMAScriptParser.IdentifierNameContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentifierName " + ctx); 
  }

  @Override
  public void exitIdentifierName(@NotNull ECMAScriptParser.IdentifierNameContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentifierName " + ctx); 
  }

  @Override
  public void enterAndExpression(@NotNull ECMAScriptParser.AndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAndExpression " + ctx); 
  }

  @Override
  public void exitAndExpression(@NotNull ECMAScriptParser.AndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAndExpression " + ctx); 
  }

  @Override
  public void enterInitialiser(@NotNull ECMAScriptParser.InitialiserContext ctx) {
     System.out.println("RuleContext visited : " + " enterInitialiser " + ctx); 
  }

  @Override
  public void exitInitialiser(@NotNull ECMAScriptParser.InitialiserContext ctx) {
     System.out.println("RuleContext visited : " + " exitInitialiser " + ctx); 
  }

  @Override
  public void enterTypeofExpression(@NotNull ECMAScriptParser.TypeofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterTypeofExpression " + ctx); 
  }

  @Override
  public void exitTypeofExpression(@NotNull ECMAScriptParser.TypeofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitTypeofExpression " + ctx); 
  }

  @Override
  public void enterBlock(@NotNull ECMAScriptParser.BlockContext ctx) {
     System.out.println("RuleContext visited : " + " enterBlock " + ctx); 
  }

  @Override
  public void exitBlock(@NotNull ECMAScriptParser.BlockContext ctx) {
     System.out.println("RuleContext visited : " + " exitBlock " + ctx); 
  }

  @Override
  public void enterExpressionStatement(@NotNull ECMAScriptParser.ExpressionStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterExpressionStatement " + ctx); 
  }

  @Override
  public void exitExpressionStatement(@NotNull ECMAScriptParser.ExpressionStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitExpressionStatement " + ctx); 
  }

  @Override
  public void enterBitXOrExpression(@NotNull ECMAScriptParser.BitXOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitXOrExpression " + ctx); 
  }

  @Override
  public void exitBitXOrExpression(@NotNull ECMAScriptParser.BitXOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitXOrExpression " + ctx); 
  }

  @Override
  public void enterNumericLiteral(@NotNull ECMAScriptParser.NumericLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterNumericLiteral " + ctx); 
  }

  @Override
  public void exitNumericLiteral(@NotNull ECMAScriptParser.NumericLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitNumericLiteral " + ctx); 
  }

  @Override
  public void enterForInStatement(@NotNull ECMAScriptParser.ForInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForInStatement " + ctx); 
  }

  @Override
  public void exitForInStatement(@NotNull ECMAScriptParser.ForInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForInStatement " + ctx); 
  }

  @Override
  public void enterEmptyStatement(@NotNull ECMAScriptParser.EmptyStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterEmptyStatement " + ctx); 
  }

  @Override
  public void exitEmptyStatement(@NotNull ECMAScriptParser.EmptyStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitEmptyStatement " + ctx); 
  }

  @Override
  public void enterLabelledStatement(@NotNull ECMAScriptParser.LabelledStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterLabelledStatement " + ctx); 
  }

  @Override
  public void exitLabelledStatement(@NotNull ECMAScriptParser.LabelledStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitLabelledStatement " + ctx); 
  }

  @Override
  public void enterModulusExpression(@NotNull ECMAScriptParser.ModulusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterModulusExpression " + ctx); 
  }

  @Override
  public void exitModulusExpression(@NotNull ECMAScriptParser.ModulusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitModulusExpression " + ctx); 
  }

  @Override
  public void enterNewExpression(@NotNull ECMAScriptParser.NewExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterNewExpression " + ctx); 
  }

  @Override
  public void exitNewExpression(@NotNull ECMAScriptParser.NewExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitNewExpression " + ctx); 
  }

  @Override
  public void enterIdentityEqualsExpression(@NotNull ECMAScriptParser.IdentityEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentityEqualsExpression " + ctx); 
  }

  @Override
  public void exitIdentityEqualsExpression(@NotNull ECMAScriptParser.IdentityEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentityEqualsExpression " + ctx); 
  }

  @Override
  public void enterWithStatement(@NotNull ECMAScriptParser.WithStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterWithStatement " + ctx); 
  }

  @Override
  public void exitWithStatement(@NotNull ECMAScriptParser.WithStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitWithStatement " + ctx); 
  }

  @Override
  public void enterDivideExpression(@NotNull ECMAScriptParser.DivideExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterDivideExpression " + ctx); 
  }

  @Override
  public void exitDivideExpression(@NotNull ECMAScriptParser.DivideExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitDivideExpression " + ctx); 
  }

  @Override
  public void enterBitAndExpression(@NotNull ECMAScriptParser.BitAndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitAndExpression " + ctx); 
  }

  @Override
  public void exitBitAndExpression(@NotNull ECMAScriptParser.BitAndExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitAndExpression " + ctx); 
  }

  @Override
  public void enterAddExpression(@NotNull ECMAScriptParser.AddExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAddExpression " + ctx); 
  }

  @Override
  public void exitAddExpression(@NotNull ECMAScriptParser.AddExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAddExpression " + ctx); 
  }

  @Override
  public void enterBitOrExpression(@NotNull ECMAScriptParser.BitOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitOrExpression " + ctx); 
  }

  @Override
  public void exitBitOrExpression(@NotNull ECMAScriptParser.BitOrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitOrExpression " + ctx); 
  }

  @Override
  public void enterVoidExpression(@NotNull ECMAScriptParser.VoidExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterVoidExpression " + ctx); 
  }

  @Override
  public void exitVoidExpression(@NotNull ECMAScriptParser.VoidExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitVoidExpression " + ctx); 
  }

  @Override
  public void enterTernaryExpression(@NotNull ECMAScriptParser.TernaryExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterTernaryExpression " + ctx); 
  }

  @Override
  public void exitTernaryExpression(@NotNull ECMAScriptParser.TernaryExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitTernaryExpression " + ctx); 
  }

  @Override
  public void enterIdentityNotEqualsExpression(@NotNull ECMAScriptParser.IdentityNotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentityNotEqualsExpression " + ctx); 
  }

  @Override
  public void exitIdentityNotEqualsExpression(@NotNull ECMAScriptParser.IdentityNotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentityNotEqualsExpression " + ctx); 
  }

  @Override
  public void enterArrayLiteral(@NotNull ECMAScriptParser.ArrayLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterArrayLiteral " + ctx); 
  }

  @Override
  public void exitArrayLiteral(@NotNull ECMAScriptParser.ArrayLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitArrayLiteral " + ctx); 
  }

  @Override
  public void enterNotEqualsExpression(@NotNull ECMAScriptParser.NotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterNotEqualsExpression " + ctx); 
  }

  @Override
  public void exitNotEqualsExpression(@NotNull ECMAScriptParser.NotEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitNotEqualsExpression " + ctx); 
  }

  @Override
  public void enterElision(@NotNull ECMAScriptParser.ElisionContext ctx) {
     System.out.println("RuleContext visited : " + " enterElision " + ctx); 
  }

  @Override
  public void exitElision(@NotNull ECMAScriptParser.ElisionContext ctx) {
     System.out.println("RuleContext visited : " + " exitElision " + ctx); 
  }

  @Override
  public void enterWhileStatement(@NotNull ECMAScriptParser.WhileStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterWhileStatement " + ctx); 
  }

  @Override
  public void exitWhileStatement(@NotNull ECMAScriptParser.WhileStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitWhileStatement " + ctx); 
  }

  @Override
  public void enterReturnStatement(@NotNull ECMAScriptParser.ReturnStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterReturnStatement " + ctx); 
  }

  @Override
  public void exitReturnStatement(@NotNull ECMAScriptParser.ReturnStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitReturnStatement " + ctx); 
  }

  @Override
  public void enterPreDecreaseExpression(@NotNull ECMAScriptParser.PreDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPreDecreaseExpression " + ctx); 
  }

  @Override
  public void exitPreDecreaseExpression(@NotNull ECMAScriptParser.PreDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPreDecreaseExpression " + ctx); 
  }

  @Override
  public void enterExpressionSequence(@NotNull ECMAScriptParser.ExpressionSequenceContext ctx) {
     System.out.println("RuleContext visited : " + " enterExpressionSequence " + ctx); 
  }

  @Override
  public void exitExpressionSequence(@NotNull ECMAScriptParser.ExpressionSequenceContext ctx) {
     System.out.println("RuleContext visited : " + " exitExpressionSequence " + ctx); 
  }

  @Override
  public void enterLiteral(@NotNull ECMAScriptParser.LiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterLiteral " + ctx); 
  }

  @Override
  public void exitLiteral(@NotNull ECMAScriptParser.LiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitLiteral " + ctx); 
  }

  @Override
  public void enterSubtractExpression(@NotNull ECMAScriptParser.SubtractExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterSubtractExpression " + ctx); 
  }

  @Override
  public void exitSubtractExpression(@NotNull ECMAScriptParser.SubtractExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitSubtractExpression " + ctx); 
  }

  @Override
  public void enterDefaultClause(@NotNull ECMAScriptParser.DefaultClauseContext ctx) {
     System.out.println("RuleContext visited : " + " enterDefaultClause " + ctx); 
  }

  @Override
  public void exitDefaultClause(@NotNull ECMAScriptParser.DefaultClauseContext ctx) {
     System.out.println("RuleContext visited : " + " exitDefaultClause " + ctx); 
  }

  @Override
  public void enterPostDecreaseExpression(@NotNull ECMAScriptParser.PostDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPostDecreaseExpression " + ctx); 
  }

  @Override
  public void exitPostDecreaseExpression(@NotNull ECMAScriptParser.PostDecreaseExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPostDecreaseExpression " + ctx); 
  }

  @Override
  public void enterUnaryPlusExpression(@NotNull ECMAScriptParser.UnaryPlusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterUnaryPlusExpression " + ctx); 
  }

  @Override
  public void exitUnaryPlusExpression(@NotNull ECMAScriptParser.UnaryPlusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitUnaryPlusExpression " + ctx); 
  }

  @Override
  public void enterForStatement(@NotNull ECMAScriptParser.ForStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForStatement " + ctx); 
  }

  @Override
  public void exitForStatement(@NotNull ECMAScriptParser.ForStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForStatement " + ctx); 
  }

  @Override
  public void enterCaseBlock(@NotNull ECMAScriptParser.CaseBlockContext ctx) {
     System.out.println("RuleContext visited : " + " enterCaseBlock " + ctx); 
  }

  @Override
  public void exitCaseBlock(@NotNull ECMAScriptParser.CaseBlockContext ctx) {
     System.out.println("RuleContext visited : " + " exitCaseBlock " + ctx); 
  }

  @Override
  public void enterCaseClauses(@NotNull ECMAScriptParser.CaseClausesContext ctx) {
     System.out.println("RuleContext visited : " + " enterCaseClauses " + ctx); 
  }

  @Override
  public void exitCaseClauses(@NotNull ECMAScriptParser.CaseClausesContext ctx) {
     System.out.println("RuleContext visited : " + " exitCaseClauses " + ctx); 
  }

  @Override
  public void enterParenthesizedExpression(@NotNull ECMAScriptParser.ParenthesizedExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterParenthesizedExpression " + ctx); 
  }

  @Override
  public void exitParenthesizedExpression(@NotNull ECMAScriptParser.ParenthesizedExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitParenthesizedExpression " + ctx); 
  }

  @Override
  public void enterPostIncrementExpression(@NotNull ECMAScriptParser.PostIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPostIncrementExpression " + ctx); 
  }

  @Override
  public void exitPostIncrementExpression(@NotNull ECMAScriptParser.PostIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPostIncrementExpression " + ctx); 
  }

  @Override
  public void enterObjectLiteral(@NotNull ECMAScriptParser.ObjectLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " enterObjectLiteral " + ctx); 
  }

  @Override
  public void exitObjectLiteral(@NotNull ECMAScriptParser.ObjectLiteralContext ctx) {
     System.out.println("RuleContext visited : " + " exitObjectLiteral " + ctx); 
  }

  @Override
  public void enterThrowStatement(@NotNull ECMAScriptParser.ThrowStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterThrowStatement " + ctx); 
  }

  @Override
  public void exitThrowStatement(@NotNull ECMAScriptParser.ThrowStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitThrowStatement " + ctx); 
  }

  @Override
  public void enterMultiplyExpression(@NotNull ECMAScriptParser.MultiplyExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterMultiplyExpression " + ctx); 
  }

  @Override
  public void exitMultiplyExpression(@NotNull ECMAScriptParser.MultiplyExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitMultiplyExpression " + ctx); 
  }

  @Override
  public void enterVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " enterVariableDeclaration " + ctx + " " + ctx.Identifier() + " " + ctx.getText());
  }

  @Override
  public void exitVariableDeclaration(@NotNull ECMAScriptParser.VariableDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " exitVariableDeclaration " + ctx); 
  }

  @Override
  public void enterIdentifierExpression(@NotNull ECMAScriptParser.IdentifierExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterIdentifierExpression " + ctx); 
  }

  @Override
  public void exitIdentifierExpression(@NotNull ECMAScriptParser.IdentifierExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitIdentifierExpression " + ctx); 
  }

  @Override
  public void enterPropertyName(@NotNull ECMAScriptParser.PropertyNameContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyName " + ctx); 
  }

  @Override
  public void exitPropertyName(@NotNull ECMAScriptParser.PropertyNameContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyName " + ctx); 
  }

  @Override
  public void enterCaseClause(@NotNull ECMAScriptParser.CaseClauseContext ctx) {
     System.out.println("RuleContext visited : " + " enterCaseClause " + ctx); 
  }

  @Override
  public void exitCaseClause(@NotNull ECMAScriptParser.CaseClauseContext ctx) {
     System.out.println("RuleContext visited : " + " exitCaseClause " + ctx); 
  }

  @Override
  public void enterVariableDeclarationList(@NotNull ECMAScriptParser.VariableDeclarationListContext ctx) {
     System.out.println("RuleContext visited : " + " enterVariableDeclarationList " + ctx); 
  }

  @Override
  public void exitVariableDeclarationList(@NotNull ECMAScriptParser.VariableDeclarationListContext ctx) {
     System.out.println("RuleContext visited : " + " exitVariableDeclarationList " + ctx); 
  }

  @Override
  public void enterSetter(@NotNull ECMAScriptParser.SetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterSetter " + ctx); 
  }

  @Override
  public void exitSetter(@NotNull ECMAScriptParser.SetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitSetter " + ctx); 
  }

  @Override
  public void enterFunctionDeclaration(@NotNull ECMAScriptParser.FunctionDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " enterFunctionDeclaration " + ctx); 
  }

  @Override
  public void exitFunctionDeclaration(@NotNull ECMAScriptParser.FunctionDeclarationContext ctx) {
     System.out.println("RuleContext visited : " + " exitFunctionDeclaration " + ctx); 
  }

  @Override
  public void enterEqualsExpression(@NotNull ECMAScriptParser.EqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterEqualsExpression " + ctx); 
  }

  @Override
  public void exitEqualsExpression(@NotNull ECMAScriptParser.EqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitEqualsExpression " + ctx); 
  }

  @Override
  public void enterLeftShiftArithmeticExpression(@NotNull ECMAScriptParser.LeftShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLeftShiftArithmeticExpression " + ctx); 
  }

  @Override
  public void exitLeftShiftArithmeticExpression(@NotNull ECMAScriptParser.LeftShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLeftShiftArithmeticExpression " + ctx); 
  }

  @Override
  public void enterGetter(@NotNull ECMAScriptParser.GetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterGetter " + ctx); 
  }

  @Override
  public void exitGetter(@NotNull ECMAScriptParser.GetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitGetter " + ctx); 
  }

  @Override
  public void enterAssignmentOperator(@NotNull ECMAScriptParser.AssignmentOperatorContext ctx) {
     System.out.println("RuleContext visited : " + " enterAssignmentOperator " + ctx); 
  }

  @Override
  public void exitAssignmentOperator(@NotNull ECMAScriptParser.AssignmentOperatorContext ctx) {
     System.out.println("RuleContext visited : " + " exitAssignmentOperator " + ctx); 
  }

  @Override
  public void enterRightShiftLogicalExpression(@NotNull ECMAScriptParser.RightShiftLogicalExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterRightShiftLogicalExpression " + ctx); 
  }

  @Override
  public void exitRightShiftLogicalExpression(@NotNull ECMAScriptParser.RightShiftLogicalExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitRightShiftLogicalExpression " + ctx); 
  }

  @Override
  public void enterOrExpression(@NotNull ECMAScriptParser.OrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterOrExpression " + ctx); 
  }

  @Override
  public void exitOrExpression(@NotNull ECMAScriptParser.OrExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitOrExpression " + ctx); 
  }

  @Override
  public void enterThisExpression(@NotNull ECMAScriptParser.ThisExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterThisExpression " + ctx); 
  }

  @Override
  public void exitThisExpression(@NotNull ECMAScriptParser.ThisExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitThisExpression " + ctx); 
  }

  @Override
  public void enterFutureReservedWord(@NotNull ECMAScriptParser.FutureReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " enterFutureReservedWord " + ctx); 
  }

  @Override
  public void exitFutureReservedWord(@NotNull ECMAScriptParser.FutureReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " exitFutureReservedWord " + ctx); 
  }

  @Override
  public void enterStatementList(@NotNull ECMAScriptParser.StatementListContext ctx) {
     System.out.println("RuleContext visited : " + " enterStatementList " + ctx); 
  }

  @Override
  public void exitStatementList(@NotNull ECMAScriptParser.StatementListContext ctx) {
     System.out.println("RuleContext visited : " + " exitStatementList " + ctx); 
  }

  @Override
  public void enterPropertyGetter(@NotNull ECMAScriptParser.PropertyGetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyGetter " + ctx); 
  }

  @Override
  public void exitPropertyGetter(@NotNull ECMAScriptParser.PropertyGetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyGetter " + ctx); 
  }

  @Override
  public void enterKeyword(@NotNull ECMAScriptParser.KeywordContext ctx) {
     System.out.println("RuleContext visited : " + " enterKeyword " + ctx); 
  }

  @Override
  public void exitKeyword(@NotNull ECMAScriptParser.KeywordContext ctx) {
     System.out.println("RuleContext visited : " + " exitKeyword " + ctx); 
  }

  @Override
  public void enterElementList(@NotNull ECMAScriptParser.ElementListContext ctx) {
     System.out.println("RuleContext visited : " + " enterElementList " + ctx); 
  }

  @Override
  public void exitElementList(@NotNull ECMAScriptParser.ElementListContext ctx) {
     System.out.println("RuleContext visited : " + " exitElementList " + ctx); 
  }

  @Override
  public void enterBitNotExpression(@NotNull ECMAScriptParser.BitNotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterBitNotExpression " + ctx); 
  }

  @Override
  public void exitBitNotExpression(@NotNull ECMAScriptParser.BitNotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitBitNotExpression " + ctx); 
  }

  @Override
  public void enterPropertySetter(@NotNull ECMAScriptParser.PropertySetterContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertySetter " + ctx); 
  }

  @Override
  public void exitPropertySetter(@NotNull ECMAScriptParser.PropertySetterContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertySetter " + ctx); 
  }

  @Override
  public void enterLiteralExpression(@NotNull ECMAScriptParser.LiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLiteralExpression " + ctx); 
  }

  @Override
  public void exitLiteralExpression(@NotNull ECMAScriptParser.LiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLiteralExpression " + ctx); 
  }

  @Override
  public void enterArrayLiteralExpression(@NotNull ECMAScriptParser.ArrayLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterArrayLiteralExpression " + ctx); 
  }

  @Override
  public void exitArrayLiteralExpression(@NotNull ECMAScriptParser.ArrayLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitArrayLiteralExpression " + ctx); 
  }

  @Override
  public void enterMemberDotExpression(@NotNull ECMAScriptParser.MemberDotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterMemberDotExpression " + ctx); 
  }

  @Override
  public void exitMemberDotExpression(@NotNull ECMAScriptParser.MemberDotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitMemberDotExpression " + ctx); 
  }

  @Override
  public void enterMemberIndexExpression(@NotNull ECMAScriptParser.MemberIndexExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterMemberIndexExpression " + ctx); 
  }

  @Override
  public void exitMemberIndexExpression(@NotNull ECMAScriptParser.MemberIndexExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitMemberIndexExpression " + ctx); 
  }

  @Override
  public void enterFormalParameterList(@NotNull ECMAScriptParser.FormalParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " enterFormalParameterList " + ctx); 
  }

  @Override
  public void exitFormalParameterList(@NotNull ECMAScriptParser.FormalParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " exitFormalParameterList " + ctx); 
  }

  @Override
  public void enterForVarInStatement(@NotNull ECMAScriptParser.ForVarInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForVarInStatement " + ctx); 
  }

  @Override
  public void exitForVarInStatement(@NotNull ECMAScriptParser.ForVarInStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForVarInStatement " + ctx); 
  }

  @Override
  public void enterPropertySetParameterList(@NotNull ECMAScriptParser.PropertySetParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertySetParameterList " + ctx); 
  }

  @Override
  public void exitPropertySetParameterList(@NotNull ECMAScriptParser.PropertySetParameterListContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertySetParameterList " + ctx); 
  }

  @Override
  public void enterAssignmentOperatorExpression(@NotNull ECMAScriptParser.AssignmentOperatorExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAssignmentOperatorExpression " + ctx); 
  }

  @Override
  public void exitAssignmentOperatorExpression(@NotNull ECMAScriptParser.AssignmentOperatorExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAssignmentOperatorExpression " + ctx); 
  }

  @Override
  public void enterTryStatement(@NotNull ECMAScriptParser.TryStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterTryStatement " + ctx); 
  }

  @Override
  public void exitTryStatement(@NotNull ECMAScriptParser.TryStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitTryStatement " + ctx); 
  }

  @Override
  public void enterDebuggerStatement(@NotNull ECMAScriptParser.DebuggerStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterDebuggerStatement " + ctx); 
  }

  @Override
  public void exitDebuggerStatement(@NotNull ECMAScriptParser.DebuggerStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitDebuggerStatement " + ctx); 
  }

  @Override
  public void enterDoStatement(@NotNull ECMAScriptParser.DoStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterDoStatement " + ctx); 
  }

  @Override
  public void exitDoStatement(@NotNull ECMAScriptParser.DoStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitDoStatement " + ctx); 
  }

  @Override
  public void enterPreIncrementExpression(@NotNull ECMAScriptParser.PreIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterPreIncrementExpression " + ctx); 
  }

  @Override
  public void exitPreIncrementExpression(@NotNull ECMAScriptParser.PreIncrementExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitPreIncrementExpression " + ctx); 
  }

  @Override
  public void enterObjectLiteralExpression(@NotNull ECMAScriptParser.ObjectLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterObjectLiteralExpression " + ctx); 
  }

  @Override
  public void exitObjectLiteralExpression(@NotNull ECMAScriptParser.ObjectLiteralExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitObjectLiteralExpression " + ctx); 
  }

  @Override
  public void enterNotExpression(@NotNull ECMAScriptParser.NotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterNotExpression " + ctx); 
  }

  @Override
  public void exitNotExpression(@NotNull ECMAScriptParser.NotExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitNotExpression " + ctx); 
  }

  @Override
  public void enterSwitchStatement(@NotNull ECMAScriptParser.SwitchStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterSwitchStatement " + ctx); 
  }

  @Override
  public void exitSwitchStatement(@NotNull ECMAScriptParser.SwitchStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitSwitchStatement " + ctx); 
  }

  @Override
  public void enterVariableStatement(@NotNull ECMAScriptParser.VariableStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterVariableStatement " + ctx); 
  }

  @Override
  public void exitVariableStatement(@NotNull ECMAScriptParser.VariableStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitVariableStatement " + ctx); 
  }

  @Override
  public void enterFunctionExpression(@NotNull ECMAScriptParser.FunctionExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterFunctionExpression " + ctx); 
  }

  @Override
  public void exitFunctionExpression(@NotNull ECMAScriptParser.FunctionExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitFunctionExpression " + ctx); 
  }

  @Override
  public void enterUnaryMinusExpression(@NotNull ECMAScriptParser.UnaryMinusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterUnaryMinusExpression " + ctx); 
  }

  @Override
  public void exitUnaryMinusExpression(@NotNull ECMAScriptParser.UnaryMinusExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitUnaryMinusExpression " + ctx); 
  }

  @Override
  public void enterAssignmentExpression(@NotNull ECMAScriptParser.AssignmentExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterAssignmentExpression " + ctx); 
  }

  @Override
  public void exitAssignmentExpression(@NotNull ECMAScriptParser.AssignmentExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitAssignmentExpression " + ctx); 
  }

  @Override
  public void enterRightShiftArithmeticExpression(@NotNull ECMAScriptParser.RightShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterRightShiftArithmeticExpression " + ctx); 
  }

  @Override
  public void exitRightShiftArithmeticExpression(@NotNull ECMAScriptParser.RightShiftArithmeticExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitRightShiftArithmeticExpression " + ctx); 
  }

  @Override
  public void enterInstanceofExpression(@NotNull ECMAScriptParser.InstanceofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterInstanceofExpression " + ctx); 
  }

  @Override
  public void exitInstanceofExpression(@NotNull ECMAScriptParser.InstanceofExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitInstanceofExpression " + ctx); 
  }

  @Override
  public void enterStatement(@NotNull ECMAScriptParser.StatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterStatement " + ctx); 
  }

  @Override
  public void exitStatement(@NotNull ECMAScriptParser.StatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitStatement " + ctx); 
  }

  @Override
  public void enterDeleteExpression(@NotNull ECMAScriptParser.DeleteExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterDeleteExpression " + ctx); 
  }

  @Override
  public void exitDeleteExpression(@NotNull ECMAScriptParser.DeleteExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitDeleteExpression " + ctx); 
  }

  @Override
  public void enterLessThanEqualsExpression(@NotNull ECMAScriptParser.LessThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLessThanEqualsExpression " + ctx); 
  }

  @Override
  public void exitLessThanEqualsExpression(@NotNull ECMAScriptParser.LessThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLessThanEqualsExpression " + ctx); 
  }

  @Override
  public void enterPropertyNameAndValueList(@NotNull ECMAScriptParser.PropertyNameAndValueListContext ctx) {
     System.out.println("RuleContext visited : " + " enterPropertyNameAndValueList " + ctx); 
  }

  @Override
  public void exitPropertyNameAndValueList(@NotNull ECMAScriptParser.PropertyNameAndValueListContext ctx) {
     System.out.println("RuleContext visited : " + " exitPropertyNameAndValueList " + ctx); 
  }

  @Override
  public void enterForVarStatement(@NotNull ECMAScriptParser.ForVarStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterForVarStatement " + ctx); 
  }

  @Override
  public void exitForVarStatement(@NotNull ECMAScriptParser.ForVarStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitForVarStatement " + ctx); 
  }

  @Override
  public void enterSourceElement(@NotNull ECMAScriptParser.SourceElementContext ctx) {
     System.out.println("RuleContext visited : " + " enterSourceElement " + ctx); 
  }

  @Override
  public void exitSourceElement(@NotNull ECMAScriptParser.SourceElementContext ctx) {
     System.out.println("RuleContext visited : " + " exitSourceElement " + ctx); 
  }

  @Override
  public void enterBreakStatement(@NotNull ECMAScriptParser.BreakStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterBreakStatement " + ctx); 
  }

  @Override
  public void exitBreakStatement(@NotNull ECMAScriptParser.BreakStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitBreakStatement " + ctx); 
  }

  @Override
  public void enterIfStatement(@NotNull ECMAScriptParser.IfStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterIfStatement " + ctx); 
  }

  @Override
  public void exitIfStatement(@NotNull ECMAScriptParser.IfStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitIfStatement " + ctx); 
  }

  @Override
  public void enterReservedWord(@NotNull ECMAScriptParser.ReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " enterReservedWord " + ctx); 
  }

  @Override
  public void exitReservedWord(@NotNull ECMAScriptParser.ReservedWordContext ctx) {
     System.out.println("RuleContext visited : " + " exitReservedWord " + ctx); 
  }

  @Override
  public void enterFinallyProduction(@NotNull ECMAScriptParser.FinallyProductionContext ctx) {
     System.out.println("RuleContext visited : " + " enterFinallyProduction " + ctx); 
  }

  @Override
  public void exitFinallyProduction(@NotNull ECMAScriptParser.FinallyProductionContext ctx) {
     System.out.println("RuleContext visited : " + " exitFinallyProduction " + ctx); 
  }

  @Override
  public void enterGreaterThanEqualsExpression(@NotNull ECMAScriptParser.GreaterThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterGreaterThanEqualsExpression " + ctx); 
  }

  @Override
  public void exitGreaterThanEqualsExpression(@NotNull ECMAScriptParser.GreaterThanEqualsExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitGreaterThanEqualsExpression " + ctx); 
  }

  @Override
  public void enterCatchProduction(@NotNull ECMAScriptParser.CatchProductionContext ctx) {
     System.out.println("RuleContext visited : " + " enterCatchProduction " + ctx); 
  }

  @Override
  public void exitCatchProduction(@NotNull ECMAScriptParser.CatchProductionContext ctx) {
     System.out.println("RuleContext visited : " + " exitCatchProduction " + ctx); 
  }

  @Override
  public void enterContinueStatement(@NotNull ECMAScriptParser.ContinueStatementContext ctx) {
     System.out.println("RuleContext visited : " + " enterContinueStatement " + ctx); 
  }

  @Override
  public void exitContinueStatement(@NotNull ECMAScriptParser.ContinueStatementContext ctx) {
     System.out.println("RuleContext visited : " + " exitContinueStatement " + ctx); 
  }

  @Override
  public void enterArguments(@NotNull ECMAScriptParser.ArgumentsContext ctx) {
     System.out.println("RuleContext visited : " + " enterArguments " + ctx); 
  }

  @Override
  public void exitArguments(@NotNull ECMAScriptParser.ArgumentsContext ctx) {
     System.out.println("RuleContext visited : " + " exitArguments " + ctx); 
  }

  @Override
  public void enterFunctionBody(@NotNull ECMAScriptParser.FunctionBodyContext ctx) {
     System.out.println("RuleContext visited : " + " enterFunctionBody " + ctx); 
  }

  @Override
  public void exitFunctionBody(@NotNull ECMAScriptParser.FunctionBodyContext ctx) {
     System.out.println("RuleContext visited : " + " exitFunctionBody " + ctx); 
  }

  @Override
  public void enterEof(@NotNull ECMAScriptParser.EofContext ctx) {
     System.out.println("RuleContext visited : " + " enterEof " + ctx); 
  }

  @Override
  public void exitEof(@NotNull ECMAScriptParser.EofContext ctx) {
     System.out.println("RuleContext visited : " + " exitEof " + ctx); 
  }

  @Override
  public void enterLessThanExpression(@NotNull ECMAScriptParser.LessThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " enterLessThanExpression " + ctx); 
  }

  @Override
  public void exitLessThanExpression(@NotNull ECMAScriptParser.LessThanExpressionContext ctx) {
     System.out.println("RuleContext visited : " + " exitLessThanExpression " + ctx); 
  }

  @Override
  public void visitTerminal(@NotNull TerminalNode terminalNode) {
//     System.out.println("RuleContext visited : " + " visitTerminal " + ctx);
  }

  @Override
  public void visitErrorNode(@NotNull ErrorNode errorNode) {
//     System.out.println("RuleContext visited : " + " visitErrorNode " + ctx);
  }

  @Override
  public void enterEveryRule(@NotNull ParserRuleContext parserRuleContext) {
//     System.out.println("RuleContext visited : " + " enterEveryRule " + ctx);
  }

  @Override
  public void exitEveryRule(@NotNull ParserRuleContext parserRuleContext) {
//     System.out.println("RuleContext visited : " + " exitEveryRule " + ctx);
  }
}
