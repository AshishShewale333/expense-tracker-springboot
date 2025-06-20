package com.expensetrackerapi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetrackerapi.entity.Expense;
import com.expensetrackerapi.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	   @GetMapping("/expenses")
	    public ResponseEntity<List<Expense>> getExpenses(Pageable page) {
	        List<Expense> expenses = expenseService.getAllExpenses(page).toList();
	        return ResponseEntity.ok(expenses);
	    }

	    @GetMapping("/expenses/{id}")
	    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long id) {
	        Expense expense = expenseService.getExpenseById(id);
	        return ResponseEntity.ok(expense);
	    }

	    @DeleteMapping("/expenses")
	    public ResponseEntity<Void> deleteExpenseById(@RequestParam("id") Long id) {
	        expenseService.deleteExpenseById(id);
	        return ResponseEntity.noContent().build();  // 204 No Content
	    }

	    @PostMapping("/expenses")
	    public ResponseEntity<Expense> saveExpenseDetails(@Valid @RequestBody Expense expense) {
	        Expense savedExpense = expenseService.saveExpense(expense);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);  // 201 Created
	    }

	    @PutMapping("/expenses/{id}")
	    public ResponseEntity<Expense> updateExpenseDetails(@PathVariable("id") Long id,
	                                                        @RequestBody Expense expense) {
	        Expense updatedExpense = expenseService.updateExpense(id, expense);
	        return ResponseEntity.ok(updatedExpense);
	    }
	    
	    @GetMapping("/expenses/category")
	    public ResponseEntity<List<Expense>> filterByCategory(@RequestParam("category") String category,Pageable page) {
	        List<Expense> expenses = expenseService.filterByCategory(category, page);
	        return ResponseEntity.ok(expenses);
	    }
	    
	    @GetMapping("/expenses/name")
	    public ResponseEntity<List<Expense>> filterByName(@RequestParam("name") String name,Pageable page) {
	        List<Expense> expenses = expenseService.filterByName(name, page);
	        return ResponseEntity.ok(expenses);
	    }
	    
		@GetMapping("/expenses/date")
		public ResponseEntity<List<Expense>> filterByDate(@RequestParam(value = "startDate", required = false) Date startDate,
														  @RequestParam(value ="endDate", required = false) Date endDate,
														  Pageable page) {
			List<Expense> expenses = expenseService.filterByDate(startDate, endDate, page);
			return ResponseEntity.ok(expenses);
		}
}
