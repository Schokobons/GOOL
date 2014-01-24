package gool.parser.objc.core;

import gool.recognizer.objc.Visitor;

public class ObjCSuperClassName extends ObjCNoeud{
	private String name;
	
	public ObjCSuperClassName(String name) {
		this.name = name;
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println("Super Classe : " + getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object accept(Visitor v) {
		return name;
	}
}