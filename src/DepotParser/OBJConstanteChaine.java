package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteChaine extends OBJExpression {
	
	private String constantechaine;
	
	@Override
	public OBJConstanteChaine accept(Visitor v) {
		v.visitConstanteChaine(this);
		return this;
		
	}
	
	public OBJConstanteChaine(String c){
		this.constantechaine=c;
	}
	
	public String getConstantechaine() {
		return constantechaine;
	}

	public void setConstantechaine(String constantechaine) {
		this.constantechaine = constantechaine;
	}

}
