package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class CompoundStatement extends Noeud{

	private ArrayList <Declaration> declarationliste;
	private ArrayList <Statement> listestatement;
	
	public CompoundStatement(ArrayList <Declaration> dl,ArrayList <Statement> ls){
		this.declarationliste=dl;
		this.listestatement=ls;
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList <Declaration> getDeclarationliste() {
		return declarationliste;
	}

	public void setDeclarationliste(ArrayList <Declaration> declarationliste) {
		this.declarationliste = declarationliste;
	}

	public ArrayList <Statement> getListestatement() {
		return listestatement;
	}

	public void setListestatement(ArrayList <Statement> listestatement) {
		this.listestatement = listestatement;
	}

}
