package DepotParser;

import gool.recognizer.objC.Visitor;

public class ConstanteChaine extends Expression {
	
	private String constantechaine;
	
	@Override
	public void accept(Visitor v) {
		v.visitConstanteChaine(this);
		
	}
	
	public ConstanteChaine(String c){
		this.constantechaine=c;
	}
	
	public String getConstantechaine() {
		return constantechaine;
	}

	public void setConstantechaine(String constantechaine) {
		this.constantechaine = constantechaine;
	}

}
