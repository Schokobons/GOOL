package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;


public class ObjCRacine extends ObjCNoeud{
	
	private ObjCClassImplementation classImplementation;
	private ObjCClassInterface classInterface;

	public ObjCRacine() {
		contexte = new ObjCContexte();
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte;
		fils.add(n);
		if(ObjCClassImplementation.class.isInstance(n))
			classImplementation = (ObjCClassImplementation) n;
		if(ObjCClassInterface.class.isInstance(n))
			classInterface = (ObjCClassInterface) n;
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("racine");
		afficherFils(etage + 1);
	}
	
	public ObjCClassImplementation getClassImplementation() {
		return classImplementation;
	}
	
	public ObjCClassInterface getClassInterface() {
		return classInterface;
	}
	
	public ArrayList<ObjCNoeud> getFils() {
		return fils;
	}
	
	public Object accept(ObjCRecognizer v) {
		return v.visitRacine(this);
	}
}
