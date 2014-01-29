package gool.parser.objc.core;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCWhile extends ObjCStatement {

	private ObjCExpression condition;
	private ObjCCompoundStatement compoundStatment;
	
	public ObjCWhile(ObjCExpression cond, ObjCCompoundStatement c) {
		condition = cond;
		compoundStatment = c;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			if(condition == null)
				condition = (ObjCExpression) n;
		}
		else if(ObjCCompoundStatement.class.isInstance(n)) {
			compoundStatment = (ObjCCompoundStatement) n;
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("While");
		if(condition != null) 
			condition.print(etage + 1);
		if(compoundStatment != null) 
			compoundStatment.print(etage + 1);
	}
	
	public ObjCExpression getCondition() {
		return condition;
	}
	
	public ObjCCompoundStatement getCompoundStatment() {
		return compoundStatment;
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitWhile(this);
	}
}
