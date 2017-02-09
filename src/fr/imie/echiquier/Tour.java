package fr.imie.echiquier;

public class Tour extends Piece
{
	//Region Deplacement
		public void deplacement(Coordonnees cible) throws EchiquierException
		{
			//Dans la même colonne
			if (this.position.getAbscisse() == cible.getAbscisse())
			{
				int difference = this.position.getOrdonne() - cible.getOrdonne();
				if (difference==0)
				{
					if (positionPossible(cible))
					{
						this.position = cible;
					}
				}
				else throw new EchiquierException("Deplacement invalide");
			}
			else // pas la même colonne
			{
				int difference = this.position.getAbscisse() - cible.getAbscisse();
				if (difference==0)
				{
					if (positionPossible(cible))
					{
						this.position = cible;
					}
				}
				else throw new EchiquierException("Deplacement invalide");
			}
		}
		//EndRegion
		
		public Tour(Coordonnees position, String couleur)
		{
			this.position = position;
			this.couleur = couleur;
			this.type = CodePiece.Tour;
		}
}
