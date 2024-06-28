package com.example.demo.service.impl;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category add(Category category , int folderId) {
        Category category1 = categoryRepository.findByCategoryName(category.getCategoryName());
        if (category1 == null ) {
            return categoryRepository.save(Category
                            .builder()
                            .categoryName(category.getCategoryName())
                            .parent(category)
                            .name(category.getName())
                            .children(null)
                            .folder_path(String.valueOf(folderId))
                            .description(category.getDescription())
                    .build());
        }else {
            return categoryRepository.save(Category
                    .builder()
                            .parent(category)
                            .name(category.getName())
                            .categoryName(category.getCategoryName())
                            .children((List<Category>) category)
                            .folder_path(folderId +"," + category1.getId())
                            .description(category.getDescription())
                    .build());
        }
    }
    @Override
    public String addNew(){
        Category parentCategory = Category.builder()
                .name("Parent Category")
                .description("This is the parent category")
                .categoryName("Parent")
                .folder_path("1")
                .build();
         categoryRepository.save(parentCategory);
        Category parentCategory1 = Category.builder()
                .name("Parent Category")
                .description("This is the parent category")
                .categoryName("Parent")
                .folder_path("1" + ","+parentCategory.getId())
                .parent(parentCategory)
                .build();
         categoryRepository.save(parentCategory1);
// Tạo một Category con
        Category childCategory = Category.builder()
                .name("Child Category")
                .description("This is a child category")
                .categoryName("Child")
                .folder_path("1"+ "," + parentCategory.getId())  // Ví dụ về đường dẫn thư mục cho Category con
                .parent(parentCategory)
                .build();
        categoryRepository.save(childCategory);



        List<Category> children = new ArrayList<>();
        children.add(parentCategory1);
        children.add(childCategory);
        parentCategory.setChildren(children);

        categoryRepository.save(parentCategory);

// Category child in child
        Category child = Category.builder()
                .name("child Category")
                .description("This is the parent  child Category ")
                .categoryName("Parent")
                .folder_path("1" + ","+childCategory.getId())
                .parent(childCategory)
                .build();
        categoryRepository.save(child);
        Category child1 = Category.builder()
                .name("child 1 Category")
                .description("This is the parent  child Category ")
                .categoryName("Parent")
                .folder_path("1" + ","+ childCategory.getId())
                .parent(childCategory)
                .build();
        categoryRepository.save(child1);

        List<Category> children1 = new ArrayList<>();
        children1.add(child);
        children1.add(child1);
        childCategory.setChildren(children1);


        return "Ok";
    }

    @Override
    public CategoryDto findById(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
        Category category = optionalCategory.get();

        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .categoryName(category.getCategoryName())
                .folder_path(category.getFolder_path())
                .build();

        List<Category> children = category.getChildren();
        List<CategoryDto> childrenDto = new ArrayList<>();
        List<CategoryDto> grandchildrenDto = new ArrayList<>();


        for (Category child : children) {
            CategoryDto childDto = createCategoryDto(child);

            List<Category> grandchildren = child.getChildren();

            for (Category grandchild : grandchildren) {
                CategoryDto grandchildDto = createCategoryDto(grandchild);
                grandchildrenDto.add(grandchildDto);
            }

            childDto.setChildren(grandchildrenDto);
            childrenDto.add(childDto);
        }

        categoryDto.setChildren(childrenDto);

        return categoryDto;
    }

    // Helper method to create CategoryDto from Category entity
    private CategoryDto createCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .categoryName(category.getCategoryName())
                .folder_path(category.getFolder_path())
                .build();
    }


}
