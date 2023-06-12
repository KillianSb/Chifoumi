package fr.eni.chifoumi.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import fr.eni.chifoumi.bo.Partie;

@Service
public class ChiFouMiService {
	private Random random;

	public ChiFouMiService() {
		random = new Random();
	}

	public Partie jouer(int choixJoueur) {
		Partie partie = new Partie(choixJoueur);

		// Déterminer le choix du serveur
		int choixServeur = random.nextInt(3);
		partie.setChoixServeur(choixServeur);

		// Déterminer le gagnant
		if (choixJoueur == choixServeur) {
			partie.setResultat(Partie.EGALITE);
			return partie;
		}

		if ((choixJoueur == Partie.PIERRE && choixServeur == Partie.CISEAUX) 
				|| (choixJoueur == Partie.FEUILLE && choixServeur == Partie.PIERRE)
				|| (choixJoueur == Partie.CISEAUX && choixServeur == Partie.FEUILLE)) {
			partie.setResultat(Partie.GAGNE);
			return partie;
		}

		partie.setResultat(Partie.PERDU);
		return partie;

	}

}
