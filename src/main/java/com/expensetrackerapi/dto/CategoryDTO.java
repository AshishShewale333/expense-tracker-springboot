package com.expensetrackerapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    private String categoryId;
    private String name;
    private String description;
    private String categoryIcon;
    private Timestamp updatedAt;
    private Timestamp createdAt;
    private UserDTO user;
}
