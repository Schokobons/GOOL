package DepotParser;

import java.util.ArrayList;

import gool.recognizer.objC.Visitor;

public class FunctionDefinition extends Noeud{
	
	private Type type;
	private ObjCIDENT ident;
	private ArrayList <ParameterDeclaration> listeparam;
	private CompoundStatement block;
	
	public FunctionDefinition(Type t, ObjCIDENT id, ArrayList <ParameterDeclaration> lp, CompoundStatement b){
		this.ident=id;
		this.type=t;
		this.listeparam=lp;
		this.setBlock(b);
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
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

	public ArrayList <ParameterDeclaration> getListeparam() {
		return listeparam;
	}

	public void setListeparam(ArrayList <ParameterDeclaration> listeparam) {
		this.listeparam = listeparam;
	}

	public CompoundStatement getBlock() {
		return block;
	}

	public void setBlock(CompoundStatement block) {
		this.block = block;
	}

}
