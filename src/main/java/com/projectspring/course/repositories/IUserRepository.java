package com.projectspring.course.repositories;

import com.projectspring.course.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
