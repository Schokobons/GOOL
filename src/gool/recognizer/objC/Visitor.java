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
import DepotParser.OBJExpUnaire;
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
			case egal :
				op=Operator.EQUAL;
				sym="==";
				break;
			case different :
				op=Operator.NOT_EQUAL;
				sym="!=";
				break;
			case superieur :
				op=Operator.GT;
				sym=">";
				break;
			case inferieur :
				op=Operator.LT;
				sym="==";
				break;
			case superieurouegal :
				op=Operator.GEQ;
				sym="==";
				break;
			case inferieurouegal :
				op=Operator.LEQ;
				sym="==";
				break;
			default :
				op=Operator.UNKNOWN;
				break;			
		}
		
		expG = (Expression) expBinaire.getExpGauche().accept(this);
		expD = (Expression) expBinaire.getExpDroite().accept(this);
				
		return new BinaryOperation(op,expG,expD,null,sym);
		
	}

	public Object visitDeclaration(OBJDeclaration declaration) {
		IType typ = null;
		switch (declaration.getType()){
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
		VarDeclaration vardec = new VarDeclaration(typ, (String) declaration.getIdent().getNom());
		vardec.setInitialValue((Expression) declaration.getExp().accept(this));
		return vardec;
	}

	public Object visitConstanteReel(OBJConstanteReel constanteReel) {
		return new Constant(null,constanteReel.getConstantereel());
	}

	public Object visitConstanteEntier(OBJConstanteEntier constanteEntier) {
		return new Constant(null,constanteEntier.getConstentier());
	}

	public Object visitConstanteChaine(OBJConstanteChaine constanteChaine) {
		return new Constant(null,constanteChaine.getConstantechaine());
	}

	public Object visitConstanteCaractere(OBJConstanteCaractere constanteCaractere) {
		return new Constant(null,constanteCaractere.getConstantecaractere());
		
	}

	public Object visitConstanteBool(OBJConstanteBool constanteBool) {
		return new Constant(null,constanteBool.isConstantebool());
		
	}

	public Object visitCompoundStatement(OBJCompoundStatement compoundStatement) {
		Block b = new Block();
		int i;
		for (i = 0; i<compoundStatement.getDeclarationliste().size(); i++) {
			b.addStatement((Statement) compoundStatement.getDeclarationliste().get(i).accept(this));
		}

		for (i = i; i<compoundStatement.getListestatement().size(); i++) {
			b.addStatement((Statement) compoundStatement.getListestatement().get(i).accept(this));
		}
		
		return b;
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
		IType typ = null;
		switch (functionDefinition.getType()){
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
		Meth m = new Meth(typ,functionDefinition.getIdent().getNom());
		int i;
		for (i = 0; i<functionDefinition.getListeparam().size(); i++) {
			m.addParameter((VarDeclaration) functionDefinition.getListeparam().get(i).accept(this));
		}

		m.addStatements(((Block) functionDefinition.getBlock().accept(this)).getStatements());

		return m;
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
		return new VarDeclaration(typ, (String) parameterDeclaration.getIdent().getNom());
	}

	public Object visitExpUnaire(OBJExpUnaire objExpUnaire) {
		Operator op = Operator.NOT;
		String sym = "!";
		
		Expression exp = (Expression) objExpUnaire.getExp().accept(this);
				
		return new UnaryOperation(op,exp,null,sym);
	}

}
