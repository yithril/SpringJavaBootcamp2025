package org.example;

import java.util.List;

public class ProductRepository {
    //filtering functions
    //search by SKU, price, etc.
    //get all products

    public List<Product> getAllProducts(){
        List<Product> products = FileLoader.readFile();

        return products;
    }
}
