package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(){
        this.products = new ArrayList<>();
    }

    // TODO: Add a product to the cart
    // This method should take a Product object and add it to the list
    public void addProductToCart(Product product){
        // Your code here
    }

    // TODO: Remove a product from the cart using its SKU
    // Steps:
    // 1. Loop through the list of products
    // 2. Check if any product's SKU matches the given SKU
    // 3. If found, remove it from the list (AFTER the loop to avoid issues while looping)
    public void removeProduct(String sku){
        // Your code here
    }

    // TODO: Calculate and return the total cost of items in the cart
    // Hint: Loop through the list and add up the price of each product
    public double getCartTotal(){
        // Your code here
        return 0.0; // placeholder
    }

    // TODO: Display all items currently in the cart
    // Print SKU, name, price, and department of each product in a nice format
    public void displayItems(){
        // Your code here
    }

    public List<Product> getCartItems(){
        return products;
    }
}
