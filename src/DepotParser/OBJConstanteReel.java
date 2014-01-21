package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteReel extends OBJExpression {

	private float constantereel;
	
		
	@Override
	public OBJConstanteReel accept(Visitor v) {
		v.visitConstanteReel(this);
		return this;
		
	}

	public OBJConstanteReel(float f){
		this.constantereel=f;
	}
	
	public float getConstantereel() {
		return constantereel;
	}


	public void setConstantereel(float constantereel) {
		this.constantereel = constantereel;
	}

}
