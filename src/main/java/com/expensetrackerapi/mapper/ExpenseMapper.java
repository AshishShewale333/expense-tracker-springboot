package com.expensetrackerapi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.expensetrackerapi.dto.ExpenseDTO;
import com.expensetrackerapi.entity.Expense;
import com.expensetrackerapi.io.ExpenseRequest;
import com.expensetrackerapi.io.ExpenseResponse;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper( ExpenseMapper.class );

    @Mapping(target = "category", source = "expenseDTO.categoryDTO")
    ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO);

    ExpenseDTO mapToExpenseDTO(ExpenseRequest request);

    Expense mapToExpenseEntity(ExpenseDTO expenseDTO);

    @Mapping(target = "categoryDTO", source = "expense.category")
    ExpenseDTO mapToExpenseDTO(Expense expense);
}