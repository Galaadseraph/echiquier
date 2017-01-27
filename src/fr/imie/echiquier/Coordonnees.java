package fr.imie.echiquier;

public class Coordonnees 
{
	private int abscisse;
	private int ordonnee;
	
	public int getAbscisse(){return abscisse;}
	public int getOrdonne(){return ordonnee;}
	
	public Coordonnees(int x, int y)
	{
		this.abscisse = x;
		this.ordonnee= y;
	}
	
	public boolean equals(Coordonnees cible)
	{
		if (cible.abscisse == this.abscisse)
		{
			if (cible.ordonnee == this.ordonnee)
				return true;
			else return false;
		}
		else return false;
	}
	
	public String toString()
	{
		String result = "";
		switch (abscisse)
		{
		case 0:
			result +="A";
			break;
		case 1:
			result +="B";
			break;
		case 2:
			result +="C";
			break;
		case 3:
			result +="D";
			break;
		case 4:
			result +="E";
			break;
		case 5:
			result +="F";
			break;
		case 6:
			result +="G";
			break;
		case 7:
			result +="H";
			break;
		default:
			result += "invalide";
			break;
		}
		if (result.contains("invalide"))
			return result;
		else
		{
			if ((this.ordonnee >=0)&&(this.ordonnee <8))
			{
				return result += this.ordonnee;
			}
			else return "invalide";
		}
	}
}
