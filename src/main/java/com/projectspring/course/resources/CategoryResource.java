package com.projectspring.course.resources;

import com.projectspring.course.entites.Category;
import com.projectspring.course.entites.Order;
import com.projectspring.course.services.CategoryService;
import com.projectspring.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService categoryServiceService;

    @Autowired
    public CategoryResource(CategoryService categoryServiceService) { this.categoryServiceService = categoryServiceService; }


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> listOfAllCategories = this.categoryServiceService.findAllCategories();

        return ResponseEntity.ok()
                .body(listOfAllCategories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findUserById(@PathVariable Long id) {
        Category categoryObject = this.categoryServiceService.findCategoryById(id);

        if(Objects.isNull(categoryObject)) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok()
                .body(categoryObject);
    }
}
