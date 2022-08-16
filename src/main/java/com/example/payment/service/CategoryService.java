package com.example.payment.service;

import com.example.payment.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> listCategories();
    void createCategory(Category category);
    Category readCategory(String categoryName);
    Optional<Category> readCategory(Integer categoryId);
    void updateCategory(Integer categoryID, Category newCategory);
}
