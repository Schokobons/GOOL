package gool.parser.objc;

import gool.parser.objc.core.ObjCNoeud;
import gool.parser.objc.core.ObjCRacine;
import gool.parser.objc.jtb.core.*;
import gool.parser.objc.jtb.visitor.*;
import gool.recognizer.objc.*;

import java.io.FileNotFoundException;


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
         System.err.println("Java program parsed successfully.");
         DepthFirstRetArguVisitor<String, ObjCNoeud> v1 = new DepthFirstRetArguVisitor<String, ObjCNoeud>();
         ObjCRacine root = new ObjCRacine();
         v1.visit(tu, root);
         root.print(0);
         root.typageExpression();
         root.print(0);
         Visitor v = new Visitor();
         v.visitRacine(root);
      }
      catch (ParseException e) {
         System.err.println("Encountered errors during parse.");
      }
   }
}