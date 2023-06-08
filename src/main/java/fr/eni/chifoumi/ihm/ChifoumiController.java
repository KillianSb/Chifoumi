package fr.eni.chifoumi.ihm;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChifoumiController {
	
	@RequestMapping({"/chifoumi", "/"})
	public String jeux() {
		System.out.println("Dans la page jeux");
		return "chifoumi";
	}
	
	@RequestMapping("/jouer")
	@Scope("prototype")
	public String jouer(@RequestParam int choixJoueur) {
		Random random = new Random();
		int choixServer;
		choixServer = random.nextInt(3);
		
		System.out.println("nombre : "+ choixServer);
		System.out.println("Mon choix : "+ choixJoueur);
		System.out.println("Dans la page jouer");
		
		if (choixServer == choixJoueur) {
			System.out.println("egalite : "+ choixServer + " " + choixJoueur);
			return "egalite";
		}
		
		if ((choixServer == 0 && choixJoueur == 1) || (choixServer == 1 && choixJoueur == 2) || (choixServer == 3 && choixJoueur == 0)) {
			System.out.println("gagne : "+ choixServer + " " + choixJoueur);
			return "gagne";
		}
		
		return "perdu";
	}
}
