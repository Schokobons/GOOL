package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;

public class ObjCFunctionDefinition extends ObjCNoeud{
	
	private ObjCTypeSpecifier typeSpecifier;
	private ObjCIDENT ident;
	private ArrayList <ObjCParameterDeclaration> listeParam;
	private ObjCCompoundStatement block;
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(typeSpecifier != null)
			contexte.setTypeRetour(typeSpecifier);
		if(listeParam != null)
			for(int i = 0; i < listeParam.size(); i++) {
				if(!ContexteModifie) {
					ContexteModifie = true;
					contexte = contexte.clone();
				}
				contexte.add(listeParam.get(i).getIdent(), listeParam.get(i).getTypeSpecifier());
			}
		if(n != null && n.contexte == null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCTypeSpecifier.class.isInstance(n)) {
			typeSpecifier = (ObjCTypeSpecifier) n;
		}
		else if(ObjCIDENT.class.isInstance(n)) {
			ident = (ObjCIDENT) n;
		}
		else if(ObjCParameterDeclaration.class.isInstance(n)) {
			if(listeParam == null)
				listeParam = new ArrayList<ObjCParameterDeclaration>();
			listeParam.add((ObjCParameterDeclaration) n);
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
		if(listeParam != null)
			for(int i = 0; i < listeParam.size(); i++)
			listeParam.get(i).print(etage + 1);
		if(block != null)
			block.print(etage + 1);
	}
	
	public ObjCFunctionDefinition(ObjCTypeSpecifier t, ObjCIDENT id, ArrayList <ObjCParameterDeclaration> lp, ObjCCompoundStatement b){
		this.ident=id;
		this.typeSpecifier=t;
		this.listeParam=lp;
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

	public ArrayList <ObjCParameterDeclaration> getListeParam() {
		return listeParam;
	}

	public void setListeParam(ArrayList <ObjCParameterDeclaration> listeparam) {
		this.listeParam = listeparam;
	}

	public ObjCCompoundStatement getBlock() {
		return block;
	}

	public void setBlock(ObjCCompoundStatement block) {
		this.block = block;
	}
	
	public Object accept(ObjCRecognizer v) {
		return v.visitFunctionDefinition(this);
	}
}
