package com.expensetrackerapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expensetrackerapi.entity.Expense;


public interface ExpenseService {

	Page<Expense> getAllExpenses(Pageable page);
	
	Expense getExpenseById(Long id);
	
	void deleteExpenseById(Long id);
	
	Expense saveExpense(Expense expense);

	Expense updateExpense(Long id,Expense expense);
	
	List<Expense> filterByCategory(String category,Pageable page);
	
	List<Expense> filterByName(String name,Pageable page);
	
	List<Expense> filterByDate(Date startDate,Date endDate, Pageable page);
	
}
