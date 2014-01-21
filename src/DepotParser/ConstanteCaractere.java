package DepotParser;

import gool.recognizer.objC.Visitor;

public class ConstanteCaractere extends Expression {

	private char constantecaractere;
	
	@Override
	public void accept(Visitor v) {
		v.visitConstanteCaractere(this);
		
	}
	
	public ConstanteCaractere(char c){
		this.constantecaractere=c;
	}

	public char getConstantecaractere() {
		return constantecaractere;
	}

	public void setConstantecaractere(char constantecaractere) {
		this.constantecaractere = constantecaractere;
	}

}
