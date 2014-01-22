package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJDeclaration extends OBJNoeud{
	
	private Type type;
	private OBJCIDENT ident;
	private OBJExpression exp;
	
	public OBJDeclaration (Type t, OBJCIDENT id, OBJExpression e){
		this.exp=e;
		this.ident=id;
		this.type=t;
	}
	
	
	@Override
	public Object accept(Visitor v) {
		return v.visitDeclaration(this);
		
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public OBJCIDENT getIdent() {
		return ident;
	}


	public void setIdent(OBJCIDENT ident) {
		this.ident = ident;
	}


	public OBJExpression getExp() {
		return exp;
	}


	public void setExp(OBJExpression exp) {
		this.exp = exp;
	}

}
