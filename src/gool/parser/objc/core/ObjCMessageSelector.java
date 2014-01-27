package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCMessageSelector extends ObjCExpression {
	
	private ObjCIDENT methName;
	private ArrayList<ObjCExpression> arguments;
	
	public void setTypeSpecifier(ObjCTypeSpecifier t) {
	}
	
	public ObjCMessageSelector (ObjCIDENT methName, ArrayList<ObjCExpression> arguments) {
		this.methName = methName;
		this.arguments = arguments;
	}
	
	public void growName(String s) {
		if(!(s == null) && s.length() > 0 && !s.equals(":"))
			methName.setNom(methName.getNom() + s);
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
			if(ObjCIDENT.class.isInstance(n) && ((ObjCIDENT) n).getTypeSpecifier() == null) {
				((ObjCIDENT) n).setTypeSpecifier(contexte.getType((ObjCIDENT) n));
			}
		}
	}
	
	public void print (int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.println("MessageSelector : " + methName.getNom());
		if(arguments != null)
			for(int i = 0; i < arguments.size(); i++)
				if(arguments.get(i) != null)
					arguments.get(i).print(etage + 1);
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitMessageSelector(this);
	}
	
	public String getMethName() {
		return methName.getNom();
	}
	
	public ArrayList<ObjCExpression> getArguments() {
		return arguments;
	}
}
