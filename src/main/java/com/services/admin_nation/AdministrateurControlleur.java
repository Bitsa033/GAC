package com.services.admin_nation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdministrateurControlleur {
	
	@Autowired
	private VehiculeService sv;
	@Autowired
	private SearchService ss;
	AdministrationCamerounApplication adminCam= new AdministrationCamerounApplication();
	
	
	@GetMapping("findAll_data_vehicules_admin")
	String findAll_data_vehicules_admin(Model model) {
		
		List<Vehicule> vehicules=sv.displayData();
		String nb_r=ss.nb_vehicule();
		Search search= new Search();
		model.addAttribute("vehicules", vehicules);
		model.addAttribute("vehicule", search);
		model.addAttribute("nb", nb_r);
		
		return "administrateur/vehicules/findAll_data";
	}
	
	@GetMapping("print_data_vehicules_admin")
	String print_data_vehicules_admin(Model model) {
		
		List<Vehicule> vehicules=sv.displayData();
		String nb_r=ss.nb_vehicule();
		model.addAttribute("vehicules", vehicules);
		model.addAttribute("nb", nb_r);
		
		return "administrateur/vehicules/print_data";
	}
	
	@GetMapping("add_data_vehicule_admin")
	public String  add_data_vehicule_admin(Model model) {
		Vehicule vehicule= new Vehicule();
		model.addAttribute("vehicule", vehicule);
		return "administrateur/vehicules/add_data";
		
	}
	
	@GetMapping("find_data_vehicule_admin")
	public String  find_data_vehicule_admin(Model model) {
		Vehicule vehicule= new Vehicule();
		model.addAttribute("vehicule", vehicule);
		return "administrateur/vehicules/find_data";
		
	}
	
	@PostMapping("edit_data_vehicule_admin")
	public String  edit_data_vehicule_admin(Model model,@ModelAttribute("vehicule") Vehicule region) {
		Optional<Vehicule> r= sv.findDataById(region.getId());
		String r_id=r.get().getId();
		model.addAttribute("vehicule", r);
		model.addAttribute("vehicule_id", r_id);
		return "administrateur/vehicules/edit_data";
		
	}
	
	@PostMapping("save_data_vehicule_admin")
	RedirectView save_data_vehicule_admin(@ModelAttribute("vehicule") Vehicule vehicule) throws IOException{
		
		String id=adminCam.genererID();
		Vehicule r= new Vehicule(id,vehicule.getMatricule(),vehicule.getMarque(),vehicule.getProprietaire());
		sv.saveData(r);
		return new RedirectView("findAll_data_vehicules_admin");
	}
	
	@PostMapping("update_data_vehicule_admin")
	public RedirectView update_data_vehicule_admin(@ModelAttribute("vehicule") Vehicule vehicule ) {
		
		String id=vehicule.getId();
		String mat=vehicule.getMatricule();
		String marque=vehicule.getMarque();
		sv.updateData(id, mat, marque);
		
		return new RedirectView("findAll_data_vehicules_admin");
		
	}
	
	@GetMapping("delete_data_vehicule_admin")
	public String  delete_data_vehicule_admin(Model model) {
		Vehicule vehicule= new Vehicule();
		model.addAttribute("vehicule", vehicule);
		return "administrateur/vehicules/delete_data";
		
	}
	
	@PostMapping("destroy_data_vehicule_admin")
	public RedirectView destroy_data_vehicule_admin(@ModelAttribute("vehicule") Vehicule vehicule) {
		String r_id=vehicule.getId();
		sv.deleteData(r_id);
		return new RedirectView("findAll_data_vehicules_admin");
		
	}
	
	// Méthodes pour les recherches
	
	@GetMapping("recherche_par_vehicule_admin")
	String recherche_par_vehicule_admin(Model model, @ModelAttribute("vehicule") Search search) {
		String key_name=search.getKeyName();
		List<Vehicule> vehiculesSearch=ss.search_vehicule(key_name);
		model.addAttribute("vehiculesS", vehiculesSearch);
		
		return "administrateur/recherches/recherche_par_vehicule";
	}
	

}
