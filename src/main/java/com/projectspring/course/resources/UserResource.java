package com.projectspring.course.resources;

import com.projectspring.course.entites.User;
import com.projectspring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) { this.userService = userService; }


    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> listOfAllUsers = userService.findAllUsers();

        return ResponseEntity.ok()
                .body(listOfAllUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User userObject = userService.findUserById(id);

        if(Objects.isNull(userObject)) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok()
                .body(userObject);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).body(obj);
    }
}
