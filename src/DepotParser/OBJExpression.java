package DepotParser;

import gool.recognizer.objC.Visitor;

public abstract class OBJExpression extends OBJNoeud{

	
	
	@Override
	public abstract OBJExpression accept(Visitor v); 

}
