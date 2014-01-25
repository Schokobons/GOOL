package gool.parser.objc.core;



public abstract class ObjCExpression extends ObjCNoeud{

	protected ObjCTypeSpecifier type;
	
	public void setTypeSpecifier(ObjCTypeSpecifier t) {
		type = t;
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n))
			((ObjCExpression) (n)).setTypeSpecifier(type);
	}
	
	public void afficherType() {
		System.out.print("(Type : ");
		if(type != null && type.getType() != null) {
			switch(type.getType())
			{
			case entier : System.out.print("entier)");break;
			case reel : System.out.print("reel)");break;
			case caractere : System.out.print("caractere)");break;
			case chaine : System.out.print("chaine)");break;
			case booleen : System.out.print("booleen)");break;
			case inconnu : System.out.print("inconnu : " + type.getName() + ")");break;
			case objet : System.out.print("objet)");break;
			default : System.out.print("vide)");break;
			}
		}
		else {
			System.out.print("null)");
		}
	}
	
	public ObjCTypeSpecifier getTypeSpecifier() {
		return type;
	}
}
