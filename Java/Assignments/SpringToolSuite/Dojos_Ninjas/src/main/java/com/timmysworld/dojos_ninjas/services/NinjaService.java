package com.timmysworld.dojos_ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timmysworld.dojos_ninjas.models.Ninja;
import com.timmysworld.dojos_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	//ALL NINJAS
	public List<Ninja>allNinjas(){
		return repo.findAll();
	}
	
	//CREATE NINJA
	public void CreateOrUpdate(Ninja ninja) {
		repo.save(ninja);
	}

}
