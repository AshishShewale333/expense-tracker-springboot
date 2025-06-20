package com.expensetrackerapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.expensetrackerapi.entity.Expense;
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
			throw new RuntimeException("Expense not found for the id"+ id);
		}
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
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
	

}
