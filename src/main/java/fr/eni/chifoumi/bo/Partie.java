package fr.eni.chifoumi.bo;

public class Partie {
	
	public static final int PIERRE = 0;
	public static final int FEUILLE = 1;
	public static final int CISEAUX = 2;
	
	public static final int GAGNE = 0;
	public static final int PERDU = 1;
	public static final int EGALITE = 2;


	private int choixJoueur;
	private int choixServeur;
	private int resultat;
	
	public Partie() {
	}
	
	
	public Partie(int choixJoueur) {
		this.choixJoueur = choixJoueur;
	}




	public int getChoixJoueur() {
		return choixJoueur;
	}
	public void setChoixJoueur(int choixJoueur) {
		this.choixJoueur = choixJoueur;
	}
	public int getChoixServeur() {
		return choixServeur;
	}
	public void setChoixServeur(int choixServeur) {
		this.choixServeur = choixServeur;
	}
	public int getResultat() {
		return resultat;
	}
	public void setResultat(int resultat) {
		this.resultat = resultat;
	}
	@Override
	public String toString() {
		return "Partie [choixJoueur=" + choixJoueur + ", choixServeur=" + choixServeur + ", resultat=" + resultat + "]";
	}
	
	
}
