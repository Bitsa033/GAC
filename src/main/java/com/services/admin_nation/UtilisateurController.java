package com.services.admin_nation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilisateurController {
	
	@Autowired
	private VehiculeService sv;
	@Autowired
	private SearchService ss;
	
	AdministrationCamerounApplication adminCam= new AdministrationCamerounApplication();
	
	@GetMapping("findAll_data_vehicules_user")
	public String findAll_data_regions_user(Model model) {
		List<Vehicule> vehicules=sv.displayData();
		
		String nb_r=ss.nb_vehicule();
		Search search= new Search();
		model.addAttribute("vehicule", search);
		model.addAttribute("vehicules", vehicules);
		model.addAttribute("nb", nb_r);
		return "utilisateur/vehicules/findAll_data";
	}
	
	@GetMapping("print_data_vehicules_user")
	public String print_data_regions_user(Model model) {
		List<Vehicule> vehicules=sv.displayData();
		String nb_r=ss.nb_vehicule();
		model.addAttribute("vehicules", vehicules);
		model.addAttribute("nb", nb_r);
		return "utilisateur/vehicules/print_data";
	}
	
	@GetMapping("recherche_par_vehicule_user")
	String recherche_par_vehicule_admin(Model model, @ModelAttribute("vehicule") Search search) {
		String key_name=search.getKeyName();
		List<Vehicule> vehiculesSearch=ss.search_vehicule(key_name);
		model.addAttribute("vehiculesS", vehiculesSearch);
		
		
		
		return "utilisateur/recherches/recherche_par_vehicule";
	}
	
}
