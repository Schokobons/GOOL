package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteBool extends OBJExpression {

	private boolean constantebool;
	
	@Override
	public OBJConstanteBool accept(Visitor v) {
		v.visitConstanteBool(this);
		return this;
		
	}
	
	public OBJConstanteBool(boolean b){
		this.constantebool=b;
	}

	public boolean isConstantebool() {
		return constantebool;
	}

	public void setConstantebool(boolean constantebool) {
		this.constantebool = constantebool;
	}

}
