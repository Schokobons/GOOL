package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteBool extends OBJExpression {

	private boolean constantebool;
	
	@Override
	public Object accept(Visitor v) {
		return v.visitConstanteBool(this);
		
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
