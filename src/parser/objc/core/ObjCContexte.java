package gool.parser.objc.core;

import java.util.ArrayList;

public class ObjCContexte {
	private ArrayList<String> identifiants;
	private ArrayList<ObjCType> types;
	
	public ObjCContexte() {
		identifiants = new ArrayList<String>();
		types = new ArrayList<ObjCType>();
		identifiants.add("true");
		identifiants.add("TRUE");
		identifiants.add("YES");
		identifiants.add("false");
		identifiants.add("FALSE");
		identifiants.add("NO");
		for(int i = 0; i < 6; i++)
			types.add(ObjCType.booleen);
	}
	
	public boolean add(ObjCIDENT objc, ObjCType t) {
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
	
	public ObjCType getType(ObjCIDENT objc) {
		ObjCType retour = null;
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
	
	public void setTypeRetour(ObjCType t) {
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
	
	public ObjCType getTypeRetour() {
		ObjCType retour = null;
		for(int i = 0; i < types.size(); i++)
			if(identifiants.get(i).equals("return"))
				retour = types.get(i);
		return retour;
	}
	
	public void print() {
		System.out.println("     -----Contexte-----     ");
		for(int i = 0; i < identifiants.size(); i++) {
			System.out.print(identifiants.get(i));
			switch(types.get(i))
			{
			case entier : System.out.println(" : entier");break;
			case reel : System.out.println(" : reel");break;
			case caractere : System.out.println(" : caractere");break;
			case chaine : System.out.println(" : chaine");break;
			case booleen : System.out.println(" : booleen");break;
			case vide : System.out.println(" : vide");break;
			default : System.out.println(" : ?");break;
			}
		}
		System.out.println();
	}
}
