package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;

public abstract class ObjCNoeud {
	private ObjCNoeud pere;
	protected ArrayList<ObjCNoeud> fils = new ArrayList<ObjCNoeud>();
	public ObjCContexte contexte;

	public void ajoutFils(ObjCNoeud n) {
		fils.add(n);
		n.pere = this;
	}
	
	public ObjCNoeud getPere() {
		return pere;
	}
	
	public void afficherFils(int etage) {
		for(int i = 0; i < fils.size(); i++)
			fils.get(i).print(etage);
	}

	public abstract Object accept(Visitor v);
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte.clone();
		fils.add(n);
	}
	
	public void print(int etage) {
		for(int i = 0; i < etage; i++)
			System.out.print("  ");
		System.out.println(this.getClass());
		for(int i = 0; i < fils.size(); i++)
			fils.get(i).print(etage + 1);
	}
	
	public void typageExpression() {
		int inconnuPrecedent = 0;
		while(nbExpInconnu() != 0 && nbExpInconnu() != inconnuPrecedent) {
			inconnuPrecedent = nbExpInconnu();
			typerExpression();
			if(inconnuPrecedent == nbExpInconnu()) {
				boolean changement;
				changement = typerConstante(1);
				if(changement)
					typerExpression();
				else {
					changement = typerConstante(3);
					if(changement)
						typerExpression();
				}
			}
		}
	}
	
	public boolean typerConstante(int type) {
		boolean result = false;
		if(ObjCExpression.class.isInstance(this))
			if(ObjCConstante.class.isInstance(this))
				if(((ObjCConstante) this).getType() == null) {
					switch (type)
					{
					case 1 :
						try {
							float f = Float.parseFloat(((ObjCConstante)this).getValeur());
							((ObjCConstante)this).setType(ObjCType.reel);
							return true;
						}
						catch(Exception e) { }
						break;
					default : 
						((ObjCConstante)this).setType(ObjCType.chaine);
						break;
					}
				}
		int i = 0;
		while(!result && i < fils.size()) {
			result = fils.get(i).typerConstante(type);
			i++;
		}
		return result;
	}
	
	public void typerExpression() {
		if(ObjCExpression.class.isInstance(this))
			if(((ObjCExpression) this).getType() == null)
				((ObjCExpression) this).setType(rechercheTypeExpression(this));
		for(int i = 0; i < fils.size(); i++)
			fils.get(i).typageExpression();
	}
	
	private int nbExpInconnu() {
		int res = 0;
		if(ObjCExpression.class.isInstance(this) && ((ObjCExpression)this).getType() == null)
			res = 1;
		for(int i = 0; i < fils.size(); i++)
			res += fils.get(i).nbExpInconnu();
		return res;
	}
	
	private ObjCType rechercheTypeExpressionDansFils(ObjCNoeud n) {
		if(ObjCExpression.class.isInstance(n)) {
			if(((ObjCExpression) n).getType() != null)
				return ((ObjCExpression) n).getType();
			ObjCType type = null;
			int i = 0;
			while(type == null && i < n.fils.size()) {
				type = rechercheTypeExpressionDansFils(n.fils.get(i));
				i++;
			}
			if(type != null)
				return type;
		}
		return null;
	}
	
	private ObjCType rechercheTypeExpression(ObjCNoeud n) {
		if(ObjCExpression.class.isInstance(n)) {
			if(((ObjCExpression) n).getType() != null)
				return ((ObjCExpression) n).getType();
			ObjCType type = null;
			int i = 0;
			while(type == null && i < n.fils.size()) {
				type = rechercheTypeExpressionDansFils(n.fils.get(i));
				i++;
			}
			if(type != null)
				return type;
			if(n.pere != null && ObjCExpression.class.isInstance(n.pere) && ((ObjCExpression)n.pere).getType()!=null
					&& !(ObjCExpBinaire.class.isInstance(n.pere) && (
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.different) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.egal) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.superieur) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.inferieur) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.superieurouegal) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.inferieurouegal) )))
				return ((ObjCExpression)n.pere).getType();
			if(n.pere != null && ObjCExpBinaire.class.isInstance(n.pere)) {
				ObjCOperation operation = ((ObjCExpBinaire)n.pere).getOperation();
				if((operation.equals(ObjCOperation.diviser)) || operation.equals(ObjCOperation.et)
						 || operation.equals(ObjCOperation.moins) || operation.equals(ObjCOperation.multiplier)
						 || operation.equals(ObjCOperation.non) || operation.equals(ObjCOperation.ou)
						 || operation.equals(ObjCOperation.plus))
					return null;
				else {
					ObjCNoeud frere;
					if(((ObjCExpBinaire)n.pere).getExpGauche().equals(n))
						frere = ((ObjCExpBinaire)n.pere).getExpDroite();
					else
						frere = ((ObjCExpBinaire)n.pere).getExpGauche();
					return rechercheTypeExpressionDansFils(frere);
				}
						 
			}
		}
		return null;
	}
}
