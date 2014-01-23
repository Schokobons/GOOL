package gool.recognizer.objc;

import gool.ast.core.*;
import gool.ast.type.*;
import gool.parser.objc.core.*;

import java.util.ArrayList;
import java.util.List;



public class Visitor implements IVisitor {
		
	public Visitor(){};
	
	public Object visitSwitch(ObjCSwitch switch1) {
		Expression exp = (Expression) switch1.getExp().accept(this);
		
		List<Case> cases = null;
		if(switch1.getListecase()!=null){
			cases = new ArrayList<Case>();
			for (int i=0; i<switch1.getListecase().size(); i++) {
				cases.add((Case) switch1.getListecase().get(i).accept(this));
			}
		}
		return new Switch(exp, cases);
	}

	public Object visitReturn(ObjCReturn return1) {
		return new Return((Expression) return1.getExp().accept(this));
	}

	public Object visitObjCIDENT(ObjCIDENT objCIDENT) {
		
		IType typ = null;
		switch (objCIDENT.getType()){
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
		
		return new Identifier(typ,objCIDENT.getNom());
	}

	public Object visitIf(ObjCIf if1) {
		Statement th = null;
		if(if1.getTh()!=null){
			th = (Statement) if1.getTh().accept(this);
		}
		Statement el = null;
		if(if1.getTh()!=null){
			el = (Statement) if1.getEl().accept(this);
		}
		return new If((Expression) if1.getExp().accept(this), th, el);
	}

	public Object visitExpBinaire(ObjCExpBinaire expBinaire) {
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
				sym="<";
				break;
			case superieurouegal :
				op=Operator.GEQ;
				sym=">=";
				break;
			case inferieurouegal :
				op=Operator.LEQ;
				sym="<=";
				break;
			default :
				op=Operator.UNKNOWN;
				break;			
		}
		
		expG = (Expression) expBinaire.getExpGauche().accept(this);
		expD = (Expression) expBinaire.getExpDroite().accept(this);
				
		IType typ = null;
		switch (expBinaire.getType()){
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
		
		return new BinaryOperation(op,expG,expD,typ,sym);
		
	}

	public Object visitDeclaration(ObjCDeclaration declaration) {
		IType typ = null;
		switch (declaration.getTypeSpecifier().getType()){
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

	public Object visitConstante(ObjCConstante constante) {
		IType typ = null;
		switch (constante.getType()){
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
		return new Constant(typ,constante.getValeur());
	}

	public Object visitCompoundStatement(ObjCCompoundStatement compoundStatement) {
		Block b = new Block();
		int i=0;
		if(compoundStatement.getDeclarationliste()!=null){
			for (i = 0; i<compoundStatement.getDeclarationliste().size(); i++) {
				b.addStatement((Statement) compoundStatement.getDeclarationliste().get(i).accept(this));
			}
		}
		
		if(compoundStatement.getListestatement()!=null){
			for (i = 0; i<compoundStatement.getListestatement().size(); i++) {
				b.addStatement((Statement) compoundStatement.getListestatement().get(i).accept(this));
			}
		}
		
		return b;
	}

	public Object visitCase(ObjCCase case1) {
		Expression exp = (Expression) case1.getExp().accept(this);
		
		List<Statement> stats = null;
		if(case1.getListestatement()!=null){
			stats = new ArrayList<Statement>();
			for (int i=0; i<case1.getListestatement().size(); i++) {
				stats.add((Statement) case1.getListestatement().get(i).accept(this));
			}
		}
		return new Case(exp,stats);
	}

	public Object visitAssignement(ObjCAssignement assignement) {
		return new Assign((Node)assignement.getIdent().accept(this),(Expression)assignement.getExp().accept(this));
	}

	public Object visitFunctionDefinition(ObjCFunctionDefinition functionDefinition) {
		IType typ = null;
		switch (functionDefinition.getTypeSpecifier().getType()){
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
		if(functionDefinition.getListeparam()!=null){
			int i;
			for (i = 0; i<functionDefinition.getListeparam().size(); i++) {
				m.addParameter((VarDeclaration) functionDefinition.getListeparam().get(i).accept(this));
			}
		}

		if(functionDefinition.getBlock()!=null){
			m.addStatements(((Block) functionDefinition.getBlock().accept(this)).getStatements());
		}

		return m;
	}

	public Object visitParameterDeclaration(ObjCParameterDeclaration parameterDeclaration) {
		IType typ = null;
		switch (parameterDeclaration.getTypeSpecifier().getType()){
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

	public Object visitExpUnaire(ObjCExpUnaire objExpUnaire) {
		Operator op = Operator.NOT;
		String sym = "!";
		
		Expression exp = (Expression) objExpUnaire.getExpression().accept(this);
				
		IType typ = null;
		switch (objExpUnaire.getType()){
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
		
		return new UnaryOperation(op,exp,typ,sym);
	}

	public Object visitRacine(ObjCRacine objCRacine) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPrimaryExpression(ObjCPrimaryExpression objCPrimaryExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTypeSpecifier(ObjCTypeSpecifier objCTypeSpecifier) {
		return objCTypeSpecifier.getType();
	}

}
