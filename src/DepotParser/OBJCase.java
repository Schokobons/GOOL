package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class OBJCase extends OBJStatement {
	
	private OBJExpression exp;
	private ArrayList <OBJStatement> listestatement;
	
	public OBJCase(OBJExpression exp, ArrayList <OBJStatement> ls){
		this.exp = exp;
		this.listestatement=ls;
	}
	
	@Override
	public OBJCase accept(Visitor v) {
		v.visitCase(this);
		return this;
		
	}

	public OBJExpression getExp() {
		return exp;
	}

	public void setExp(OBJExpression exp) {
		this.exp = exp;
	}

	public ArrayList <OBJStatement> getListestatement() {
		return listestatement;
	}

	public void setListestatement(ArrayList <OBJStatement> listestatement) {
		this.listestatement = listestatement;
	}

}
