package com.timmysworld.attendanceApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.attendanceApp.models.TheGroup;

public interface GroupRepository extends CrudRepository<TheGroup, Long> {
	List<TheGroup> findAll();
	Optional<TheGroup> findByName(String name);
	
	
}
