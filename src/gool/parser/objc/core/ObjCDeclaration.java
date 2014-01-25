package gool.parser.objc.core;

import gool.recognizer.objc.*;


public class ObjCDeclaration extends ObjCNoeud{
	
	private ObjCTypeSpecifier typeSpecifier;
	private ObjCIDENT ident;
	private ObjCExpression exp;
	
	public ObjCDeclaration (ObjCTypeSpecifier t, ObjCIDENT id, ObjCExpression e){
		this.exp=e;
		this.ident=id;
		this.typeSpecifier=t;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCTypeSpecifier.class.isInstance(n)) {
			typeSpecifier = (ObjCTypeSpecifier) n;
		}
		else if(ObjCIDENT.class.isInstance(n)) {
			ident = (ObjCIDENT) n;
			if(typeSpecifier != null)
				ident.setTypeSpecifier(typeSpecifier);
		}
		else if(ObjCExpression.class.isInstance(n)) {
			exp = (ObjCExpression) n;
			if(typeSpecifier != null)
				exp.setTypeSpecifier(typeSpecifier);
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("Declaration");
		if(typeSpecifier != null)
			typeSpecifier.print(etage + 1);
		if(ident != null)
			ident.print(etage + 1);
		if(exp != null)
			exp.print(etage + 1);
	}

	public ObjCTypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}


	public void setTypeSpecifier(ObjCTypeSpecifier typeSpecifier) {
		this.typeSpecifier = typeSpecifier;
	}


	public ObjCIDENT getIdent() {
		return ident;
	}


	public void setIdent(ObjCIDENT ident) {
		this.ident = ident;
	}


	public ObjCExpression getExp() {
		return exp;
	}


	public void setExp(ObjCExpression exp) {
		this.exp = exp;
	}
	
	public Object accept(Visitor v) {
		return v.visitDeclaration(this);
	}
}
