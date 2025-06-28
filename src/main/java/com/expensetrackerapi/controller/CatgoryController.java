package com.expensetrackerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.expensetrackerapi.dto.CategoryDTO;
import com.expensetrackerapi.io.CategoryRequest;
import com.expensetrackerapi.io.CategoryResponse;
import com.expensetrackerapi.mapper.CategoryMapper;
import com.expensetrackerapi.service.CategoryService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CatgoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryDTO categoryDTO = categoryMapper.mapToCategoryDTO(categoryRequest);
        categoryDTO = categoryService.saveCategory(categoryDTO);
        return categoryMapper.mapToCategoryResponse(categoryDTO);
    }

 
    @GetMapping
    public List<CategoryResponse> readCategories() {
        List<CategoryDTO> listOfCategories = categoryService.getAllCategories();
        return listOfCategories.stream().map(categoryDTO -> categoryMapper.mapToCategoryResponse(categoryDTO)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
