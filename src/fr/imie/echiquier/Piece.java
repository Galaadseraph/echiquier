package fr.imie.echiquier;

import java.io.Serializable;

public abstract class Piece implements Serializable
{	
	protected CodePiece type;
	protected Coordonnees position;
	protected String couleur;
	
	protected CodePiece getType(){return type;}
	protected String getCouleur(){return couleur;}
	
	protected boolean positionPossible(Coordonnees position)
	{
		Piece p;
		try
		{
			p = Main.getPiece(position);
		}
		catch (EchiquierException e)
		{
			//Case vide...
			return true;
		}
		//if (p.couleur == this.couleur)
			return false;
		//else return true;
	}
	protected void deplacement(){}
	
	
	public String toString()
	{
		return "" + type.getSymbole() + ": " + type.getNom() + " " + couleur + this.position.toString();
	}
}
