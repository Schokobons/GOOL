package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;


public class ObjCCase extends ObjCStatement {
	
	private ObjCExpression exp;
	private ArrayList <ObjCStatement> listestatement;
	
	public Object accept(ObjCRecognizer v) {
		return v.visitCase(this);
	}
	
	public ObjCCase(ObjCExpression exp, ArrayList <ObjCStatement> ls){
		this.exp = exp;
		this.listestatement=ls;
	}

	public ObjCExpression getExp() {
		return exp;
	}

	public void setExp(ObjCExpression exp) {
		this.exp = exp;
	}

	public ArrayList <ObjCStatement> getListestatement() {
		return listestatement;
	}

	public void setListestatement(ArrayList <ObjCStatement> listestatement) {
		this.listestatement = listestatement;
	}
}
