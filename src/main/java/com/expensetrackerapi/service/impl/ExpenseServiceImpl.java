package com.expensetrackerapi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.expensetrackerapi.entity.Expense;
import com.expensetrackerapi.exceptions.ResourceNotFoundException;
import com.expensetrackerapi.repository.ExpenseRepository;
import com.expensetrackerapi.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepo;

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return (Page<Expense>) expenseRepo.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}else {
			throw new ResourceNotFoundException("Expense not found for the id "+ id);
		}
	}

	@Override
	public void deleteExpenseById(Long id) {
		Expense expense = getExpenseById(id);
		expenseRepo.delete(expense);
	}

	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpense(Long id, Expense expense) {
		Expense existingExpense = getExpenseById(id);

		existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());

		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());

		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());

		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());

		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());

		return expenseRepo.save(existingExpense);
	}

	@Override
	public List<Expense> filterByCategory(String category, Pageable page) {
		return expenseRepo.findByCategory(category, page).toList();
	}

	@Override
	public List<Expense> filterByName(String name, Pageable page) {
		return expenseRepo.findByNameContaining(name, page).toList();
	}
	
	public List<Expense> filterByDate(Date startDate, Date endDate, Pageable page) {
		if (startDate == null) {
			startDate = new Date(0);
		}
		if (endDate == null) {
			endDate = new Date(System.currentTimeMillis());
		}
		return expenseRepo.findByDateBetween(startDate, endDate, page).toList();
	}


	

}
