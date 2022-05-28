package com.projectspring.course.repositories;

import com.projectspring.course.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
