package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteCaractere extends OBJExpression {

	private char constantecaractere;
	
	@Override
	public Object accept(Visitor v) {
		return v.visitConstanteCaractere(this);
		
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
