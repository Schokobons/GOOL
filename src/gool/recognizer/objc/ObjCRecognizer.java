package gool.recognizer.objc;

import gool.ast.core.*;
import gool.ast.type.*;
import gool.generator.common.Platform;
import gool.parser.objc.core.*;
import gool.parser.objc.jtb.core.TranslationUnit;
import gool.parser.objc.jtb.visitor.DepthFirstRetArguVisitor;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sun.mirror.declaration.ParameterDeclaration;

import gool.parser.objc.*;

public class ObjCRecognizer implements IVisitor {

	public ObjCRecognizer() {}

	/*
	There are 4 steps to create an abstract gool tree from an inputFile.
	
	Step 1 : We use a parser created by javacc and JTB to create objc tree from the inputFile.
	
	Step 2 : We use the visitor in gool.parser.objc.jtb.visitor to create a simple version of objc tree
			 with some gool's structures.
	
	Step 3 : We search in our tree for informations to type all the expressions.
	
	Step 4 : We use this Visitor to create the gool tree from the simple objc tree.
	 */
	public static Collection<ClassDef> parseGool(Platform defaultPlatform,
			Collection<? extends File> inputFiles) throws Exception {
		Collection<ClassDef> result = new ArrayList<ClassDef>();
		Iterator<? extends File> it = inputFiles.iterator();
		while (it.hasNext()) {
			File courant = it.next();
			ObjCParser parser = new ObjCParser(new java.io.FileInputStream(courant));
			try {
				TranslationUnit tu = parser.TranslationUnit(); //Step 1
				DepthFirstRetArguVisitor<String, ObjCNoeud> v1 = new DepthFirstRetArguVisitor<String, ObjCNoeud>();
				ObjCRacine root = new ObjCRacine();
				v1.visit(tu, root); //Step 2
				root.typageExpression(); // Step 3
				ObjCRecognizer v = new ObjCRecognizer();
				ClassDef classe = (ClassDef) v.visitRacine(root); // Step 4
				classe.setPlatform(defaultPlatform);
				result.add(classe);
			} catch (ParseException e) {
				System.err.println("Encountered errors during parse.");
			}
		}
		return result;
	}

	private Modifier modiftoModifier(ObjCModifier modif) {
		Modifier mod = null;
		switch (modif) {
		case PUBLIC:mod = Modifier.PUBLIC;break;
		case PRIVE:mod = Modifier.PRIVATE;break;
		}
		return mod;
	}

	private IType typetoIType(ObjCTypeSpecifier type) {
		IType iType = null;
		if (type != null && type.getType() != null) {
			switch (type.getType()) {
			case entier:iType = TypeInt.INSTANCE;break;
			case reel:iType = TypeDecimal.INSTANCE;break;
			case caractere:iType = TypeChar.INSTANCE;break;
			case chaine:iType = TypeString.INSTANCE;break;
			case booleen:iType = TypeBool.INSTANCE;break;
			case vide:iType = TypeVoid.INSTANCE;break;
			case objet:iType = TypeObject.INSTANCE;break;
			default:iType = new TypeUnknown(type.getName());break;
			}
		}
		return iType;
	}

	public Object visitSwitch(ObjCSwitch switch1) {
		Expression exp = (Expression) switch1.getExp().accept(this);

		List<Case> cases = null;
		if (switch1.getListecase() != null) {
			cases = new ArrayList<Case>();
			for (int i = 0; i < switch1.getListecase().size(); i++) {
				cases.add((Case) switch1.getListecase().get(i).accept(this));
			}
		}
		return new Switch(exp, cases);
	}

	public Object visitReturn(ObjCReturn return1) {
		return new Return((Expression) return1.getExp().accept(this));
	}

	public Object visitObjCIDENT(ObjCIDENT objCIDENT) {
		return new Identifier(typetoIType(objCIDENT.getTypeSpecifier()),objCIDENT.getNom());
	}

	public Object visitIf(ObjCIf if1) {
		Statement th = null;
		if (if1.getTh() != null) {
			th = (Statement) if1.getTh().accept(this);
		}
		Statement el = null;
		if (if1.getEl() != null) {
			el = (Statement) if1.getEl().accept(this);
		}
		return new If((Expression) if1.getExp().accept(this), th, el);
	}

