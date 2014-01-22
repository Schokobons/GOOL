package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJCIDENT extends OBJExpression{

	private String nom;
	@Override
	public Object accept(Visitor v) {
		return v.visitObjCIDENT(this);
	}
	
	public OBJCIDENT(String n){
		this.nom=n;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
