package DepotParser;

import gool.recognizer.objC.Visitor;

public abstract class OBJNoeud {

	public abstract OBJNoeud accept(Visitor v);
}
