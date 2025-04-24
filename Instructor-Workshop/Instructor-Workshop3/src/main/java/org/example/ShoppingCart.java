package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(){
        this.products = new ArrayList<>();
    }

    //TODO add product to cart method
    public void addProductToCart(Product product){
        throw new UnsupportedOperationException();
    }

    //TODO remove product from cart method
    //You will need the SKU of the product you want to remove
    //Loop through the list of products
    //Check to see if the SKU matches
    //Get that Product, then use the remove method AFTER the loop
    public void removeProduct(String sku){
        throw new UnsupportedOperationException();
    }

    //TODO get cart total method
    public double getCartTotal(){
        throw new UnsupportedOperationException();
    }
}
