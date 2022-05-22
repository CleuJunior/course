package com.projectspring.course.resources;

import com.projectspring.course.entites.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @GetMapping
    public ResponseEntity<User> findAll() {
        return ResponseEntity.ok()
                .body(new User(
                        1L,
                        "Cleonildo Junior",
                        "cleonildo.junior@outlook.com",
                        "21 99 99909129",
                        "passStrong"
                ));
    }
}
