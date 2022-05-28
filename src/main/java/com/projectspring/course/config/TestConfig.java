package com.projectspring.course.config;

import com.projectspring.course.entites.Category;
import com.projectspring.course.entites.Order;
import com.projectspring.course.entites.Product;
import com.projectspring.course.entites.User;
import com.projectspring.course.entites.enums.OrderStatus;
import com.projectspring.course.repositories.ICategoryRepository;
import com.projectspring.course.repositories.IOrderRepository;
import com.projectspring.course.repositories.IProductRepository;
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

    private final IProductRepository productRepository;

    @Autowired
    public TestConfig(
            IUserRepository userRepository,
            IOrderRepository orderRepository,
            ICategoryRepository categoryRepository,
            IProductRepository productRepository) {

        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings","Lorem ipsum dolor sit amet,consectetur.",90.5,"");
        Product p2 = new Product(null,"Smart TV","Nulla eu imperdiet purus.Maecenas ante.",2198.0,"");
        Product p3 = new Product(null, "Macbook Pro","Nam eleifend maximus tortor,at mollis.",1250.0,"");
        Product p4 = new Product(null, "PC Gamer","Donec aliquet odio ac rhoncus cursus.",1200.0,"");
        Product p5 = new Product(null, "Rails for Dummies","Cras fringilla convallis sem vel faucibus.",100.99,"");


        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        this.productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        User user1 = new User(null,"Maria Brown", "maria@gmail.com", "988888888","123456");
        User user2 = new User(null,"Alex Green","alex@gmail.com","977777777","123456");

        this.userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user2,  OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2020-08-20T19:53:07Z"), user1,  OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.parse("2018-09-13T19:53:07Z"), user1,  OrderStatus.WAITING_PAYMENT);

        this.orderRepository.saveAll(Arrays.asList(order1, order2, order3));



    }
}
