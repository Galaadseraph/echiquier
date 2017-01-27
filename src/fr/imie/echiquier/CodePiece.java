package fr.imie.echiquier;

public enum CodePiece 
{
	Roi('K',"Roi", 10),
	Dame('Q',"Reine",10),
	Fou('B',"Fou",3),
	Cavalier('C', "Cavalier", 3),
	Tour('R', "Tour", 5),
	Pion('S',"Pion",1);
	
	private char symbole;
	private String nom;
	private int value;
	
	public char getSymbole(){return symbole;}
	public String getNom(){return nom;}
	public int getValue(){return value;}
	
	CodePiece(char code, String nom, int value)
	{
		this.symbole = code;
		this.nom = nom;
		this.value = value;
	}
}
