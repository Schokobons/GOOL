package gool.parser.objc.core;

import gool.recognizer.objc.*;

public class ObjCIDENT extends ObjCExpression{

	private String nom;
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.println("ObjCIDENT : " + nom);
	}
	
	public ObjCIDENT(String n){
		this.nom=n;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Object accept(ObjCRecognizer v) {
		return v.visitObjCIDENT(this);
	}
}
