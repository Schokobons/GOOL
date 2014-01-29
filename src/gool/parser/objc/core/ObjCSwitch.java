package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;



public class ObjCSwitch extends ObjCStatement {
	
	private ObjCExpression exp;
	private ArrayList <ObjCCase> listeCase;
	
	public ObjCSwitch (ObjCExpression e, ArrayList <ObjCCase> lc){
		this.exp=e;
		this.listeCase=lc;
	}

	public ObjCExpression getExp() {
		return exp;
	}


	public void setExp(ObjCExpression exp) {
		this.exp = exp;
	}


	public ArrayList <ObjCCase> getListecase() {
		return listeCase;
	}


	public void setListeCase(ArrayList <ObjCCase> listecase) {
		this.listeCase = listecase;
	}
	
	public Object accept(ObjCRecognizer v) {
		return v.visitSwitch(this);
	}
}
