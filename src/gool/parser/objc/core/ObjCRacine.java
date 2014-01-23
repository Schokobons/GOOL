package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;


public class ObjCRacine extends ObjCNoeud{

	public ObjCRacine() {
		contexte = new ObjCContexte();
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("racine");
		afficherFils(etage + 1);
	}
	
	public ArrayList<ObjCNoeud> getFils() {
		return fils;
	}
	
	public Object accept(Visitor v) {
		return v.visitRacine(this);
	}
}
