package com.projectspring.course.services;

import com.projectspring.course.entites.Category;
import com.projectspring.course.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    public List<Category> findAllCategories() { return this.categoryRepository.findAll(); }

    public Category findCategoryById(Long id) {
        Optional<Category> userObject = this.categoryRepository.findById(id);

        return userObject.orElse(null);
    }

}
