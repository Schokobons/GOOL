package DepotParser;

import gool.recognizer.objC.Visitor;

public class Return extends Statement{
	
	private Expression exp;
	
	public Return (Expression e){
		this.exp=e;
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

}
