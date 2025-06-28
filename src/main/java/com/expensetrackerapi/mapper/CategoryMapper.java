package com.expensetrackerapi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.expensetrackerapi.dto.CategoryDTO;
import com.expensetrackerapi.entity.CategoryEntity;
import com.expensetrackerapi.io.CategoryRequest;
import com.expensetrackerapi.io.CategoryResponse;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

   CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryEntity mapToCategoryEntity(CategoryDTO categoryDTO);
    CategoryDTO mapToCategoryDTO(CategoryEntity entity);
    @Mapping(target = "categoryIcon", source = "icon")
    CategoryDTO mapToCategoryDTO(CategoryRequest request);
    CategoryResponse mapToCategoryResponse(CategoryDTO categoryDTO);
}