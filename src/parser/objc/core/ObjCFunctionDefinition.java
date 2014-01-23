package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;



public class ObjCFunctionDefinition extends ObjCNoeud{
	
	private ObjCTypeSpecifier typeSpecifier;
	private ObjCIDENT ident;
	private ArrayList <ObjCParameterDeclaration> listeparam;
	private ObjCCompoundStatement block;
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(typeSpecifier != null)
			contexte.setTypeRetour(typeSpecifier.getType());
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++) {
				contexte.add(listeparam.get(i).getIdent(), listeparam.get(i).getTypeSpecifier().getType());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte.clone();
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++) {
				contexte.add(listeparam.get(i).getIdent(), listeparam.get(i).getTypeSpecifier().getType());
			}
		ajoutFils(n);
		if(ObjCTypeSpecifier.class.isInstance(n)) {
			typeSpecifier = (ObjCTypeSpecifier) n;
		}
		else if(ObjCIDENT.class.isInstance(n)) {
			ident = (ObjCIDENT) n;
		}
		else if(ObjCParameterDeclaration.class.isInstance(n)) {
			if(listeparam == null)
				listeparam = new ArrayList<ObjCParameterDeclaration>();
			listeparam.add((ObjCParameterDeclaration) n);
		}
		else if(ObjCCompoundStatement.class.isInstance(n)) {
			block = (ObjCCompoundStatement) n;
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("FunctionDefinition");
		if(typeSpecifier != null)
			typeSpecifier.print(etage + 1);
		if(ident != null)
			ident.print(etage + 1);
		if(listeparam != null)
			for(int i = 0; i < listeparam.size(); i++)
			listeparam.get(i).print(etage + 1);
		if(block != null)
			block.print(etage + 1);
	}
	
	public ObjCFunctionDefinition(ObjCTypeSpecifier t, ObjCIDENT id, ArrayList <ObjCParameterDeclaration> lp, ObjCCompoundStatement b){
		this.ident=id;
		this.typeSpecifier=t;
		this.listeparam=lp;
		this.setBlock(b);
	}

	public ObjCTypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}

	public void setTypeSpecifier(ObjCTypeSpecifier typeSpecifier) {
		this.typeSpecifier = typeSpecifier;
	}

	public ObjCIDENT getIdent() {
		return ident;
	}

	public void setIdent(ObjCIDENT ident) {
		this.ident = ident;
	}

	public ArrayList <ObjCParameterDeclaration> getListeparam() {
		return listeparam;
	}

	public void setListeparam(ArrayList <ObjCParameterDeclaration> listeparam) {
		this.listeparam = listeparam;
	}

	public ObjCCompoundStatement getBlock() {
		return block;
	}

	public void setBlock(ObjCCompoundStatement block) {
		this.block = block;
	}
	
	public Object accept(Visitor v) {
		return v.visitFunctionDefinition(this);
	}
}
