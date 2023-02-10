package com.timmysworld.dojos_ninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.timmysworld.dojos_ninjas.models.Ninja;
import com.timmysworld.dojos_ninjas.models.Village;
import com.timmysworld.dojos_ninjas.services.NinjaService;
import com.timmysworld.dojos_ninjas.services.VillageService;

@Controller
public class MainController {
	private final VillageService service;
	private final NinjaService Nservice;
	
	public MainController(VillageService service, NinjaService Nservice) {
		this.service = service;
		this.Nservice = Nservice;
	}
	
	@GetMapping("/villages")
	//TO SHOW ON SAME PAGE COMBINE THE @MODELATTRIBUTE("") WITHIN ()
	public String AllVillages(@ModelAttribute("village")Village village, Model model, 
			// add the @ModelAttribute of ninja 
			@ModelAttribute("ninja")Ninja ninja) {
		model.addAttribute("villages", service.allVillages());
		System.out.println(service.allVillages());
		// NEED TO ADD MODEL.ADDATTRIBUTE FOR NINJAS(model class) IF WANTING TO SHOW ON THE SAME PAGE.
		model.addAttribute("ninjas",Nservice.allNinjas()); 
		return "index.jsp";
	}
	
	@PostMapping("/villages/create")
	public String addVillage(@ModelAttribute("village")Village village, 
			BindingResult result) {
		service.CreateOrUpdate(village);
		return "redirect:/villages";
	}
//	###############################################################
	        // FOR NINJA MODEL 
	
	@PostMapping("/ninjas/create")
	public String addNinja(@ModelAttribute("ninja")Ninja ninja,
			BindingResult result) {
		Nservice.CreateOrUpdate(ninja);
		return "redirect:/villages";
	}
// ################################################################
		// TO VIEW THE VILLAGES NINJAS
	
	@GetMapping("/villages/view/{id}")
	public String showVillage(
			@PathVariable("id")Long id,
			Model model
			) {
		model.addAttribute("village", service.findVillage(id));
		return "show.jsp";
		
	}	
}
