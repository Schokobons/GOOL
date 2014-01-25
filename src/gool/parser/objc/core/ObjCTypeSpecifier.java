package gool.parser.objc.core;

import gool.ast.type.TypeInt;
import gool.recognizer.objc.*;



public class ObjCTypeSpecifier extends ObjCNoeud{

	ObjCType type;//reel, caractere, chaine, booleen, vide, inconnu, objet; 
	String name;
	
	public static final ObjCTypeSpecifier INSTANCEentier = new ObjCTypeSpecifier(ObjCType.entier);
	public static final ObjCTypeSpecifier INSTANCEreel = new ObjCTypeSpecifier(ObjCType.reel);
	public static final ObjCTypeSpecifier INSTANCEcaractere = new ObjCTypeSpecifier(ObjCType.caractere);
	public static final ObjCTypeSpecifier INSTANCEchaine = new ObjCTypeSpecifier(ObjCType.chaine);
	public static final ObjCTypeSpecifier INSTANCEbooleen = new ObjCTypeSpecifier(ObjCType.booleen);
	public static final ObjCTypeSpecifier INSTANCEvide = new ObjCTypeSpecifier(ObjCType.vide);
	public static final ObjCTypeSpecifier INSTANCEobjet = new ObjCTypeSpecifier(ObjCType.objet);
	public static final ObjCTypeSpecifier INSTANCEnull = new ObjCTypeSpecifier();
	
	private ObjCTypeSpecifier(ObjCType t) {
		type = t;
	}
	
	/**
	 * This constructor in used only for an ObjCType null, for the other types you have to get the instance.
	 * @param n
	 */
	private ObjCTypeSpecifier() {
	}
	
	/**
	 * This constructor is used only for ObjCType.inconnu, for the other types you have to get the instance.
	 * @param n
	 */
	public ObjCTypeSpecifier(String n) {
		type = ObjCType.inconnu;
		name = n;
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.print("TypeSpecifier : ");
		switch(type)
		{
		case vide : System.out.println("vide");break;
		case booleen : System.out.println("booleen");break;
		case chaine : System.out.println("chaine");break;
		case caractere : System.out.println("caractere");break;
		case reel : System.out.println("reel");break;
		case inconnu : System.out.println("inconnu");break;
		case objet : System.out.println("objet");break;
		default : System.out.println("entier");break;
		}
	}
	
	public void setType(ObjCType t) {
		if(type == null)
			type = t;
	}
	
	public ObjCType getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Object accept(Visitor v) {
		return v.visitTypeSpecifier(this);
	}
}
