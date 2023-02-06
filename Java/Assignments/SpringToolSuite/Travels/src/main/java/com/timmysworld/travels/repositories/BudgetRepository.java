package com.timmysworld.travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.travels.models.Budget;


public interface BudgetRepository extends CrudRepository<Budget, Long> {
	List<Budget> findAll();
	

}
