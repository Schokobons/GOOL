package gool.recognizer.objc;

import gool.ast.core.*;
import gool.parser.objc.core.*;

import java.util.ArrayList;
import java.util.List;


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
}