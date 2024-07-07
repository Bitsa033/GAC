package com.services.admin_nation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedictionController {
	
	@GetMapping("page_vehicule")
	public String page_home(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:findAll_data_vehicules_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@GetMapping("page_add_vehicule")
	public String page_add_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:add_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@GetMapping("page_get_vehicule")
	public String page_get_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:get_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@GetMapping("page_edit_vehicule")
	public String page_edit_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:find_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@GetMapping("page_delete_vehicule")
	public String page_delete_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:delete_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@PostMapping("page_save_vehicule")
	public String page_save_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:save_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@PostMapping("page_update_vehicule")
	public String page_update_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:update_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}
	
	@PostMapping("page_destroy_vehicule")
	public String page_destroy_region(HttpServletRequest http) {
		if (http.isUserInRole("ADMIN")) {
			return "redirect:destroy_data_vehicule_admin";
		}
		
		return "redirect:findAll_data_vehicules_user";
	}

}
