package com.projectspring.course.services;

import com.projectspring.course.entites.User;
import com.projectspring.course.repositories.IUserRepository;
import com.projectspring.course.services.exceptions.DatabaseExcpetion;
import com.projectspring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

        return userObject.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) { return userRepository.save(obj); }

    public void delete(Long id) {

        try { userRepository.deleteById(id); }
        catch (EmptyResultDataAccessException e) { throw new ResourceNotFoundException(id); }
        catch (DataIntegrityViolationException e) { throw new DatabaseExcpetion(e.getMessage()); }
    }

    public User update(Long id, User user) {
        User userEntity = this.userRepository.getReferenceById(id);
        updateData(userEntity, user);

        return userRepository.save(userEntity);
    }

    private void updateData(User userEntity, User userObject) {
        userEntity.setName(userObject.getName());
        userEntity.setEmail(userObject.getEmail());
        userEntity.setPhone(userObject.getPhone());

    }

}
