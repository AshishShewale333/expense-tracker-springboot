package com.expensetrackerapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expensetrackerapi.dto.ExpenseDTO;
import com.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	
	List<ExpenseDTO> getAllExpenses(Pageable page);
	
	ExpenseDTO getExpenseById(String expenseId);
	
	void deleteExpenseById(String expenseId);

	ExpenseDTO saveExpenseDetails(ExpenseDTO expenseDTO);
	
	ExpenseDTO updateExpenseDetails(String expenseId, ExpenseDTO expenseDTO);
	
	List<ExpenseDTO> readByCategory(String category, Pageable page);
	
	List<ExpenseDTO> readByName(String keyword, Pageable page);
	
	List<ExpenseDTO> readByDate(Date startDate, Date endDate, Pageable page);
}