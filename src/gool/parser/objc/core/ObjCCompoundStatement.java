package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;



public class ObjCCompoundStatement extends ObjCNoeud{

	private ArrayList <ObjCDeclaration> declarationliste;
	private ArrayList <ObjCNoeud> listeStatementExpression;
	
	public ObjCCompoundStatement(ArrayList <ObjCDeclaration> dl,ArrayList <ObjCNoeud> ls){
		this.declarationliste=dl;
		this.listeStatementExpression=ls;
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(declarationliste != null)
			for(int i = 0; i < declarationliste.size(); i++) {
				if(!ContexteModifie) {
					ContexteModifie = true;
					contexte = contexte.clone();
				}
				contexte.add(declarationliste.get(i).getIdent(), declarationliste.get(i).getTypeSpecifier());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCDeclaration.class.isInstance(n)) {
			if(declarationliste == null)
				declarationliste = new ArrayList<ObjCDeclaration>();
			declarationliste.add((ObjCDeclaration) n);
		}
		else if(ObjCStatement.class.isInstance(n)) {
			if(listeStatementExpression == null)
				listeStatementExpression = new ArrayList<ObjCNoeud>();
			listeStatementExpression.add((ObjCStatement) n);
		}
		else if(ObjCExpression.class.isInstance(n)) {
			if(listeStatementExpression == null)
				listeStatementExpression = new ArrayList<ObjCNoeud>();
			listeStatementExpression.add((ObjCExpression) n);
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("CompoundStatement");
		if(declarationliste != null)
			for(int i = 0; i < declarationliste.size(); i++)
				declarationliste.get(i).print(etage + 1);
		if(listeStatementExpression != null)
			for(int i = 0; i < listeStatementExpression.size(); i++)
				listeStatementExpression.get(i).print(etage + 1);
	}

	public ArrayList <ObjCDeclaration> getDeclarationliste() {
		return declarationliste;
	}

	public void setDeclarationliste(ArrayList <ObjCDeclaration> declarationliste) {
		this.declarationliste = declarationliste;
	}

	public ArrayList <ObjCNoeud> getListestatement() {
		return listeStatementExpression;
	}

	public void setListestatement(ArrayList <ObjCNoeud> listestatement) {
		this.listeStatementExpression = listestatement;
	}
	
	public Object accept(ObjCRecognizer v) {
		return v.visitCompoundStatement(this);
	}
}
