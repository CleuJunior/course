package com.projectspring.course.services;

import com.projectspring.course.entites.User;
import com.projectspring.course.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> findAllUsers() { return userRepository.findAll(); }

    public User findUserById(Long id) {
        Optional<User> userObject = userRepository.findById(id);

        return userObject.orElse(null);
    }

}
