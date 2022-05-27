package com.projectspring.course.repositories;

import com.projectspring.course.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
