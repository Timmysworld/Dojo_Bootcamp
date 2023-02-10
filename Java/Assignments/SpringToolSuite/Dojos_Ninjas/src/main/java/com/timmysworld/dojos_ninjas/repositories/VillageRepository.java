package com.timmysworld.dojos_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.dojos_ninjas.models.Village;

public interface VillageRepository extends CrudRepository<Village, Long> {
	List<Village>findAll();
}
