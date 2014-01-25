package DepotParser;
import gool.ast.core.ClassDef;
import gool.recognizer.objc.ObjCRecognizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {
	public static void afficherArbreLong(Node n, int etage) {
		int newetage = etage;
		if(true/*n.jjtGetNumChildren() != 1*//*n.jjtGetNumChildren() == 0 || (etage > 0 && n.jjtGetParent().jjtGetNumChildren() > 0 && !n.jjtGetParent().jjtGetChild(0).equals(n))*/) {
			for(int i = 0; i < etage; i++)
				System.out.print("  ");
			System.out.println(n);
			newetage++;
		}
		for(int i = 0; i < n.jjtGetNumChildren(); i++)
			afficherArbreLong(n.jjtGetChild(i), newetage);
	}
	
	public static void reduireArbre(Node n, Node pere) {
		if(pere == null) {
			for(int i = 0; i < n.jjtGetNumChildren(); i++) 
				reduireArbre(n.jjtGetChild(i), n);
		}
		else {
			if(pere.jjtGetNumChildren() == 1 && n.jjtGetNumChildren() > 0 && (n.getName() == null || n.getName().length() == 0)) {
				pere.jjtRemoveChild(0);
				for(int i = 0; i < n.jjtGetNumChildren(); i++) {
					pere.jjtAddChild(n.jjtGetChild(i), i);
				}
			}
			for(int i = 0; i < n.jjtGetNumChildren(); i++)
				reduireArbre(n.jjtGetChild(i), n);
		}
	}
	
	/*public static nodeToNoeud(Node first, Noeud root) {
		switch (first.getKind()) 
		{
		case 3 : 
			FunctionDefinition courant = new FunctionDefinition();
		
	}*/
	
	public static void main(String[] args) {
		
		ObjCParser parser = null;
		try {
			parser = new ObjCParser(new java.io.FileInputStream("example2.m"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//SimpleNode n = parser.TranslationUnit();
	        parser.TranslationUnit();
	        Node first = parser.jjtree.rootNode();
	        afficherArbreLong(first, 0);
	        System.out.println("\n\n\n     -----Reduction de l'arbre-----\n\n\n");
	        reduireArbre(first, null);
	        //afficherArbreLong(first, 0);
	        SimpleNode simple = (SimpleNode) parser.jjtree.rootNode();
	        System.out.println("ObjectiveC 2.0 Parser Version 1.0:  ObjectiveC program parsed successfully.");
		} catch (ParseException e) {
	        System.out.println(e.getMessage());
	        System.out.println("ObjectiveC 2.0 Parser Version 1.0:  Encountered errors during parse.");
		}
		
		/*test 1
		 * OBJCompoundStatement block = new OBJCompoundStatement(null,null);
		OBJFunctionDefinition f = new OBJFunctionDefinition(Type.vide,new OBJCIDENT("test"),null,block);
		*/
		
	}
}
