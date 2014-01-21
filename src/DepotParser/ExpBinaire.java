package DepotParser;

import gool.recognizer.objC.Visitor;

public class ExpBinaire extends Expression {
	
	private Operation operation;
	private Expression expGauche;
	private Expression expDroite;
	
	public ExpBinaire(Operation op, Expression expG, Expression expD){
		this.operation=op;
		this.expDroite=expD;
		this.expGauche=expG;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitExpBinaire(this);
		
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Expression getExpGauche() {
		return expGauche;
	}

	public void setExpGauche(Expression expGauche) {
		this.expGauche = expGauche;
	}

	public Expression getExpDroite() {
		return expDroite;
	}

	public void setExpDroite(Expression expDroite) {
		this.expDroite = expDroite;
	}

}
