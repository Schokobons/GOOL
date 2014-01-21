package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class OBJFunctionDefinition extends OBJNoeud{
	
	private Type type;
	private OBJCIDENT ident;
	private ArrayList <OBJParameterDeclaration> listeparam;
	private OBJCompoundStatement block;
	
	public OBJFunctionDefinition(Type t, OBJCIDENT id, ArrayList <OBJParameterDeclaration> lp, OBJCompoundStatement b){
		this.ident=id;
		this.type=t;
		this.listeparam=lp;
		this.setBlock(b);
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visitFunctionDefinition(this);
		
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

	public ArrayList <OBJParameterDeclaration> getListeparam() {
		return listeparam;
	}

	public void setListeparam(ArrayList <OBJParameterDeclaration> listeparam) {
		this.listeparam = listeparam;
	}

	public OBJCompoundStatement getBlock() {
		return block;
	}

	public void setBlock(OBJCompoundStatement block) {
		this.block = block;
	}

}
