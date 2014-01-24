package gool.parser.objc.core;



public abstract class ObjCExpression extends ObjCNoeud{

	protected ObjCType type;
	
	public void setType(ObjCType t) {
		type = t;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n))
			((ObjCExpression) (n)).setType(type);
	}
	
	public void afficherType() {
		System.out.print("(Type : ");
		if(type != null) {
			switch(type)
			{
			case entier : System.out.print("entier)");break;
			case reel : System.out.print("reel)");break;
			case caractere : System.out.print("caractere)");break;
			case chaine : System.out.print("chaine)");break;
			case booleen : System.out.print("booleen)");break;
			default : System.out.print("vide)");break;
			}
		}
		else {
			System.out.print("inconnu)");
		}
	}
	
	public ObjCType getType() {
		return type;
	}
}
