package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJAssignement extends OBJStatement {
	
	private OBJCIDENT ident;
	private OBJExpression exp;
	
	public OBJAssignement(OBJCIDENT id, OBJExpression e){
		this.exp=e;
		this.ident=id;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visitAssignement(this);
		
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
