package fr.imie.echiquier;

public abstract class Piece 
{
	public Piece getPiece(Coordonnees c) throws EchiquierException
	{
		for (Piece p : Main.getPieces())
		{
			if (c.equals(p.position))
				return p;
		}
		throw new EchiquierException("Case vide");
	}
	
	protected CodePiece type;
	protected Coordonnees position;
	protected String couleur;
	
	protected boolean positionPossible(Coordonnees position)
	{
		Piece p;
		try
		{
			p = getPiece(position);
		}
		catch (EchiquierException e)
		{
			//Case vide...
			return true;
		}
		if (p.couleur == this.couleur)
			return false;
		else return true;
	}
	protected void deplacement(){}
	
	
	public String toString()
	{
		return "" + type.getSymbole() + ": " + type.getNom() + " " + couleur + this.position.toString();
	}
}
