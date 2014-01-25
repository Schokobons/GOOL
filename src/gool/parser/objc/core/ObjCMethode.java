package gool.parser.objc.core;


import java.util.ArrayList;

import gool.parser.objc.jtb.core.CompoundStatement;
import gool.recognizer.objc.Visitor;

public class ObjCMethode extends ObjCNoeud {
	private ObjCModifier modifier;
	private ObjCTypeSpecifier typeRetour;
	private ArrayList <ObjCParameterDeclaration> listeparam;
	private ObjCSelector nom;
	private ObjCCompoundStatement block;
	
	public ObjCMethode(ObjCModifier modifier, ObjCTypeSpecifier typeRetour, ObjCSelector nom, ArrayList <ObjCParameterDeclaration> listeparam, ObjCCompoundStatement block) {
		this.modifier = modifier;
		this.typeRetour = typeRetour;
		this.nom = nom;
		this.listeparam = listeparam;
		this.block = block;
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(typeRetour != null)
			contexte.setTypeRetour(typeRetour);
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++) {
				if(listeparam.get(i).getTypeSpecifier() != null)
					contexte.add(listeparam.get(i).getIdent(), listeparam.get(i).getTypeSpecifier());
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
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++)
			listeparam.get(i).print(etage + 1);
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
	
	public ArrayList<ObjCParameterDeclaration> getListeparam() {
		return listeparam;
	}
	
	public ObjCCompoundStatement getBlock() {
		return block;
	}

	public Object accept(Visitor v) {
		return v.visitMethode(this);
	}
}
