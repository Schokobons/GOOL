package gool.parser.objc.core;


import gool.recognizer.objc.*;

public class ObjCSelector extends ObjCNoeud{

	private String nom;
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("ObjCIDENT : " + nom);
	}
	
	public ObjCSelector(String n){
		this.nom=n;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void growSelector(ObjCSelector selector) {
		nom = nom + selector.nom;
	}

	public Object accept(ObjCRecognizer v) {
		return null;
	}
}
