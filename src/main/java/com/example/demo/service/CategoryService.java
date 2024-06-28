package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;

public interface CategoryService {
    Category add(Category category , int folderId);
    String addNew();
    CategoryDto findById(long id);
}
