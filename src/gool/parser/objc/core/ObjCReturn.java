package gool.parser.objc.core;

import gool.recognizer.objc.*;




public class ObjCReturn extends ObjCStatement{
	
	private ObjCExpression exp;
	
	public ObjCReturn (ObjCExpression e){
		this.exp=e;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			exp = (ObjCExpression) n;
			if(contexte != null)
				exp.setTypeSpecifier(contexte.getTypeRetour());
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("Return");
		if(exp != null) 
			exp.print(etage + 1);
	}

	public ObjCExpression getExp() {
		return exp;
	}

	public void setExp(ObjCExpression exp) {
		this.exp = exp;
	}
	
	public Object accept(Visitor v) {
		return v.visitReturn(this);
	}
}
