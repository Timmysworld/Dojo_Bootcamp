package com.timmysworld.dojos_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timmysworld.dojos_ninjas.models.Village;
import com.timmysworld.dojos_ninjas.repositories.VillageRepository;

@Service
public class VillageService {
	@Autowired
	private VillageRepository repo;
	
	public VillageService(VillageRepository repo) {
		this.repo = repo;
	}
	
	//ALL VILLAGES 
	public List<Village> allVillages(){
		return repo.findAll();
	}
	
	//CREATE VILLAGE
	public void CreateOrUpdate(Village village) {
		repo.save(village);
	}
	
	//ONE VILLAGE by ID
	public Village findVillage(Long id) {
		Optional<Village> optionalVillage = repo.findById(id);
		if(optionalVillage.isPresent()) {
			return optionalVillage.get();
		}else {
			return null;
		}
	}
	
	
	
}
