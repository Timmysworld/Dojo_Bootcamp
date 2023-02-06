package com.timmysworld.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timmysworld.travels.models.Budget;
import com.timmysworld.travels.repositories.BudgetRepository;

@Service
public class BudgetService {
	@Autowired
	private BudgetRepository repository;
	
	public BudgetService(BudgetRepository repository) {
		this.repository = repository;
	}
	
	//ALL EXPENSES
	public List<Budget>allExpenses(){
		return repository.findAll();
	}
	
    //CREATE: ADD EXPENSES or UPDATE EXPENSE
    //when using api add return and change from void 
    public void createorUpdate(Budget budget) {
         repository.save(budget);
    }
    
    //READ: ONE EXPENSE BY ID
    public Budget findExpense(Long id) {
    	Optional<Budget> optionalBudget = repository.findById(id);
    	if (optionalBudget.isPresent()) {
    		return optionalBudget.get();
    	}else {
    		return null;
    	}
    }

	//DELETE: DELETE EXPENSE
	public void deleteExpense(Long id) {
			repository.deleteById(id);
		
	}
    

}
