package DepotParser;

import gool.recognizer.objC.Visitor;

public abstract class OBJStatement extends OBJNoeud {
	
	@Override
	public abstract OBJStatement accept(Visitor v) ;
}
