package gool.parser.objc.core;

import gool.recognizer.objc.*;

public class ObjCParameterDeclaration extends ObjCNoeud {

	private ObjCTypeSpecifier typeSpecifier;
	private ObjCIDENT ident;
	
	public ObjCParameterDeclaration(ObjCTypeSpecifier t, ObjCIDENT id){
		this.ident=id;
		this.typeSpecifier=t;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCTypeSpecifier.class.isInstance(n)) {
			typeSpecifier = (ObjCTypeSpecifier) n;
		}
		else if(ObjCIDENT.class.isInstance(n)) {
			ident = (ObjCIDENT) n;
			if(typeSpecifier != null)
				ident.setTypeSpecifier(typeSpecifier);
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("ParameterDeclaration");
		if(typeSpecifier != null)
			typeSpecifier.print(etage + 1);
		if(ident != null)
			ident.print(etage + 1);
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
	
	public Object accept(ObjCRecognizer v) {
		return v.visitParameterDeclaration(this);
	}
}
