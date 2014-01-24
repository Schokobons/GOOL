package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;



public class ObjCCompoundStatement extends ObjCNoeud{

	private ArrayList <ObjCDeclaration> declarationliste;
	private ArrayList <ObjCStatement> listestatement;
	
	public ObjCCompoundStatement(ArrayList <ObjCDeclaration> dl,ArrayList <ObjCStatement> ls){
		this.declarationliste=dl;
		this.listestatement=ls;
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(declarationliste != null)
			for(int i = 0; i < declarationliste.size(); i++) {
				contexte.add(declarationliste.get(i).getIdent(), declarationliste.get(i).getTypeSpecifier().getType());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCDeclaration.class.isInstance(n)) {
			if(declarationliste == null)
				declarationliste = new ArrayList<ObjCDeclaration>();
			declarationliste.add((ObjCDeclaration) n);
		}
		else if(ObjCStatement.class.isInstance(n)) {
			if(listestatement == null)
				listestatement = new ArrayList<ObjCStatement>();
			listestatement.add((ObjCStatement) n);
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("CompoundStatement");
		if(declarationliste != null)
			for(int i = 0; i < declarationliste.size(); i++)
				declarationliste.get(i).print(etage + 1);
		if(listestatement != null)
			for(int i = 0; i < listestatement.size(); i++)
				listestatement.get(i).print(etage + 1);
	}

	public ArrayList <ObjCDeclaration> getDeclarationliste() {
		return declarationliste;
	}

	public void setDeclarationliste(ArrayList <ObjCDeclaration> declarationliste) {
		this.declarationliste = declarationliste;
	}

	public ArrayList <ObjCStatement> getListestatement() {
		return listestatement;
	}

	public void setListestatement(ArrayList <ObjCStatement> listestatement) {
		this.listestatement = listestatement;
	}
	
	public Object accept(Visitor v) {
		return v.visitCompoundStatement(this);
	}
}
