package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteCaractere extends OBJExpression {

	private char constantecaractere;
	
	@Override
	public OBJConstanteCaractere accept(Visitor v) {
		v.visitConstanteCaractere(this);
		return this;
		
	}
	
	public OBJConstanteCaractere(char c){
		this.constantecaractere=c;
	}

	public char getConstantecaractere() {
		return constantecaractere;
	}

	public void setConstantecaractere(char constantecaractere) {
		this.constantecaractere = constantecaractere;
	}

}
