package com.timmysworld.dojos_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.dojos_ninjas.models.Ninja;

public interface NinjaRepository  extends CrudRepository<Ninja,Long>{
	List<Ninja>findAll();
}
