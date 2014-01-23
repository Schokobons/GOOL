package gool.parser.objc.core;

import gool.recognizer.objc.*;




public class ObjCConstante extends ObjCExpression{
	
	private String valeur;
	
	public void setType(ObjCType t) {
		type = t;
		if(valeur != null && t == ObjCType.reel && !valeur.contains(".")) {
			valeur = valeur + ".0";
		}
	}
		
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.println("Constante : " + valeur);
	}
	
	public ObjCConstante(String valeur){
		this.valeur=valeur;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public Object accept(Visitor v) {
		return v.visitConstante(this);
	}
}
