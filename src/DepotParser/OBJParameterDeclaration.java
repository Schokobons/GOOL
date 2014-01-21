package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJParameterDeclaration extends OBJNoeud {

	private Type type;
	private OBJCIDENT ident;
	
	public OBJParameterDeclaration(Type t, OBJCIDENT id){
		this.ident=id;
		this.type=t;
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visitParameterDeclaration(this);
		
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

}
