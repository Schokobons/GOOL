package DepotParser;

import gool.recognizer.objC.Visitor;

public class ConstanteEntier extends Expression{
	
	private int constentier;
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
	public ConstanteEntier(int e){
		this.constentier=e;
	}

	public int getConstentier() {
		return constentier;
	}

	public void setConstentier(int constentier) {
		this.constentier = constentier;
	}

}
