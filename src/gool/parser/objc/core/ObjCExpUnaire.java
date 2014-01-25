package gool.parser.objc.core;

import gool.recognizer.objc.*;




public class ObjCExpUnaire extends ObjCExpression {
	
	private ObjCOperation operation;
	private ObjCExpression expression;
	
	public ObjCExpUnaire(ObjCOperation op, ObjCExpression exp){
		this.operation=op;
		this.expression=exp;
		switch(operation)
		{
		case et :
		case ou :
		case non :
		case different :
		case superieurouegal :
		case inferieurouegal :
		case superieur :
		case inferieur :
		case egal : setTypeSpecifier(new ObjCTypeSpecifier(ObjCType.booleen));;break;
		default : break;
		}
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			expression = (ObjCExpression) n;
			if(getTypeSpecifier() != null)
				expression.setTypeSpecifier(getTypeSpecifier());
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.print("ExpUnaire : ");
		switch(operation)
		{
		case plus : System.out.println("plus");break;
		case moins : System.out.println("moins");break;
		case multiplier : System.out.println("multiplier");break;
		case diviser : System.out.println("diviser");break;
		case et : System.out.println("et");break;
		case ou : System.out.println("ou");break;
		case non : System.out.println("non");break;
		case different : System.out.println("different");break;
		case superieurouegal : System.out.println("superieurouegal");break;
		case inferieurouegal : System.out.println("inferieurouegal");break;
		case superieur : System.out.println("superieur");break;
		case inferieur : System.out.println("inferieur");break;
		default : System.out.println("egal");break;
		}
		if(expression != null) 
			expression.print(etage + 1);
	}

	public ObjCOperation getOperation() {
		return operation;
	}

	public void setOperation(ObjCOperation operation) {
		this.operation = operation;
	}

	public ObjCExpression getExpression() {
		return expression;
	}

	public void setExpression(ObjCExpression exp) {
		this.expression = exp;
	}
	
	public Object accept(Visitor v) {
		return v.visitExpUnaire(this);
	}
}
