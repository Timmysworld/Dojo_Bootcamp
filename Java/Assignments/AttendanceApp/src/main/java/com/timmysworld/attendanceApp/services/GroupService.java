package com.timmysworld.attendanceApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.timmysworld.attendanceApp.models.TheGroup;
import com.timmysworld.attendanceApp.repositories.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository gRepo;
	
	public List<TheGroup> allGroups(){
		return gRepo.findAll();
	}
	
	//CREATE: 
	public TheGroup creategroup(TheGroup newGroup, BindingResult result) {
		Optional<TheGroup> g = gRepo.findByName(newGroup.getName());
		
		if(g.isPresent()) {
			result.rejectValue("name", "match", "That Group name already exist.");
		}
		if(result.hasErrors()) {
			return null;
		}
		return gRepo.save(newGroup);
	}
	
	//READ:
	public TheGroup findGroup(Long id) {
		Optional<TheGroup> g = gRepo.findById(id);
		if(g.isPresent()) {
			return g.get();
		}else {
			return null;
		}
	}
	
	//DELETE:
	public void deleteGroup(Long id) {
		Optional<TheGroup> g = gRepo.findById(id);
		if(g.isPresent()) {
			gRepo.deleteById(id);
		}
		
	}
	
}
