package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteChaine extends OBJExpression {
	
	private String constantechaine;
	
	@Override
	public Object accept(Visitor v) {
		return v.visitConstanteChaine(this);
		
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
