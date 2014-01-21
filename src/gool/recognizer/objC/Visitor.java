package gool.recognizer.objC;

import gool.ast.core.*;
import gool.ast.type.*;

import java.util.ArrayList;
import java.util.List;

import DepotParser.OBJAssignement;
import DepotParser.OBJCase;
import DepotParser.OBJCompoundStatement;
import DepotParser.OBJConstanteBool;
import DepotParser.OBJConstanteCaractere;
import DepotParser.OBJConstanteChaine;
import DepotParser.OBJConstanteEntier;
import DepotParser.OBJConstanteReel;
import DepotParser.OBJDeclaration;
import DepotParser.OBJExpBinaire;
import DepotParser.OBJExpression;
import DepotParser.OBJFunctionDefinition;
import DepotParser.OBJIf;
import DepotParser.OBJCIDENT;
import DepotParser.OBJParameterDeclaration;
import DepotParser.OBJReturn;
import DepotParser.OBJSwitch;

public class Visitor {
	
	public void visitSwitch(OBJSwitch switch1) {
		/*Expression exp = switch1.getExp().accept(this);
		
		List<Case> cases = new ArrayList<Case>();
		for (int i=0; i<switch1.getListecase().size(); i++) {
			cases.add((Case) switch1.getListecase().get(i).accept(this));
		}
		return new Switch(exp, cases);*/
	}

	public void visitReturn(OBJReturn return1) {
		/*if(OBJCIDENT.class.isInstance(return1.getExp().accept(this))){
			return new Return(Identifier(null,return1.getExp().accept(this).
		}
		return new Return((Expression) return1.getExp().accept(this);*/
		
	}

	public Object visitObjCIDENT(OBJCIDENT objCIDENT) {
		return new Identifier(null,objCIDENT.getNom());
		
	}

	public void visitIf(OBJIf if1) {
		// TODO Auto-generated method stub
		
	}

	public Object visitExpBinaire(OBJExpBinaire expBinaire) {
		Operator op = null;
		String sym = null;
		Expression expG = null,expD = null;
		switch(expBinaire.getOperation()){
			case plus :
				op=Operator.PLUS;
				sym="+";
				break;
			case moins :
				op=Operator.MINUS;
				sym="-";
				break;
			case multiplier :
				op=Operator.MULT;
				sym="*";
				break;
			case diviser :
				op=Operator.DIV;
				sym="/";
				break;
			case et :
				op=Operator.AND;
				sym="&&";
				break;
			case ou :
				op=Operator.OR;
				sym="||";
				break;
			case non :
				op=Operator.NOT;
				sym="!";
				break;
			default :
				op=Operator.UNKNOWN;
				break;			
		}
		
		OBJExpression objexpG = expBinaire.getExpGauche().accept(this);
		OBJExpression objexpD = expBinaire.getExpDroite().accept(this);
		
		if(OBJCIDENT.class.isInstance(objexpG)){
			expG=new Identifier(null,((OBJCIDENT) (objexpG)).getNom());
		}
		if(OBJCIDENT.class.isInstance(objexpD)){
			expD=new Identifier(null,((OBJCIDENT) (objexpD)).getNom());
		}
		
		return new BinaryOperation(op,expG,expD,null,sym);
		
	}

	public void visitDeclaration(OBJDeclaration declaration) {
		// TODO Auto-generated method stub
		
	}

	public Object visitConstanteReel(OBJConstanteReel constanteReel) {
		return new Constant(null,this);
		// TODO Auto-generated method stub
	}

	public Object visitConstanteEntier(OBJConstanteEntier constanteEntier) {
		return new Constant(null,this);
		// TODO Auto-generated method stub
	}

	public Object visitConstanteChaine(OBJConstanteChaine constanteChaine) {
		return new Constant(null,this);
		// TODO Auto-generated method stub
	}

	public Object visitConstanteCaractere(OBJConstanteCaractere constanteCaractere) {
		return new Constant(null,this);
		// TODO Auto-generated method stub
		
	}

	public Object visitConstanteBool(OBJConstanteBool constanteBool) {
		return new Constant(null,this);
		// TODO Auto-generated method stub
		
	}

	public void visitCompoundStatement(OBJCompoundStatement compoundStatement) {
		// TODO Auto-generated method stub
		
	}

	public void visitCase(OBJCase case1) {
		// TODO Auto-generated method stub
		
	}

	public void visitAssignement(OBJAssignement assignement) {
		// TODO Auto-generated method stub
		
	}

	public void visitFunctionDefinition(OBJFunctionDefinition functionDefinition) {
		// TODO Auto-generated method stub
		
	}

	public void visitParameterDeclaration(
			OBJParameterDeclaration parameterDeclaration) {
		// TODO Auto-generated method stub
		
	}

}
