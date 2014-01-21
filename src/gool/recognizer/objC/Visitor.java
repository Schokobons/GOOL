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
	
	public Object visitSwitch(OBJSwitch switch1) {
		Expression exp = (Expression) switch1.getExp().accept(this);
		
		List<Case> cases = new ArrayList<Case>();
		for (int i=0; i<switch1.getListecase().size(); i++) {
			cases.add((Case) switch1.getListecase().get(i).accept(this));
		}
		return new Switch(exp, cases);

	}

	public Object visitReturn(OBJReturn return1) {
		return new Return((Expression) return1.getExp().accept(this));
	}

	public Object visitObjCIDENT(OBJCIDENT objCIDENT) {
		return new Identifier(null,objCIDENT.getNom());
		
	}

	public Object visitIf(OBJIf if1) {
		
		return new If((Expression) if1.getExp().accept(this),
				(Statement) if1.getTh().accept(this),(Statement) if1.getEl().accept(this));
		
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
			case egal :
				op=Operator.EQUAL;
				sym="==";
				break;
			default :
				op=Operator.UNKNOWN;
				break;			
		}
		
		OBJExpression objexpG = expBinaire.getExpGauche();
		OBJExpression objexpD = expBinaire.getExpDroite();	
		expG = (Expression) objexpG.accept(this);
		expD = (Expression) objexpD.accept(this);
				
		return new BinaryOperation(op,expG,expD,null,sym);
		
	}

	public Object visitDeclaration(OBJDeclaration declaration) {
		
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitConstanteReel(OBJConstanteReel constanteReel) {
		return new Constant(null,this);
	}

	public Object visitConstanteEntier(OBJConstanteEntier constanteEntier) {
		return new Constant(null,this);
	}

	public Object visitConstanteChaine(OBJConstanteChaine constanteChaine) {
		return new Constant(null,this);
	}

	public Object visitConstanteCaractere(OBJConstanteCaractere constanteCaractere) {
		return new Constant(null,this);
		
	}

	public Object visitConstanteBool(OBJConstanteBool constanteBool) {
		return new Constant(null,this);
		
	}

	public Object visitCompoundStatement(OBJCompoundStatement compoundStatement) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public Object visitCase(OBJCase case1) {
		Expression exp = (Expression) case1.getExp().accept(this);
		
		List<Statement> stats = new ArrayList<Statement>();
		for (int i=0; i<case1.getListestatement().size(); i++) {
			stats.add((Statement) case1.getListestatement().get(i).accept(this));
		}
		return new Case(exp,stats);
	}

	public Object visitAssignement(OBJAssignement assignement) {
		
		return new Assign((Node)assignement.getIdent().accept(this),(Expression)assignement.getExp().accept(this));
	}

	public Object visitFunctionDefinition(OBJFunctionDefinition functionDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitParameterDeclaration(OBJParameterDeclaration parameterDeclaration) {
		
		IType typ = null;
		switch (parameterDeclaration.getType()){
			case entier:
				typ = TypeInt.INSTANCE;
				break;
			case reel:
				typ = TypeDecimal.INSTANCE;
				break;
			case caractere:
				typ = TypeChar.INSTANCE;
				break;
			case chaine:
				typ = TypeString.INSTANCE;
				break;
			case booleen:
				typ = TypeBool.INSTANCE;
				break;
			case vide: 
				typ = TypeVoid.INSTANCE;
				break;
			case inconnu: 
				typ = new TypeUnknown("Inconnu");
				break;
		}
		return new VarDeclaration(typ, (String) parameterDeclaration.getIdent().accept(this));
	}

}
