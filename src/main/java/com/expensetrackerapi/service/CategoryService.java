package com.expensetrackerapi.service;



import java.util.List;

import com.expensetrackerapi.dto.CategoryDTO;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    void deleteCategory(String categoryId);
}