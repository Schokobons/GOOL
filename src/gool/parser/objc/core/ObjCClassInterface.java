package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;

public class ObjCClassInterface extends ObjCNoeud {

	private ObjCIDENT nom;
	private ObjCSuperClassName superClass;
	private ArrayList <ObjCDeclaration> listedeclarations;
	private ArrayList <ObjCMethodDeclaration> listemethodes;
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(listedeclarations != null)
			for(int i = 0; i < listedeclarations.size(); i++) {
				if(!ContexteModifie) {
					ContexteModifie = true;
					contexte = contexte.clone();
				}
				contexte.add(listedeclarations.get(i).getIdent(), listedeclarations.get(i).getTypeSpecifier());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCIDENT.class.isInstance(n)) {
			nom = (ObjCIDENT) n;
		}
		else if(ObjCSuperClassName.class.isInstance(n))
			superClass = (ObjCSuperClassName) n;
		else if(ObjCDeclaration.class.isInstance(n)) {
			if(listedeclarations == null)
				listedeclarations = new ArrayList<ObjCDeclaration>();
			listedeclarations.add((ObjCDeclaration) n);
		}
		else if(ObjCMethodDeclaration.class.isInstance(n)) {
			if(listemethodes == null)
				listemethodes = new ArrayList<ObjCMethodDeclaration>();
			listemethodes.add((ObjCMethodDeclaration) n);
		}
	}
	
	public ObjCClassInterface(ObjCIDENT nom, ObjCSuperClassName superClass, ArrayList<ObjCDeclaration> listedeclarations, ArrayList<ObjCMethodDeclaration> listemethodes) {
		this.nom = nom;
		this.superClass = superClass;
		this.listedeclarations = listedeclarations;
		this.listemethodes = listemethodes;
	}

	public ObjCIDENT getNom() {
		return nom;
	}

	public void setNom(ObjCIDENT nom) {
		this.nom = nom;
	}

	public ObjCSuperClassName getSuperClass() {
		return superClass;
	}

	public void setSuperClass(ObjCSuperClassName superClass) {
		this.superClass = superClass;
	}

	public ArrayList<ObjCDeclaration> getListedeclaration() {
		return listedeclarations;
	}

	public void setListedeclaration(ArrayList<ObjCDeclaration> listedeclarations) {
		this.listedeclarations = listedeclarations;
	}

	public ArrayList<ObjCMethodDeclaration> getListemethodes() {
		return listemethodes;
	}

	public void setListemethodes(ArrayList<ObjCMethodDeclaration> listemethodes) {
		this.listemethodes = listemethodes;
	}

	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.print("Interface ");
		System.out.println(nom.getNom());
		if(superClass != null)
			superClass.print(etage + 1);
		if(listedeclarations != null)
			for(int i = 0; i < listedeclarations.size(); i++)
				listedeclarations.get(i).print(etage + 1);
		if(listemethodes != null)
			for(int i = 0; i < listemethodes.size(); i++)
				listemethodes.get(i).print(etage + 1);
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitClassInterface(this);
	}

}
