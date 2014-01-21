package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteEntier extends OBJExpression{
	
	private int constentier;
	
	@Override
	public Object accept(Visitor v) {
		return v.visitConstanteEntier(this);
		
	}
	
	public OBJConstanteEntier(int e){
		this.constentier=e;
	}

	public int getConstentier() {
		return constentier;
	}

	public void setConstentier(int constentier) {
		this.constentier = constentier;
	}

}
