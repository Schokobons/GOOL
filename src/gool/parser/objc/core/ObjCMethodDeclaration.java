package gool.parser.objc.core;

import gool.recognizer.objc.Visitor;

import java.util.ArrayList;

public class ObjCMethodDeclaration extends ObjCNoeud {
	private ObjCModifier modifier;
	private ObjCTypeSpecifier typeRetour;
	private ArrayList <ObjCParameterDeclaration> listeparam;
	private ObjCSelector nom;
	
	public ObjCMethodDeclaration(ObjCModifier modifier, ObjCTypeSpecifier typeRetour, ObjCSelector nom, ArrayList <ObjCParameterDeclaration> listeparam) {
		this.modifier = modifier;
		this.typeRetour = typeRetour;
		this.nom = nom;
		this.listeparam = listeparam;
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(typeRetour != null)
			contexte.setTypeRetour(typeRetour.getType());
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++) {
				if(listeparam.get(i).getTypeSpecifier() != null)
					contexte.add(listeparam.get(i).getIdent(), listeparam.get(i).getTypeSpecifier().getType());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCTypeSpecifier.class.isInstance(n)) {
			typeRetour = (ObjCTypeSpecifier) n;
		}
		else if(ObjCSelector.class.isInstance(n)) {
			nom = (ObjCSelector) n;
		}
		else if(ObjCParameterDeclaration.class.isInstance(n)) {
			if(listeparam == null)
				listeparam = new ArrayList<ObjCParameterDeclaration>();
			listeparam.add((ObjCParameterDeclaration) n);
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.print("Methode");
		if(modifier.equals(ObjCModifier.PUBLIC))
			System.out.println(" Publique");
		else
			System.out.println(" Privee");
		if(typeRetour != null)
			typeRetour.print(etage + 1);
		if(nom != null)
			nom.print(etage + 1);
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++)
			listeparam.get(i).print(etage + 1);
	}
	
	public ObjCModifier getModifier() {
		return modifier;
	}

	public void setModifier(ObjCModifier modifier) {
		this.modifier = modifier;
	}

	public ObjCTypeSpecifier getTypeRetour() {
		return typeRetour;
	}

	public void setTypeRetour(ObjCTypeSpecifier typeRetour) {
		this.typeRetour = typeRetour;
	}

	public ArrayList<ObjCParameterDeclaration> getListeparam() {
		return listeparam;
	}

	public void setListeparam(ArrayList<ObjCParameterDeclaration> listeparam) {
		this.listeparam = listeparam;
	}

	public ObjCSelector getNom() {
		return nom;
	}
	
	public String getName() {
		if(nom == null)
			return null;
		return nom.getNom();
	}

	public void setNom(ObjCSelector nom) {
		this.nom = nom;
	}

	public Object accept(Visitor v) {
		return v.visitMethodeDeclaration(this);
	}

}
