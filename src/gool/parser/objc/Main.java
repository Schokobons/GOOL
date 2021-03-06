package gool.parser.objc;

import gool.parser.objc.core.ObjCNoeud;
import gool.parser.objc.core.ObjCRacine;
import gool.parser.objc.jtb.core.*;
import gool.parser.objc.jtb.visitor.*;
import gool.recognizer.objc.*;

import java.io.FileNotFoundException;

//This main is use to see if our tree and type seek work fine.

public class Main {
	
   public static void main(String args[]) {
      ObjCParser parser = null;
	try {
		parser = new ObjCParser(new java.io.FileInputStream("example2.m"));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      try {
    	 TranslationUnit tu = parser.TranslationUnit();
         System.out.println("Java program parsed successfully.");
         DepthFirstRetArguVisitor<String, ObjCNoeud> v1 = new DepthFirstRetArguVisitor<String, ObjCNoeud>();
         ObjCRacine root = new ObjCRacine();
         v1.visit(tu, root);
         root.print(0);
         System.out.println("\n\n\n\n\n\n     -----Typage-----\n\n\n\n\n");
         root.typageExpression();
         root.print(0);
         ObjCRecognizer v = new ObjCRecognizer();
         v.visitRacine(root);
      }
      catch (ParseException e) {
         System.err.println("Encountered errors during parse.");
      }
   }
}