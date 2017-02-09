package fr.imie.echiquier;

import java.io.Serializable;

public abstract class Piece implements Serializable
{	
	//Region Attributs
	protected CodePiece type;
	protected Coordonnees position;
	protected String couleur;
	//EndRegion
	
	//Region Gets
	protected CodePiece getType(){return type;}
	protected String getCouleur(){return couleur;}
	//EndRegion
	
	//Region Methodes
	protected boolean positionPossible(Coordonnees position)
	{
		Piece p;
		p = Main.getPiece(position);
		if(p == null)
		{
			//Case vide...
			return true;
		}
		else
		//if (p.couleur == this.couleur)
			return false;
		//else return true;
	}
	abstract protected void deplacement();
	
	
	public String toString()
	{
		return "" + type.getSymbole() + ": " + type.getNom() + " " + couleur + " position : "+this.position.toString();
	}
	//EndRegion
}
