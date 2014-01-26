package gool.parser.objc.core;

import gool.recognizer.objc.ObjCRecognizer;

public class ObjCPostfixExpression extends ObjCExpression {
	
	ObjCIDENT Nom;
	

	public Object accept(ObjCRecognizer v) {
		return v.visitPostfixExpression(this);
	}
}
