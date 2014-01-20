package DepotParser;

import gool.recognizer.objC.Visitor;

public abstract class Statement extends Noeud {
	
	@Override
	public abstract void accept(Visitor v) ;
}
