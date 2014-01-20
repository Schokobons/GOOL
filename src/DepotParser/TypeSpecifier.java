package DepotParser;

import gool.recognizer.objC.Visitor;

public class TypeSpecifier extends Noeud {
	
	private Type type; 
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}
	
	public TypeSpecifier (Type t){
		this.type=t;		
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	

}
