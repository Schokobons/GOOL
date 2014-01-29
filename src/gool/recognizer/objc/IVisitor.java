package gool.recognizer.objc;

import gool.parser.objc.core.*;

public interface IVisitor {
	public Object visitSwitch(ObjCSwitch switch1);

	public Object visitReturn(ObjCReturn return1);

	public Object visitObjCIDENT(ObjCIDENT objCIDENT);

	public Object visitIf(ObjCIf if1);

	public Object visitExpBinaire(ObjCExpBinaire expBinaire);

	public Object visitDeclaration(ObjCDeclaration declaration);

	public Object visitConstante(ObjCConstante constanteReel);

	public Object visitCompoundStatement(ObjCCompoundStatement compoundStatement);

	public Object visitCase(ObjCCase case1);

	public Object visitAssignement(ObjCAssignement assignement);

	public Object visitFunctionDefinition(ObjCFunctionDefinition functionDefinition);

	public Object visitParameterDeclaration(ObjCParameterDeclaration parameterDeclaration);

	public Object visitRacine(ObjCRacine racine);

	public Object visitPrimaryExpression(ObjCPrimaryExpression primaryExpression);

	public Object visitTypeSpecifier(ObjCTypeSpecifier typeSpecifier);

	public Object visitMethode(ObjCMethode methode);

	public Object visitClassImplementation(ObjCClassImplementation classImplementation);

	public Object visitMessageSelector(ObjCMessageSelector objCMessageSelector);

	public Object visitMessageExpression(ObjCMessageExpression MessageExpression);

	public Object visitPostfixExpression(ObjCPostfixExpression PostfixExpression);
	
	public Object visitFor(ObjCFor For);
	
	public Object visitWhile(ObjCWhile While);
}
