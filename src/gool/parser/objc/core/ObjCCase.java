package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;

public class ObjCCase extends ObjCStatement {
	
	private ObjCExpression exp;
	private ArrayList <ObjCStatement> listeStatement;
	
	public Object accept(ObjCRecognizer v) {
		return v.visitCase(this);
	}
	
	public ObjCCase(ObjCExpression exp, ArrayList <ObjCStatement> ls){
		this.exp = exp;
		this.listeStatement=ls;
	}

	public ObjCExpression getExp() {
		return exp;
	}

	public void setExp(ObjCExpression exp) {
		this.exp = exp;
	}

	public ArrayList <ObjCStatement> getListeStatement() {
		return listeStatement;
	}

	public void setListeStatement(ArrayList <ObjCStatement> listestatement) {
		this.listeStatement = listestatement;
	}
}
