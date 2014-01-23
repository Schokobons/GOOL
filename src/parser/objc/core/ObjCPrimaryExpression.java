package gool.parser.objc.core;

import gool.recognizer.objc.*;




public class ObjCPrimaryExpression extends ObjCExpression {
	
	private ObjCExpression expression;
	
	public ObjCPrimaryExpression(ObjCExpression exp){
		this.expression = exp;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			expression = (ObjCExpression) n;
			if(getType() != null)
				expression.setType(getType());
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.println("PrimaryExpression : ");
		if(expression != null) 
			expression.print(etage + 1);
	}

	public ObjCExpression getExpression() {
		return expression;
	}

	public void setExpression(ObjCExpression exp) {
		this.expression = exp;
	}
	
	public Object accept(Visitor v) {
		return v.visitPrimaryExpression(this);
	}
}
