package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJConstanteReel extends OBJExpression {

	private float constantereel;
	
		
	@Override
	public Object accept(Visitor v) {
		return v.visitConstanteReel(this);
		
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
