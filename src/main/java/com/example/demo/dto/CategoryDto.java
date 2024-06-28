package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private String categoryName;
    private String folder_path;
    private List<CategoryDto> children;
}
