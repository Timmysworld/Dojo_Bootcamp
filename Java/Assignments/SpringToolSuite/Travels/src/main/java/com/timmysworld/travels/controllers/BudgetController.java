package com.timmysworld.travels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.timmysworld.travels.models.Budget;
import com.timmysworld.travels.services.BudgetService;

@Controller
public class BudgetController{
	private final BudgetService service;
	
	public BudgetController(BudgetService service) {
		this.service = service;
	}
	
	@GetMapping("/dashboard")
	public String AllExpenses(Model model) {
		model.addAttribute("budget", service.allExpenses());
		return "dashboard.jsp";
	}
	
	@GetMapping("/expenses/add")
	public String addExpense(@ModelAttribute("budget")Budget budget) {
		return "add_Expense.jsp";
	}
	
	@PostMapping("/expenses/add")
	public String addExpense(
			//Checks for a VALID instance of our MODEL and then creates that instance of a book
			@Valid @ModelAttribute("budget")Budget budget,
			BindingResult result
			) {
		
		//Errors Handling:
		if(result.hasErrors()) {
			return "add_Expense.jsp";
		} else {
			service.createorUpdate(budget);
		}
		System.out.println(budget);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpenses(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("budget", service.findExpense(id));
		return "edit.jsp";
	}
		
	
	@PostMapping("/expenses/edit/{id}")
	public String updateExpense(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("budget") Budget budget,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			budget.setId(id);
			service.createorUpdate(budget);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/expenses/details/{id}")
	public String expenseDetails(
			@PathVariable("id")Long id,
			Model model
			) {
		model.addAttribute("budget", service.findExpense(id));
		return "expense_details.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String destroy(
			@PathVariable Long id
			) {
		service.deleteExpense(id);
		return "redirect:/dashboard";
	}
	
	

	

}
