package com.projectspring.course.services;

import com.projectspring.course.entites.Category;
import com.projectspring.course.entites.Product;
import com.projectspring.course.repositories.ICategoryRepository;
import com.projectspring.course.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) { this.productRepository = productRepository; }

    public List<Product> findAllProducts() { return this.productRepository.findAll(); }

    public Product findProductById(Long id) {
        Optional<Product> userObject = this.productRepository.findById(id);

        return userObject.orElse(null);
    }

}
