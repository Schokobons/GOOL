package gool.parser.objc.core;

import java.util.ArrayList;

public class ObjCContexte {
	private ArrayList<String> identifiants;
	private ArrayList<ObjCTypeSpecifier> types;
	
	public ObjCContexte() {
		identifiants = new ArrayList<String>();
		types = new ArrayList<ObjCTypeSpecifier>();
		identifiants.add("true");
		identifiants.add("TRUE");
		identifiants.add("YES");
		identifiants.add("false");
		identifiants.add("FALSE");
		identifiants.add("NO");
		for(int i = 0; i < 6; i++)
			types.add(ObjCTypeSpecifier.INSTANCEbooleen);
	}
	
	public boolean add(ObjCIDENT objc, ObjCTypeSpecifier t) {
		boolean trouve = false;
		for(int i = 0; i < identifiants.size(); i++) {
			if(identifiants.get(i).equals(objc.getNom()))
				trouve = true;
		}
		if(!trouve) {
			identifiants.add(objc.getNom());
			types.add(t);
		}
		return !trouve;
	}
	
	public ObjCTypeSpecifier getType(ObjCIDENT objc) {
		ObjCTypeSpecifier retour = null;
		for(int i = 0; i < types.size(); i++)
			if(identifiants.get(i).equals(objc.getNom()))
				retour = types.get(i);
		return retour;
	}
	
	public ObjCContexte clone() {
		ObjCContexte nouveau = new ObjCContexte();
		for(int i = 0; i < identifiants.size(); i++) {
			nouveau.identifiants.add(identifiants.get(i));
			nouveau.types.add(types.get(i));
		}
		return nouveau;
	}
	
	public void setTypeRetour(ObjCTypeSpecifier t) {
		int position = identifiants.size();
		for(int i = 0; i < identifiants.size(); i++) {
			if(identifiants.get(i).equals("return"))
				position = i;
		}
		if(position < identifiants.size())
			types.set(position, t);
		else {
			identifiants.add("return");
			types.add(t);
		}
	}
	
	public ObjCTypeSpecifier getTypeRetour() {
		ObjCTypeSpecifier retour = null;
		for(int i = 0; i < types.size(); i++)
			if(identifiants.get(i).equals("return"))
				retour = types.get(i);
		return retour;
	}
	
	public void print() {
		System.out.println("     -----Contexte-----     ");
		for(int i = 0; i < identifiants.size(); i++) {
			System.out.print(identifiants.get(i));
			switch(types.get(i).getType())
			{
			case entier : System.out.print("entier)");break;
			case reel : System.out.print("reel)");break;
			case caractere : System.out.print("caractere)");break;
			case chaine : System.out.print("chaine)");break;
			case booleen : System.out.print("booleen)");break;
			case inconnu : System.out.print("inconnu : " + types.get(i).getName() + ")");break;
			case objet : System.out.print("objet)");break;
			default : System.out.print("vide)");break;
			}
		}
		System.out.println();
	}
}