	public Object visitExpBinaire(ObjCExpBinaire expBinaire) {
		Operator op = null;
		String sym = null;
		Expression expG = null, expD = null;
		switch (expBinaire.getOperation()) {
		case plus:op = Operator.PLUS;sym = "+";break;
		case moins:op = Operator.MINUS;sym = "-";break;
		case multiplier:op = Operator.MULT;sym = "*";break;
		case diviser:op = Operator.DIV;sym = "/";break;
		case et:op = Operator.AND;sym = "&&";break;
		case ou:op = Operator.OR;sym = "||";break;
		case egal:op = Operator.EQUAL;sym = "==";break;
		case different:op = Operator.NOT_EQUAL;sym = "!=";break;
		case superieur:op = Operator.GT;sym = ">";break;
		case inferieur:op = Operator.LT;sym = "<";break;
		case superieurouegal:op = Operator.GEQ;sym = ">=";break;
		case inferieurouegal:op = Operator.LEQ;sym = "<=";break;
		default:op = Operator.UNKNOWN;break;
		}
		expG = (Expression) expBinaire.getExpGauche().accept(this);
		expD = (Expression) expBinaire.getExpDroite().accept(this);
		return new BinaryOperation(op, expG, expD,
				typetoIType(expBinaire.getTypeSpecifier()), sym);

	}

	public Object visitDeclaration(ObjCDeclaration declaration) {
		VarDeclaration vardec = new VarDeclaration(typetoIType(declaration.getTypeSpecifier()),(String) declaration.getIdent().getNom());
		if (declaration.getExp() != null)
			vardec.setInitialValue((Expression) declaration.getExp().accept(this));
		return vardec;
	}

	public Object visitConstante(ObjCConstante constante) {
		return new Constant(typetoIType(constante.getTypeSpecifier()),constante.getValeur());
	}

	public Object visitCompoundStatement(ObjCCompoundStatement compoundStatement) {
		Block b = new Block();
		int i = 0;
		if (compoundStatement.getDeclarationliste() != null) {
			for (i = 0; i < compoundStatement.getDeclarationliste().size(); i++) {
				b.addStatement((Statement) compoundStatement.getDeclarationliste().get(i).accept(this));
			}
		}

		if (compoundStatement.getListestatement() != null) {
			for (i = 0; i < compoundStatement.getListestatement().size(); i++) {
				b.addStatement((Statement) compoundStatement.getListestatement().get(i).accept(this));
			}
		}

		return b;
	}

	public Object visitCase(ObjCCase case1) {
		Expression exp = (Expression) case1.getExp().accept(this);

		List<Statement> stats = null;
		if (case1.getListeStatement() != null) {
			stats = new ArrayList<Statement>();
			for (int i = 0; i < case1.getListeStatement().size(); i++) {
				stats.add((Statement) case1.getListeStatement().get(i).accept(this));
			}
		}
		return new Case(exp, stats);
	}

	public Object visitAssignement(ObjCAssignement assignement) {
		return new Assign((Node) assignement.getIdent().accept(this),(Expression) assignement.getExp().accept(this));
	}

	public Object visitFunctionDefinition(
			ObjCFunctionDefinition functionDefinition) {
		Meth m = new Meth(typetoIType(functionDefinition.getTypeSpecifier()),functionDefinition.getIdent().getNom());
		if (functionDefinition.getListeParam() != null) {
			int i;
			for (i = 0; i < functionDefinition.getListeParam().size(); i++) {
				m.addParameter((VarDeclaration) functionDefinition.getListeParam().get(i).accept(this));
			}
		}

		if (functionDefinition.getBlock() != null) {
			m.addStatements(((Block) functionDefinition.getBlock().accept(this)).getStatements());
		}
		return m;
	}

	public Object visitParameterDeclaration(ObjCParameterDeclaration parameterDeclaration) {
		if(parameterDeclaration.getIdent() == null) 
			return new VarDeclaration(typetoIType(parameterDeclaration.getTypeSpecifier()),"");
		return new VarDeclaration(typetoIType(parameterDeclaration.getTypeSpecifier()),(String) parameterDeclaration.getIdent().getNom());
	}

	public Object visitExpUnaire(ObjCExpUnaire expUnaire) {
		if(expUnaire == null || expUnaire.getOperation() == null || expUnaire.getExpression() == null)
			return null;
		Operator op = null;
		String sym = null;
		switch(expUnaire.getOperation())
		{
		case non : op = Operator.NOT; sym = "!"; break;
		case preIncrement : op = Operator.PREFIX_INCREMENT; sym = "++"; break;
		case preDecrement : op = Operator.PREFIX_DECREMENT; sym = "--"; break;
		}
		Expression exp = (Expression) expUnaire.getExpression().accept(this);
		return new UnaryOperation(op, exp,typetoIType(expUnaire.getTypeSpecifier()), sym);
	}

