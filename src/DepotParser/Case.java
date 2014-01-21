package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class Case extends Statement {
	
	private Expression exp;
	private ArrayList <Statement> listestatement;
	
	public Case(Expression exp, ArrayList <Statement> ls){
		this.exp = exp;
		this.listestatement=ls;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitCase(this);
		
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	public ArrayList <Statement> getListestatement() {
		return listestatement;
	}

	public void setListestatement(ArrayList <Statement> listestatement) {
		this.listestatement = listestatement;
	}

}
