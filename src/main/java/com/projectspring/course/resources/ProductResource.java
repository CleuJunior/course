package com.projectspring.course.resources;

import com.projectspring.course.entites.Product;
import com.projectspring.course.entites.User;
import com.projectspring.course.services.ProductService;
import com.projectspring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) { this.productService = productService; }


    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> listOfAllProducts = this.productService.findAllProducts();

        return ResponseEntity.ok()
                .body(listOfAllProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product userObject = this.productService.findProductById(id);

        if(Objects.isNull(userObject)) { return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok()
                .body(userObject);
    }
}
