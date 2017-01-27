package fr.imie.echiquier;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main implements Serializable
{
	private static List<Piece> Pieces = new ArrayList<Piece>();
	
	public static List<Piece>getPieces()
	{
		return Pieces;
	}
	
	public void ajouterPiece(Piece p)
	{
		getPieces().add(p);
	}
	
	public void afficher()
	{
	}
	
	private int sauvegarder()
	{
		return 0;
	}
	private int charger()
	{
		return 0;
	}
	public static void main(String args[])
	{
		
	}
}
