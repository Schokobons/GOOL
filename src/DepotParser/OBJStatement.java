package DepotParser;

import gool.recognizer.objC.Visitor;

public abstract class OBJStatement extends OBJNoeud {
	
	@Override
	public abstract Object accept(Visitor v) ;
}
