package DepotParser;

import gool.recognizer.objC.Visitor;

public class OBJIf extends OBJStatement{

	private OBJExpression exp;
	private OBJCompoundStatement th; //then
	private OBJCompoundStatement el; //else
	
	public OBJIf(OBJExpression ex, OBJCompoundStatement t, OBJCompoundStatement e){
		this.el=e;
		this.exp=ex;
		this.th=t;
		
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visitIf(this);
		
	}

	public OBJExpression getExp() {
		return exp;
	}

	public void setExp(OBJExpression exp) {
		this.exp = exp;
	}

	public OBJCompoundStatement getTh() {
		return th;
	}

	public void setTh(OBJCompoundStatement th) {
		this.th = th;
	}

	public OBJCompoundStatement getEl() {
		return el;
	}

	public void setEl(OBJCompoundStatement el) {
		this.el = el;
	}

}
