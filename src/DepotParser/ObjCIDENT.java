package DepotParser;

import gool.recognizer.objC.Visitor;

public class ObjCIDENT extends Expression{

	private String nom;
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub	
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

}