	public Object visitRacine(ObjCRacine objCRacine) {
		if (objCRacine.getClassImplementation() != null)
			return objCRacine.getClassImplementation().accept(this);
		if (objCRacine.getClassInterface() != null)
			return objCRacine.getClassInterface().accept(this);
		// On genere un nom aleatoire
		String nom = "Random";
		for (int i = 0; i < 5; i++)
			nom += (int) Math.floor(Math.random() * 10);
		ClassDef cd = new ClassDef(nom);
		for (int i = 0; i < objCRacine.getFils().size(); i++) {
			if (ObjCDeclaration.class.isInstance(objCRacine.getFils().get(i))) {
				if (((ObjCDeclaration) objCRacine.getFils().get(i)).getExp() != null)
					cd.addField(new Field(Modifier.PUBLIC,((ObjCDeclaration) objCRacine.getFils().get(i)).getIdent().getNom(),
							typetoIType(((ObjCDeclaration) objCRacine.getFils().get(i)).getTypeSpecifier()),
							(Expression) ((ObjCDeclaration) objCRacine.getFils().get(i)).getExp().accept(this)));
				else
					cd.addField(new Field(Modifier.PUBLIC,
							((ObjCDeclaration) objCRacine.getFils().get(i)).getIdent().getNom(),
							typetoIType(((ObjCDeclaration) objCRacine.getFils().get(i)).getTypeSpecifier())));
			}
			if (ObjCModifier.class.isInstance(objCRacine.getFils().get(i)))
				cd.addMethod((Meth) ((ObjCMethode) objCRacine.getFils().get(i)).accept(this));
			if (ObjCFunctionDefinition.class.isInstance(objCRacine.getFils().get(i)))
				cd.addMethod((Meth) ((ObjCFunctionDefinition) objCRacine.getFils().get(i)).accept(this));
		}
		return cd;
	}

	public Object visitTypeSpecifier(ObjCTypeSpecifier objCTypeSpecifier) {
		return objCTypeSpecifier.getType();
	}

	@Override
	public Object visitMethode(ObjCMethode methode) {
		IType type;
		if (methode.getTypeRetour() == null)
			type = typetoIType(ObjCTypeSpecifier.INSTANCEvide);
		else
			type = typetoIType(methode.getTypeRetour());
		Meth m = new Meth(type, modiftoModifier(methode.getModifier()),methode.getNom());
		if (methode.getListeParam() != null) {
			int i;
			for (i = 0; i < methode.getListeParam().size(); i++) {
				m.addParameter((VarDeclaration) methode.getListeParam().get(i).accept(this));
			}
		}

		if (methode.getBlock() != null) {
			m.addStatements(((Block) methode.getBlock().accept(this)).getStatements());
		}
		return m;
	}

	@Override
	public Object visitClassImplementation(
			ObjCClassImplementation classImplementation) {
		ClassDef cd = new ClassDef(classImplementation.getNom().getNom());
		for (int i = 0; i < classImplementation.getListedeclaration().size(); i++)
			if (classImplementation.getListedeclaration().get(i).getExp() == null)
				cd.addField(new Field(Modifier.PUBLIC, classImplementation
						.getListedeclaration().get(i).getIdent().getNom(),
						typetoIType(classImplementation.getListedeclaration().get(i).getTypeSpecifier())));
			else
				cd.addField(new Field(Modifier.PUBLIC, classImplementation
						.getListedeclaration().get(i).getIdent().getNom(),
						typetoIType(classImplementation.getListedeclaration().get(i).getTypeSpecifier()),
						(Expression) classImplementation.getListedeclaration().get(i).getExp().accept(this)));
		for (int i = 0; i < classImplementation.getListemethode().size(); i++)
			cd.addMethod((Meth) classImplementation.getListemethode().get(i).accept(this));
		return cd;
	}

