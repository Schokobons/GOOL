package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class Switch extends Statement {
	
	private Expression exp;
	private ArrayList <Case> listecase;
	
	public Switch (Expression e, ArrayList <Case> lc){
		this.exp=e;
		this.listecase=lc;
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}


	public Expression getExp() {
		return exp;
	}


	public void setExp(Expression exp) {
		this.exp = exp;
	}


	public ArrayList <Case> getListecase() {
		return listecase;
	}


	public void setListecase(ArrayList <Case> listecase) {
		this.listecase = listecase;
	}

}
