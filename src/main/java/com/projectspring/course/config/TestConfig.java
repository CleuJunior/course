package com.projectspring.course.config;

import com.projectspring.course.entites.Category;
import com.projectspring.course.entites.Order;
import com.projectspring.course.entites.User;
import com.projectspring.course.entites.enums.OrderStatus;
import com.projectspring.course.repositories.ICategoryRepository;
import com.projectspring.course.repositories.IOrderRepository;
import com.projectspring.course.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final IUserRepository userRepository;
    private final IOrderRepository orderRepository;

    private final ICategoryRepository categoryRepository;

    @Autowired
    public TestConfig(IUserRepository userRepository, IOrderRepository orderRepository, ICategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User user1 = new User(null,"Maria Brown", "maria@gmail.com", "988888888","123456");
        User user2 = new User(null,"Alex Green","alex@gmail.com","977777777","123456");

        this.userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user2,  OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2020-08-20T19:53:07Z"), user1,  OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.parse("2018-09-13T19:53:07Z"), user1,  OrderStatus.WAITING_PAYMENT);

        this.orderRepository.saveAll(Arrays.asList(order1, order2, order3));



    }
}
