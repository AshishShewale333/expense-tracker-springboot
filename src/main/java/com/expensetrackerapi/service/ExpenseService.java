package com.expensetrackerapi.service;

import java.util.List;

import com.expensetrackerapi.entity.Expense;


public interface ExpenseService {

	List<Expense> getAllExpenses();
	
	Expense getExpenseById(Long id);
	
	void deleteExpenseById(Long id);
	
	Expense saveExpense(Expense expense);

	Expense updateExpense(Long id,Expense expense);
	
}
