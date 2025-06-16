package com.startkit.demo.controllers;

import com.startkit.demo.dao.ProductDao;
import com.startkit.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductDao productDao;

    //Dependency Injection
    @Autowired
    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        var products = productDao.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
