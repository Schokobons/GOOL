package DepotParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
	public static void afficherArbre(Node n, int etage) {
		if(n.jjtGetNumChildren() == 0 || (etage > 0 && n.jjtGetParent().jjtGetNumChildren() > 0 && !n.jjtGetParent().jjtGetChild(0).equals(n))) {
			for(int i = 0; i < etage; i++)
				System.out.print("  ");
			System.out.println(n);
		}
		for(int i = 0; i < n.jjtGetNumChildren(); i++)
			afficherArbre(n.jjtGetChild(i), etage + 1 );
	}
	
	public static void main(String[] args) {
		ObjCParser parser = null;
		try {
			parser = new ObjCParser(new java.io.FileInputStream("example.cc"));
			System.out.println("Debut");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//SimpleNode n = parser.TranslationUnit();
	        parser.TranslationUnit();
	        Node first = parser.jjtree.rootNode();
	        afficherArbre(first, 0);
	        SimpleNode simple = (SimpleNode) parser.jjtree.rootNode();
	        System.out.println("ObjectiveC 2.0 Parser Version 1.0:  ObjectiveC program parsed successfully.");
		} catch (ParseException e) {
	        System.out.println(e.getMessage());
	        System.out.println("ObjectiveC 2.0 Parser Version 1.0:  Encountered errors during parse.");
		}
	}
}
