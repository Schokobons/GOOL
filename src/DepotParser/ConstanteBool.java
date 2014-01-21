package DepotParser;

import gool.recognizer.objC.Visitor;

public class ConstanteBool extends Expression {

	private boolean constantebool;
	
	@Override
	public void accept(Visitor v) {
		v.visitConstanteBool(this);
		
	}
	
	public ConstanteBool(boolean b){
		this.constantebool=b;
	}

	public boolean isConstantebool() {
		return constantebool;
	}

	public void setConstantebool(boolean constantebool) {
		this.constantebool = constantebool;
	}

}
