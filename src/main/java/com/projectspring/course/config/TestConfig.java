package com.projectspring.course.config;

import com.projectspring.course.entites.User;
import com.projectspring.course.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final IUserRepository userRepository;

    @Autowired
    public TestConfig(IUserRepository userRepository) { this.userRepository = userRepository; }


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null,"Maria Brown", "maria@gmail.com", "988888888","123456");
        User user2 = new User(null,"Alex Green","alex@gmail.com","977777777","123456");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
