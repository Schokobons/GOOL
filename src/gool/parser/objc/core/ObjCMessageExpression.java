package gool.parser.objc.core;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCMessageExpression extends ObjCExpression {
	
	ObjCIDENT objet;
	ObjCMessageSelector messageSelector;
	
	public ObjCMessageExpression(ObjCIDENT objet, ObjCMessageSelector messageSelector) {
		this.objet = objet;
		this.messageSelector = messageSelector;
	}
	
	public void addFils(ObjCNoeud n) {
		if(contexte == null)
			contexte = new ObjCContexte();
		if(n != null && n.contexte == null)
			n.contexte = contexte;
		ajoutFils(n);
		if(ObjCIDENT.class.isInstance(n)) {
			objet = (ObjCIDENT) n;
			if(getTypeSpecifier() == null && objet.getTypeSpecifier() != null)
				setTypeSpecifier(objet.getTypeSpecifier());
		}
		else if(ObjCMessageSelector.class.isInstance(n)) {
			messageSelector = (ObjCMessageSelector) n;
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("MessageExpression");
		if(objet != null)
			objet.print(etage + 1);
		if(messageSelector != null)
			messageSelector.print(etage + 1);
	}
	
	public ObjCIDENT getObjet() {
		return objet;
	}
	
	public ObjCMessageSelector getMessageSelector() {
		return messageSelector;
	}

	public Object accept(ObjCRecognizer v) {
		return v.visitMessageExpression(this);
	}
}
