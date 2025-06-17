package com.startkit.demo.controllers;

import com.startkit.demo.dao.ProductDao;
import com.startkit.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //endpoint would be /products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        Product product = productDao.getProductById(id);

        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    //delete products
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        Product product = productDao.getProductById(id);

        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        boolean successfullyDeleted = productDao.deleteProduct(id);

        if(successfullyDeleted){
            //204 NO CONTENT
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
