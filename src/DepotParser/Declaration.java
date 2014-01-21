package DepotParser;

import gool.recognizer.objC.Visitor;

public class Declaration extends Noeud{
	
	private Type type;
	private ObjCIDENT ident;
	private Expression exp;
	
	public Declaration (Type t, ObjCIDENT id, Expression e){
		this.exp=e;
		this.ident=id;
		this.type=t;
	}
	
	
	@Override
	public void accept(Visitor v) {
		v.visitDeclaration(this);
		
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
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
