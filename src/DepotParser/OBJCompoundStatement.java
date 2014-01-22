package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class OBJCompoundStatement extends OBJNoeud{

	private ArrayList <OBJDeclaration> declarationliste;
	private ArrayList <OBJStatement> listestatement;
	
	public OBJCompoundStatement(ArrayList <OBJDeclaration> dl,ArrayList <OBJStatement> ls){
		this.declarationliste=dl;
		this.listestatement=ls;
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visitCompoundStatement(this);
		
	}

	public ArrayList <OBJDeclaration> getDeclarationliste() {
		return declarationliste;
	}

	public void setDeclarationliste(ArrayList <OBJDeclaration> declarationliste) {
		this.declarationliste = declarationliste;
	}

	public ArrayList <OBJStatement> getListestatement() {
		return listestatement;
	}

	public void setListestatement(ArrayList <OBJStatement> listestatement) {
		this.listestatement = listestatement;
	}

}
