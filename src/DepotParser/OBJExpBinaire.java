package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJExpBinaire extends OBJExpression {
	
	private Operation operation;
	private OBJExpression expGauche;
	private OBJExpression expDroite;
	
	public OBJExpBinaire(Operation op, OBJExpression expG, OBJExpression expD){
		this.operation=op;
		this.expDroite=expD;
		this.expGauche=expG;
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visitExpBinaire(this);
		
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public OBJExpression getExpGauche() {
		return expGauche;
	}

	public void setExpGauche(OBJExpression expGauche) {
		this.expGauche = expGauche;
	}

	public OBJExpression getExpDroite() {
		return expDroite;
	}

	public void setExpDroite(OBJExpression expDroite) {
		this.expDroite = expDroite;
	}

}
