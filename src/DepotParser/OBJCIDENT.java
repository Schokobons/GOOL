package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJCIDENT extends OBJExpression{

	private String nom;
	@Override
	public OBJCIDENT accept(Visitor v) {
		v.visitObjCIDENT(this);
		return this;
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
