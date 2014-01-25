package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;



public class ObjCClassImplementation extends ObjCNoeud{

	private ObjCIDENT nom;
	private ArrayList <ObjCDeclaration> listedeclarations;
	private ArrayList <ObjCMethode> listemethodes;
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(listedeclarations != null)
			for(int i = 0; i < listedeclarations.size(); i++) {
				contexte.add(listedeclarations.get(i).getIdent(), listedeclarations.get(i).getTypeSpecifier());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCIDENT.class.isInstance(n)) {
			nom = (ObjCIDENT) n;
		}
		else if(ObjCDeclaration.class.isInstance(n)) {
			if(listedeclarations == null)
				listedeclarations = new ArrayList<ObjCDeclaration>();
			listedeclarations.add((ObjCDeclaration) n);
		}
		else if(ObjCMethode.class.isInstance(n)) {
			if(listemethodes == null)
				listemethodes = new ArrayList<ObjCMethode>();
			listemethodes.add((ObjCMethode) n);
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.print("Classe ");
		System.out.println(nom.getNom());
		if(listedeclarations != null)
			for(int i = 0; i < listedeclarations.size(); i++)
				listedeclarations.get(i).print(etage + 1);
		if(listemethodes != null)
			for(int i = 0; i < listemethodes.size(); i++)
				listemethodes.get(i).print(etage + 1);
	}
	
	public ObjCClassImplementation(ObjCIDENT nom, ArrayList<ObjCDeclaration> listedeclarations, ArrayList <ObjCMethode> listemethodes){
		this.nom = nom;
		this.listedeclarations = listedeclarations;
		this.listemethodes = listemethodes;
	}

	public ObjCIDENT getNom() {
		return nom;
	}

	public void setNom(ObjCIDENT nom) {
		this.nom = nom;
	}

	public ArrayList <ObjCDeclaration> getListedeclaration() {
		return listedeclarations;
	}

	public void setListedeclaration(ArrayList <ObjCDeclaration> listedeclarations) {
		this.listedeclarations = listedeclarations;
	}

	public ArrayList <ObjCMethode> getListemethode() {
		return listemethodes;
	}

	public void setListeparam(ArrayList <ObjCMethode> listemethodes) {
		this.listemethodes = listemethodes;
	}
	
	public Object accept(Visitor v) {
		return v.visitClassImplementation(this);
	}
}
