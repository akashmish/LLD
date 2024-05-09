package com.restproject.store.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproject.store.entity.Product;
import com.restproject.store.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController  
@RequestMapping("/api") 
public class ProductController {
    
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public ResponseEntity<?> postMethodName(@RequestBody Product product) {
        Product save = productRepository.save(product);
        return ResponseEntity.ok(save);
    } 
    

    @GetMapping("/product")
    public ResponseEntity<?> listAllProducts() {
        return ResponseEntity.ok(this.productRepository.findAll());  
    }
}
