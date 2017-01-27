package fr.imie.echiquier;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main
{
	//Region Singleton
	private static List<Piece> Pieces = new ArrayList<Piece>();
	public static List<Piece>getPieces()
	{
		if (Pieces == null)
		{
			charger();
		}
		return Pieces;
	}
	public static void ajouterPiece(Piece p){getPieces().add(p);}
	public static Piece getPiece(Coordonnees c) throws EchiquierException
	{
		for (Piece p : getPieces())
		{
			if (c.equals(p.position))
				return p;
		}
		throw new EchiquierException("Case vide");
	}
	public static int getPoints(String couleur)
	{
		int result = 0; //50 points à l'origine
		for (Piece p : getPieces())
		{
			if (p.getCouleur()==couleur)
				result += (p.getType().getValue());
		}
		return result;
	}
	//EndRegion
	
	//Region Affichage
	private static void intersect(){System.out.println("---+---+---+---+---+---+---+---+---|");}
	private static void header(){System.out.println("---+-------------------------------+");}
	private static void footer(){System.out.println("   [ A | B | C | D | E | F | G | H |");}
	private static void coordonnee(int i){System.out.print(" "+ (++i) + " |");}
	private static void casevide(){System.out.print("   |");}
	private static void casePiece(Piece p){System.out.print(" " +p.getType().getSymbole() +" |");}
	public static void afficher()
	{
		header();
		for (int i =7; i >=0;i--)//ordonnees
		{
			coordonnee(i);
			for (int j = 0;j<8;j++)//Abscisse
			{
				Piece p = null;
				boolean isSet = false;
				Coordonnees c = new Coordonnees(j,i);
				try
				{
					p = getPiece(c);
					isSet = true;
				}
				catch (EchiquierException e)
				{
					p = null;
					isSet = false;
				}
				finally
				{
					if (isSet)
					{
						casePiece(p);
					}
					else casevide();
				}
			}
			System.out.println();
			intersect();
		}
		footer();
		/* ---+-------------------------------+
		 *  8 |   |   |   |   |   |   |   |   |
		 * ---+-------------------------------|
		 *  7 |   |   |   |   |   |   |   |   |
		 * ---|---|---|---|---|---|---|---|---|
		 *  6 |   |   |   |   |   |   |   |   |
		 * ---|---|---|---|---|---|---|---|---|
		 *  5 |   |   |   |   |   |   |   |   |
		 * ---|---|---|---|---|---|---|---|---|
		 *  4 |   |   |   |   |   |   |   |   |
		 * ---|---|---|---|---|---|---|---|---|
		 *  3 |   |   |   |   |   |   |   |   |
		 * ---|---|---|---|---|---|---|---|---|
		 *  2 |   |   |   |   |   |   |   |   |
		 * ---+---+---+---+---+---+---+---+---|
		 *  1 |   |   |   |   |   |   |   |   |
		 * ---+---+---+---+---+---+---+---+---+
		 *    [ A | B | C | D | E | F | G | H |
		 * 
		 */
	}
	//EndRegion
	
	//Region IO
	private static int sauvegarder()
	{
		try
		{
			//ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("C:\\Dev\\Formes Geometriques\\test.txt"))));
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Echiquier.txt"))));
			oos.writeByte(getPieces().size());
			for (Piece p : getPieces())
			{
				oos.writeObject(p);
			}
			oos.flush();
			oos.close();
			//ois.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
	}
	private static int charger()
	{
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Echiquier.txt"))));
			//ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("C:\\Dev\\Formes Geometriques\\test.txt"))));
			int length = ois.readByte();
			int i = 0;
			while (i++ <length)
				getPieces().add((Piece)ois.readObject());
				//oos.writeObject(f);
			//oos.close();
			ois.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return 0;
	}
	//EndRegion
	
	public static void main(String args[])
	{
		//getPieces();
		charger();
		//ajouterPiece(new Pion(new Coordonnees(0,1),"Blanc"));
		afficher();
		//sauvegarder();
	}
}
