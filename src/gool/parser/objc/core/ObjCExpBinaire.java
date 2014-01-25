package gool.parser.objc.core;

import gool.recognizer.objc.*;




public class ObjCExpBinaire extends ObjCExpression {
	
	private ObjCOperation operation;
	private ObjCExpression expGauche;
	private ObjCExpression expDroite;
	
	public ObjCExpBinaire(ObjCOperation op, ObjCExpression expG, ObjCExpression expD){
		this.operation=op;
		this.expDroite=expD;
		this.expGauche=expG;
		switch(operation)
		{
		case et :
		case ou :
		case non :
		case different :
		case superieurouegal :
		case inferieurouegal :
		case superieur :
		case inferieur :
		case egal : setTypeSpecifier(new ObjCTypeSpecifier(ObjCType.booleen));break;
		default : break;
		}
	}
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		ajoutFils(n);
		if(ObjCExpression.class.isInstance(n)) {
			ObjCExpression exp;
			exp = (ObjCExpression) n;
			if(ObjCIDENT.class.isInstance(exp)) {
				if(contexte != null)
					((ObjCIDENT)n).setTypeSpecifier(contexte.getType((ObjCIDENT) n));
			}
			if(expGauche == null) {
				expGauche = exp;
				if(getTypeSpecifier() != null && ((operation.equals(ObjCOperation.diviser)) || operation.equals(ObjCOperation.et)
						 || operation.equals(ObjCOperation.moins) || operation.equals(ObjCOperation.multiplier)
						 || operation.equals(ObjCOperation.non) || operation.equals(ObjCOperation.ou)
						 || operation.equals(ObjCOperation.plus)))
					expGauche.setTypeSpecifier(getTypeSpecifier());
			}
			else {
				expDroite = exp;
				if(getTypeSpecifier() != null && ((operation.equals(ObjCOperation.diviser)) || operation.equals(ObjCOperation.et)
						 || operation.equals(ObjCOperation.moins) || operation.equals(ObjCOperation.multiplier)
						 || operation.equals(ObjCOperation.non) || operation.equals(ObjCOperation.ou)
						 || operation.equals(ObjCOperation.plus)))
					expDroite.setTypeSpecifier(getTypeSpecifier());
			}
		}
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");afficherType();
		System.out.print("ExpBinaire : ");
		switch(operation)
		{
		case plus : System.out.println("plus");break;
		case moins : System.out.println("moins");break;
		case multiplier : System.out.println("multiplier");break;
		case diviser : System.out.println("diviser");break;
		case et : System.out.println("et");break;
		case ou : System.out.println("ou");break;
		case non : System.out.println("non");break;
		case different : System.out.println("different");break;
		case superieurouegal : System.out.println("superieurouegal");break;
		case inferieurouegal : System.out.println("inferieurouegal");break;
		case superieur : System.out.println("superieur");break;
		case inferieur : System.out.println("inferieur");break;
		default : System.out.println("egal");break;
		}
		if(expGauche != null) 
			expGauche.print(etage + 1);
		if(expDroite != null) 
			expDroite.print(etage + 1);
	}

	public ObjCOperation getOperation() {
		return operation;
	}

	public void setOperation(ObjCOperation operation) {
		this.operation = operation;
	}

	public ObjCExpression getExpGauche() {
		return expGauche;
	}

	public void setExpGauche(ObjCExpression expGauche) {
		this.expGauche = expGauche;
	}

	public ObjCExpression getExpDroite() {
		return expDroite;
	}

	public void setExpDroite(ObjCExpression expDroite) {
		this.expDroite = expDroite;
	}
	
	public Object accept(Visitor v) {
		return v.visitExpBinaire(this);
	}
}
