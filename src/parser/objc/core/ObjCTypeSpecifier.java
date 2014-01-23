package gool.parser.objc.core;

import gool.recognizer.objc.*;



public class ObjCTypeSpecifier extends ObjCNoeud{

	ObjCType type;
	
	public ObjCTypeSpecifier(ObjCType t) {
		type = t;
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
		default : System.out.println("entier");break;
		}
	}
	
	public void setType(ObjCType t) {
		type = t;
	}
	
	public ObjCType getType() {
		return type;
	}
	
	public Object accept(Visitor v) {
		return v.visitTypeSpecifier(this);
	}
}
