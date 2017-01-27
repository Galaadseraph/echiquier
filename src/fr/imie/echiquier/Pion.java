package fr.imie.echiquier;

import java.io.Serializable;

public class Pion extends Piece implements Serializable
{
	//Region Deplacement
	public void Deplacement(Coordonnees cible) throws EchiquierException
	{
		//Dans la même colonne
		if (this.position.getAbscisse() == cible.getAbscisse())
		{
			int difference = this.position.getOrdonne() - cible.getOrdonne();
			if (this.couleur == "Blanc")
			{
				if (difference==-1)
				{
					if (positionPossible(cible))
					{
						this.position = cible;
					}
				}
				else throw new EchiquierException("Deplacement invalide");
			}
			else //Pour les noirs
			{
				if (difference==1)
				{
					if (positionPossible(cible))
					{
						this.position = cible;
					}
				}
				else throw new EchiquierException("Deplacement invalide");
			}
		}
		else throw new EchiquierException("Deplacement invalide");
		// pas la même colonne
	}
	//EndRegion
	
	public Pion(Coordonnees position, String couleur)
	{
		this.position = position;
		this.couleur = couleur;
		this.type = CodePiece.Pion;
	}
}
