package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class OBJSwitch extends OBJStatement {
	
	private OBJExpression exp;
	private ArrayList <OBJCase> listecase;
	
	public OBJSwitch (OBJExpression e, ArrayList <OBJCase> lc){
		this.exp=e;
		this.listecase=lc;
	}
	
	@Override
	public OBJSwitch accept(Visitor v) {
		v.visitSwitch(this);
		return this;		
	}


	public OBJExpression getExp() {
		return exp;
	}


	public void setExp(OBJExpression exp) {
		this.exp = exp;
	}


	public ArrayList <OBJCase> getListecase() {
		return listecase;
	}


	public void setListecase(ArrayList <OBJCase> listecase) {
		this.listecase = listecase;
	}

}
