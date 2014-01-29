package gool.parser.objc.core;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCFor  extends ObjCStatement {
	
	private ObjCAssignement assignement;
	private ObjCExpression condition;
	private ObjCExpression modification;
	private ObjCCompoundStatement compoundStatment;
	
	public ObjCFor(ObjCAssignement assign, ObjCExpression cond, ObjCExpression mod, ObjCCompoundStatement c){
		assignement = assign;
		condition = cond;
		modification = mod;
		compoundStatment = c;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCAssignement.class.isInstance(n))
			assignement = (ObjCAssignement) n;
		if(ObjCExpression.class.isInstance(n)) {
			if(condition == null)
				condition = (ObjCExpression) n;
			else
				modification = (ObjCExpression) n;
		}
		else if(ObjCCompoundStatement.class.isInstance(n)) {
			compoundStatment = (ObjCCompoundStatement) n;
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("For");
		if(assignement != null) 
			assignement.print(etage + 1);
		if(condition != null) 
			condition.print(etage + 1);
		if(modification != null) 
			modification.print(etage + 1);
		if(compoundStatment != null) 
			compoundStatment.print(etage + 1);
	}
	
	public ObjCAssignement getAssignement() {
		return assignement;
	}
	
	public ObjCExpression getCondition() {
		return condition;
	}
	
	public ObjCExpression getModification() {
		return modification;
	}
	
	public ObjCCompoundStatement getCompoundStatment() {
		return compoundStatment;
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitFor(this);
	}

}
