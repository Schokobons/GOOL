package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJReturn extends OBJStatement{
	
	private OBJExpression exp;
	
	public OBJReturn (OBJExpression e){
		this.exp=e;
	}
	
	@Override
	public OBJReturn accept(Visitor v) {
		v.visitReturn(this);
		return this;
		
	}

	public OBJExpression getExp() {
		return exp;
	}

	public void setExp(OBJExpression exp) {
		this.exp = exp;
	}

}
