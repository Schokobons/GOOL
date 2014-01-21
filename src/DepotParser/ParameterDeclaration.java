package DepotParser;

import gool.recognizer.objC.Visitor;

public class ParameterDeclaration extends Noeud {

	private Type type;
	private ObjCIDENT ident;
	
	public ParameterDeclaration(Type t, ObjCIDENT id){
		this.ident=id;
		this.type=t;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitParameterDeclaration(this);
		
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

}
