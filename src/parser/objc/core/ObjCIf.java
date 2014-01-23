package gool.parser.objc.core;

import gool.recognizer.objc.*;




public class ObjCIf extends ObjCStatement{

	private ObjCExpression exp;
	private ObjCCompoundStatement th; //then
	private ObjCCompoundStatement el; //else
	
	public ObjCIf(ObjCExpression ex, ObjCCompoundStatement t, ObjCCompoundStatement e){
		this.el=e;
		this.exp=ex;
		this.th=t;
		
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			exp = (ObjCExpression) n;
		}
		else if(ObjCCompoundStatement.class.isInstance(n)) {
			if(th == null)
				th = (ObjCCompoundStatement) n;
			else
				el = (ObjCCompoundStatement) n;
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("If");
		if(exp != null) 
			exp.print(etage + 1);
		if(th != null) 
			th.print(etage + 1);
		if(el != null) 
			el.print(etage + 1);
	}

	public ObjCExpression getExp() {
		return exp;
	}

	public void setExp(ObjCExpression exp) {
		this.exp = exp;
	}

	public ObjCCompoundStatement getTh() {
		return th;
	}

	public void setTh(ObjCCompoundStatement th) {
		this.th = th;
	}

	public ObjCCompoundStatement getEl() {
		return el;
	}

	public void setEl(ObjCCompoundStatement el) {
		this.el = el;
	}
	
	public Object accept(Visitor v) {
		return v.visitIf(this);
	}
}
