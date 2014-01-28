package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCMethode extends ObjCNoeud {
	private ObjCModifier modifier;
	private ObjCTypeSpecifier typeRetour;
	private ArrayList <ObjCParameterDeclaration> listeParam;
	private ObjCSelector nom;
	private ObjCCompoundStatement block;
	
	public ObjCMethode(ObjCModifier modifier, ObjCTypeSpecifier typeRetour, ObjCSelector nom, ArrayList <ObjCParameterDeclaration> listeparam, ObjCCompoundStatement block) {
		this.modifier = modifier;
		this.typeRetour = typeRetour;
		this.nom = nom;
		this.listeParam = listeparam;
		this.block = block;
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(typeRetour != null)
			contexte.setTypeRetour(typeRetour);
		if(listeParam != null)
			for(int i = 0; i < listeParam.size(); i++) {
				if(listeParam.get(i).getTypeSpecifier() != null) {
					if(!ContexteModifie) {
						ContexteModifie = true;
						contexte = contexte.clone();
					}
					contexte.add(listeParam.get(i).getIdent(), listeParam.get(i).getTypeSpecifier());
				}
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCTypeSpecifier.class.isInstance(n)) {
			typeRetour = (ObjCTypeSpecifier) n;
		}
		else if(ObjCSelector.class.isInstance(n)) {
			if(nom == null)
				nom = new ObjCSelector("");
			nom.growSelector((ObjCSelector) n);
		}
		else if(ObjCParameterDeclaration.class.isInstance(n)) {
			if(listeParam == null)
				listeParam = new ArrayList<ObjCParameterDeclaration>();
			listeParam.add((ObjCParameterDeclaration) n);
		}
		else if(ObjCCompoundStatement.class.isInstance(n)) {
			block = (ObjCCompoundStatement) n;
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
		if(listeParam != null)
			for(int i = 0; i < listeParam.size(); i++)
			listeParam.get(i).print(etage + 1);
		if(block != null)
			block.print(etage + 1);
	}
	
	public ObjCTypeSpecifier getTypeRetour() {
		return typeRetour;
	}
	
	public ObjCModifier getModifier() {
		return modifier;
	}
	
	public String getNom() {
		return nom.getNom();
	}
	
	public ArrayList<ObjCParameterDeclaration> getListeParam() {
		return listeParam;
	}
	
	public ObjCCompoundStatement getBlock() {
		return block;
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitMethode(this);
	}
}
