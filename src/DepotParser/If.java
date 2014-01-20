package DepotParser;

import gool.recognizer.objC.Visitor;

public class If extends Statement{

	private Expression exp;
	private CompoundStatement th; //then
	private CompoundStatement el; //else
	
	public If(Expression ex, CompoundStatement t, CompoundStatement e){
		this.el=e;
		this.exp=ex;
		this.th=t;
		
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	public CompoundStatement getTh() {
		return th;
	}

	public void setTh(CompoundStatement th) {
		this.th = th;
	}

	public CompoundStatement getEl() {
		return el;
	}

	public void setEl(CompoundStatement el) {
		this.el = el;
	}

}
