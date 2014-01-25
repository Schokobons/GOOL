package gool.parser.objc.core;

import gool.recognizer.objc.*;

public class ObjCAssignement extends ObjCStatement {
	
	private ObjCIDENT ident;
	private ObjCExpression exp;
	
	public ObjCAssignement(ObjCIDENT id, ObjCExpression e){
		this.ident=id;
		this.exp=e;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCIDENT.class.isInstance(n) && ident == null) {
			ident = (ObjCIDENT) n;
			if(contexte != null)
				((ObjCIDENT)n).setTypeSpecifier(contexte.getType((ObjCIDENT) n));
		}
		else if(ObjCExpression.class.isInstance(n)) {
			exp = (ObjCExpression) n;
			if(ident != null && contexte != null && exp.getTypeSpecifier() == null)
				exp.setTypeSpecifier(contexte.getType(ident));
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("Assignement");
		if(ident != null)
			ident.print(etage + 1);
		if(exp != null) 
			exp.print(etage + 1);
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
		return v.visitAssignement(this);
	}
}
