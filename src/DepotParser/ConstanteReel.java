package DepotParser;

import gool.recognizer.objC.Visitor;

public class ConstanteReel extends Expression {

	private float constantereel;
	
		
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public ConstanteReel(float f){
		this.constantereel=f;
	}
	
	public float getConstantereel() {
		return constantereel;
	}


	public void setConstantereel(float constantereel) {
		this.constantereel = constantereel;
	}

}
