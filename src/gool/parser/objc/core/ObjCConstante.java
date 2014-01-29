package gool.parser.objc.core;

import gool.recognizer.objc.*;

public class ObjCConstante extends ObjCExpression{
	
	private String valeur;
	
	public void setTypeSpecifier(ObjCTypeSpecifier t) {
		type = t;
		if(valeur != null && t != null && t.getType() != null && t.getType().equals(ObjCType.reel) && !valeur.contains(".")) {
			valeur = valeur + ".0";
		}
		if(valeur != null && t != null && t.getType() != null && t.getType().equals(ObjCType.chaine) && valeur.length() > 2) {
			if(valeur.charAt(0) == '@' && valeur.charAt(1) == '\"' && valeur.charAt(valeur.length() - 1) == '\"') {
				valeur = valeur.substring(2, valeur.length() - 1);
			}
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
	
	public Object accept(ObjCRecognizer v) {
		return v.visitConstante(this);
	}
}
