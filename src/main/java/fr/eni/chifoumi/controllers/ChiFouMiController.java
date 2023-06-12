package fr.eni.chifoumi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.chifoumi.bo.Partie;
import fr.eni.chifoumi.services.ChiFouMiService;

@Controller
public class ChiFouMiController {
	private ChiFouMiService service;

	@Autowired
	public ChiFouMiController(ChiFouMiService service) {
		this.service = service;
	}

	@GetMapping({"/" , "/chifoumi"})
	public String afficherAccueil() {
		return "chifoumi";
	}
	
	@RequestMapping(path="/jouer", method = {RequestMethod.GET, RequestMethod.POST})
	public String jouer(@RequestParam int choixJoueur, Model monModel) {
		Partie partie = service.jouer(choixJoueur);
		
		//System.out.println("partie = " + partie.toString());
		System.out.println("partie = " + partie);
				
		String ecran = "resultatVue" ;
		
		monModel.addAttribute("choixJoueur", partie.getChoixJoueur());
		monModel.addAttribute("choixServeur", partie.getChoixServeur());
		if(partie.getResultat()==Partie.EGALITE) {
			monModel.addAttribute("resultat", "EGALITE");
			return ecran;
		}else if(partie.getResultat()==Partie.GAGNE){
			monModel.addAttribute("resultat", "GAGNE");
			return ecran;
		}else {
			monModel.addAttribute("resultat", "PERDU");
			return ecran;
		}
	}
	
	
}
