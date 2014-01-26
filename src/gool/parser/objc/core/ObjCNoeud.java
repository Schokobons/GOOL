package gool.parser.objc.core;

import java.util.ArrayList;

import gool.recognizer.objc.*;

public abstract class ObjCNoeud {
	private ObjCNoeud pere;
	protected ArrayList<ObjCNoeud> fils = new ArrayList<ObjCNoeud>();
	public ObjCContexte contexte;
	protected boolean ContexteModifie = false;

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

	public abstract Object accept(ObjCRecognizer v);
	
	public void addFils(ObjCNoeud n) {
		if(n != null && n.contexte == null && contexte != null)
			n.contexte = contexte;
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
					changement = typerConstante(2);
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
				if(((ObjCConstante) this).getTypeSpecifier() == null) {
					switch (type)
					{
					case 1 :
						try {
							Float.parseFloat(((ObjCConstante)this).getValeur());
							((ObjCConstante)this).setTypeSpecifier(ObjCTypeSpecifier.INSTANCEreel);
							return true;
						}
						catch(Exception e) { }
						break;
					default : 
						((ObjCConstante)this).setTypeSpecifier(ObjCTypeSpecifier.INSTANCEchaine);
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
			if(((ObjCExpression) this).getTypeSpecifier() == null || ((ObjCExpression) this).getTypeSpecifier().getType() == null)
				((ObjCExpression) this).setTypeSpecifier(rechercheTypeExpression(this));
		for(int i = 0; i < fils.size(); i++)
			fils.get(i).typerExpression();
	}
	
	private int nbExpInconnu() {
		int res = 0;
		if(ObjCExpression.class.isInstance(this) && ((ObjCExpression)this).getTypeSpecifier() != null && ((ObjCExpression)this).getTypeSpecifier().getType() == null)
			res = 1;
		if(ObjCExpression.class.isInstance(this) && ((ObjCExpression)this).getTypeSpecifier() == null)
			res = 1;
		for(int i = 0; i < fils.size(); i++)
			res += fils.get(i).nbExpInconnu();
		return res;
	}
	
	private ObjCTypeSpecifier rechercheTypeExpressionDansFils(ObjCNoeud n) {
		if(ObjCExpression.class.isInstance(n)) {
			if(((ObjCExpression) n).getTypeSpecifier() != null && ((ObjCExpression) n).getTypeSpecifier().getType() != null)
				return ((ObjCExpression) n).getTypeSpecifier();
			ObjCTypeSpecifier type = null;
			int i = 0;
			if(n != null && ObjCExpression.class.isInstance(n) && !ObjCMessageExpression.class.isInstance(n) 
					&& !ObjCMessageSelector.class.isInstance(n) && !(ObjCExpBinaire.class.isInstance(n) && (
							((ObjCExpBinaire)n).getOperation().equals(ObjCOperation.different) ||
							((ObjCExpBinaire)n).getOperation().equals(ObjCOperation.egal) ||
							((ObjCExpBinaire)n).getOperation().equals(ObjCOperation.superieur) ||
							((ObjCExpBinaire)n).getOperation().equals(ObjCOperation.inferieur) ||
							((ObjCExpBinaire)n).getOperation().equals(ObjCOperation.superieurouegal) ||
							((ObjCExpBinaire)n).getOperation().equals(ObjCOperation.inferieurouegal) )))
				while(type == null && i < n.fils.size()) {
					type = rechercheTypeExpressionDansFils(n.fils.get(i));
					i++;
				}
			return type;
		}
		return null;
	}
	
	private ObjCTypeSpecifier rechercheTypeExpression(ObjCNoeud n) {
		if(ObjCExpression.class.isInstance(n)) {
			if(((ObjCExpression) this).getTypeSpecifier() != null && ((ObjCExpression) n).getTypeSpecifier().getType() != null)
				return ((ObjCExpression) n).getTypeSpecifier();
			ObjCTypeSpecifier type = null;
			int i = 0;
			while(type == null && i < n.fils.size()) {
				type = rechercheTypeExpressionDansFils(n.fils.get(i));
				i++;
			}
			if(type != null)
				return type;
			if(n.pere != null && ObjCExpression.class.isInstance(n.pere) && ((ObjCExpression)n.pere).getTypeSpecifier() !=null
					&& !ObjCMessageExpression.class.isInstance(n.pere) && !ObjCMessageSelector.class.isInstance(n.pere)
					&& ((ObjCExpression)n.pere).getTypeSpecifier().getType() !=null && !(ObjCExpBinaire.class.isInstance(n.pere) && (
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.different) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.egal) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.superieur) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.inferieur) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.superieurouegal) ||
							((ObjCExpBinaire)n.pere).getOperation().equals(ObjCOperation.inferieurouegal) )))
				return ((ObjCExpression)n.pere).getTypeSpecifier();
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