	public Object visitClassInterface(ObjCClassInterface ClassInterface) {
		ClassDef cd = new ClassDef(ClassInterface.getNom().getNom());
		cd.setIsInterface(true);
		for (int i = 0; i < ClassInterface.getListedeclaration().size(); i++)
			if (ClassInterface.getListedeclaration().get(i).getExp() == null)
				cd.addField(new Field(Modifier.PUBLIC, ClassInterface
						.getListedeclaration().get(i).getIdent().getNom(),
						typetoIType(ClassInterface.getListedeclaration().get(i).getTypeSpecifier())));
			else
				cd.addField(new Field(Modifier.PUBLIC, ClassInterface
						.getListedeclaration().get(i).getIdent().getNom(),
						typetoIType(ClassInterface.getListedeclaration().get(i).getTypeSpecifier()),
						(Expression) ClassInterface.getListedeclaration().get(i).getExp().accept(this)));
		for (int i = 0; i < ClassInterface.getListemethodes().size(); i++)
			cd.addMethod((Meth) ClassInterface.getListemethodes().get(i).accept(this));
		return cd;
	}

	public Object visitMethodeDeclaration(ObjCMethodDeclaration MethodDeclaration) {
		IType type;
		if (MethodDeclaration.getTypeRetour() == null)
			type = typetoIType(ObjCTypeSpecifier.INSTANCEvide);
		else
			type = typetoIType(MethodDeclaration.getTypeRetour());
		Meth m = new Meth(type,
				modiftoModifier(MethodDeclaration.getModifier()),MethodDeclaration.getName());
		if (MethodDeclaration.getListeParam() != null) {
			int i;
			for (i = 0; i < MethodDeclaration.getListeParam().size(); i++) {
				m.addParameter((VarDeclaration) MethodDeclaration.getListeParam().get(i).accept(this));
			}
		}
		return m;
	}

	public Object visitMessageSelector(ObjCMessageSelector MessageSelector) {
		// Unused, everything is in visitMessageExpression.
		return null;
	}

	public Object visitMessageExpression(ObjCMessageExpression MessageExpression) {
		// TODO See MethCall for add libraries.
		IType type;
		if (MessageExpression.getTypeSpecifier() == null || MessageExpression.getTypeSpecifier().getType() == null)
			type = typetoIType(ObjCTypeSpecifier.INSTANCEvide);
		else
			type = typetoIType(MessageExpression.getTypeSpecifier());	
		MethCall mc = new MethCall(type, new FieldAccess(typetoIType(MessageExpression.getObjet().getTypeSpecifier()),
				(Expression) MessageExpression.getObjet().accept(this), MessageExpression.getMessageSelector().getMethName())
				, MessageExpression.getMessageSelector().getMethName(), null);
		if (MessageExpression.getMessageSelector().getArguments() != null)
			for (int i = 0; i < MessageExpression.getMessageSelector().getArguments().size(); i++)
				mc.addParameter((Expression) MessageExpression.getMessageSelector().getArguments().get(i).accept(this));
		return mc;
	}

	public Object visitFor(ObjCFor For) {
		return new For((Statement) For.getAssignement().accept(this), (Expression) For.getCondition().accept(this),
				(Statement) For.getModification().accept(this), (Statement) For.getCompoundStatment().accept(this));
	}

	public Object visitWhile(ObjCWhile While) {
		return new While((Expression) While.getCondition().accept(this), (Statement) While.getCompoundStatment().accept(this));
	}

	public Object visitPostfixExpression(ObjCPostfixExpression postfixExpression) {
		if(postfixExpression.getnom().equals("++") && postfixExpression.getArguments() != null && postfixExpression.getArguments().size() > 0) {
			Operator op = Operator.POSTFIX_INCREMENT;
			String sym = "++";
			Expression exp = (Expression) postfixExpression.getArguments().get(0).accept(this);
			return new UnaryOperation(op, exp,typetoIType(postfixExpression.getTypeSpecifier()), sym);
		}
		else if(postfixExpression.getnom().equals("--") && postfixExpression.getArguments() != null && postfixExpression.getArguments().size() > 0) {
				Operator op = Operator.POSTFIX_DECREMENT;
				String sym = "--";
				Expression exp = (Expression) postfixExpression.getArguments().get(0).accept(this);
				return new UnaryOperation(op, exp,typetoIType(postfixExpression.getTypeSpecifier()), sym);
			}
		// TODO NSLog
		return null;
	}

	public Object visitPrimaryExpression(
			ObjCPrimaryExpression primaryExpression) {
		// TODO Auto-generated method stub
		return null;
	}
}
