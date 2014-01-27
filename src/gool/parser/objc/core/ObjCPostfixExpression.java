package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCPostfixExpression extends ObjCExpression {
	
	String nom;
	private ArrayList<ObjCExpression> arguments;
	
	public ObjCPostfixExpression (String nom, ArrayList<ObjCExpression> arguments) {
		this.nom = nom;
		this.arguments = arguments;
		if(nom != null && (nom.equals("++") || nom.equals("--")))
			setTypeSpecifier(ObjCTypeSpecifier.INSTANCEentier);
		if(nom != null && nom.equals("NSLog"))
			setTypeSpecifier(ObjCTypeSpecifier.INSTANCEvide);
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(n != null && n.contexte == null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			if(arguments == null)
				arguments = new ArrayList<ObjCExpression>();
			arguments.add((ObjCExpression) n);
		}
	}
	
	public void print (int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.println("PostfixExpression : " + nom);
		if(arguments != null)
			for(int i = 0; i < arguments.size(); i++)
				if(arguments.get(i) != null)
					arguments.get(i).print(etage + 1);
	}
	
	public String getnom() {
		return nom;
	}
	
	public ArrayList<ObjCExpression> getArguments() {
		return arguments;
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitPostfixExpression(this);
	}
}
