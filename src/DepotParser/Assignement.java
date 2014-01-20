package DepotParser;

import gool.recognizer.objC.Visitor;

public class Assignement extends Statement {
	
	private ObjCIDENT ident;
	private Expression exp;
	
	public Assignement(ObjCIDENT id, Expression e){
		this.exp=e;
		this.ident=id;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public ObjCIDENT getIdent() {
		return ident;
	}

	public void setIdent(ObjCIDENT ident) {
		this.ident = ident;
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

}
