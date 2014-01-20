package DepotParser;

import gool.recognizer.objC.Visitor;

public abstract class Expression extends Noeud{

	@Override
	public abstract void accept(Visitor v); 

}
