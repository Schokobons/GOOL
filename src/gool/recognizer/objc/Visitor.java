package gool.recognizer.objc;

import gool.ast.core.*;
import gool.ast.type.*;
import gool.parser.objc.core.*;

import java.util.ArrayList;
import java.util.List;



public class Visitor implements IVisitor {
	
	private Modifier modiftoModifier(ObjCModifier modif) {
		Modifier mod = null;
		switch (modif)
		{
		case PUBLIC : mod = Modifier.PUBLIC; break;
		case PRIVE : mod = Modifier.PRIVATE; break;
		}
		return mod;
	}
	
	private IType typetoIType (ObjCType type) {
		IType iType= null;
		switch (type){
			case entier:
				iType = TypeInt.INSTANCE;
				break;
			case reel:
				iType = TypeDecimal.INSTANCE;
				break;
			case caractere:
				iType = TypeChar.INSTANCE;
				break;
			case chaine:
				iType = TypeString.INSTANCE;
				break;
			case booleen:
				iType = TypeBool.INSTANCE;
				break;
			case vide: 
				iType = TypeVoid.INSTANCE;
				break;
			default : 
				iType = new TypeUnknown("Inconnu");
				break;
		}
		return iType;
	}
	
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
		return new Identifier(typetoIType(objCIDENT.getType()),objCIDENT.getNom());
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
				
		return new BinaryOperation(op,expG,expD,typetoIType(expBinaire.getType()),sym);
		
	}

	public Object visitDeclaration(ObjCDeclaration declaration) {
		IType typ = typetoIType((ObjCType) declaration.getTypeSpecifier().accept(this));
		VarDeclaration vardec = new VarDeclaration(typ, (String) declaration.getIdent().getNom());
		if(declaration.getExp() != null)
			vardec.setInitialValue((Expression) declaration.getExp().accept(this));
		return vardec;
	}

	public Object visitConstante(ObjCConstante constante) {
		return new Constant(typetoIType(constante.getType()),constante.getValeur());
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
		IType typ = typetoIType((ObjCType) functionDefinition.getTypeSpecifier().accept(this));
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
		IType typ = typetoIType((ObjCType) parameterDeclaration.getTypeSpecifier().accept(this));
		return new VarDeclaration(typ, (String) parameterDeclaration.getIdent().getNom());
	}

	public Object visitExpUnaire(ObjCExpUnaire objExpUnaire) {
		Operator op = Operator.NOT;
		String sym = "!";
		
		Expression exp = (Expression) objExpUnaire.getExpression().accept(this);
				
		return new UnaryOperation(op,exp,typetoIType(objExpUnaire.getType()),sym);
	}

	public Object visitRacine(ObjCRacine objCRacine) {
		if(objCRacine.getClassImplementation() != null)
			return objCRacine.getClassImplementation().accept(this);
		//On genere un nom aleatoire
		String nom = "Random";
		for(int i = 0; i < 5; i++)
			nom += (int)Math.floor(Math.random() *10);
		ClassDef cd = new ClassDef(nom);
		for(int i = 0; i < objCRacine.getFils().size(); i++) {
			if(ObjCDeclaration.class.isInstance(objCRacine.getFils().get(i)))
				cd.addField(new Field(Modifier.PUBLIC, ((ObjCDeclaration)objCRacine.getFils().get(i)).getIdent().getNom(),
						typetoIType(((ObjCDeclaration)objCRacine.getFils().get(i)).getTypeSpecifier().getType()), (Expression) ((ObjCDeclaration)objCRacine.getFils().get(i)).getExp().accept(this)));
			if(ObjCModifier.class.isInstance(objCRacine.getFils().get(i)))
				cd.addMethod((Meth) ((ObjCMethode)objCRacine.getFils().get(i)).accept(this)); 
		}
		return cd;
	}

	public Object visitPrimaryExpression(ObjCPrimaryExpression objCPrimaryExpression) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTypeSpecifier(ObjCTypeSpecifier objCTypeSpecifier) {
		return objCTypeSpecifier.getType();
	}

	@Override
	public Object visitMethode(ObjCMethode methode) {
		IType type;
		if(methode.getTypeRetour() == null)
			type = typetoIType(ObjCType.inconnu);
		else
			type = typetoIType((ObjCType) methode.getTypeRetour().accept(this));
		Meth m = new Meth(type, modiftoModifier(methode.getModifier()), methode.getNom());
		if(methode.getListeparam()!=null){
			int i;
			for (i = 0; i<methode.getListeparam().size(); i++) {
				m.addParameter((VarDeclaration) methode.getListeparam().get(i).accept(this));
			}
		}

		if(methode.getBlock()!=null){
			m.addStatements(((Block) methode.getBlock().accept(this)).getStatements());
		}

		return m;
	}

	@Override
	public Object visitClassImplementation(ObjCClassImplementation classImplementation) {
		ClassDef cd = new ClassDef(classImplementation.getNom().getNom());
		for(int i = 0; i < classImplementation.getListedeclaration().size(); i++)
			if(classImplementation.getListedeclaration().get(i).getExp() == null)
				cd.addField(new Field(Modifier.PUBLIC, classImplementation.getListedeclaration().get(i).getIdent().getNom(),
						typetoIType(classImplementation.getListedeclaration().get(i).getTypeSpecifier().getType())));
			else
				cd.addField(new Field(Modifier.PUBLIC, classImplementation.getListedeclaration().get(i).getIdent().getNom(),
					typetoIType(classImplementation.getListedeclaration().get(i).getTypeSpecifier().getType()), (Expression) classImplementation.getListedeclaration().get(i).getExp().accept(this)));
		for(int i = 0; i < classImplementation.getListemethode().size(); i++)
			cd.addMethod((Meth) classImplementation.getListemethode().get(i).accept(this)); 
		return cd;
	}

}
