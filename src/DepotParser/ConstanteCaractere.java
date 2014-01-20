package DepotParser;

import gool.recognizer.objC.Visitor;

public class ConstanteCaractere extends Noeud {

	private char constantecaractere;
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
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
