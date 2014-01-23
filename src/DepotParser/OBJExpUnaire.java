package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJExpUnaire extends OBJExpression {
	
	private Operation operation;
	private OBJExpression exp;
	
	public OBJExpUnaire(Operation op, OBJExpression exp){
		this.operation=op;
		this.exp=exp;
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visitExpUnaire(this);
		
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public OBJExpression getExp() {
		return exp;
	}

	public void setExpGauche(OBJExpression exp) {
		this.exp = exp;
	}

}
