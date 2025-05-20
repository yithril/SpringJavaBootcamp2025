package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Phone", 599.99),
                new Product("Tablet", 399.99),
                new Product("Monitor", 299.99),
                new Product("Keyboard", 49.99),
                new Product("Mouse", 25.99),
                new Product("Printer", 149.99),
                new Product("Camera", 699.99),
                new Product("Headphones", 199.99),
                new Product("Smartwatch", 249.99),
                new Product("Speaker", 89.99),
                new Product("Router", 129.99),
                new Product("External Hard Drive", 79.99),
                new Product("Microphone", 99.99)
        );

        //loop through the products and print their information
        //declarative style
        //products.stream().forEach(x -> System.out.println(x.toString()));

        //Filtering products
        List<Product> overFiveHundred = products.stream()
                .filter(product -> product.getPrice() > 500).toList();

        //overFiveHundred.stream().forEach(x -> System.out.println(x.toString()));

        //more than one condition in filter
        var betweenTwoAndFourHundred = products.stream()
                .filter(product -> product.getPrice() > 200 && product.getPrice() < 400)
                .toList();

        //betweenTwoAndFourHundred.stream().forEach(x -> System.out.println(x.toString()));

        //print the products in alphabetical order according to name
        products.stream().map(Product::getName)
                .sorted().toList().forEach(name -> System.out.println(name));

        //average price of products in the collection
        var average = products.stream().mapToDouble(Product::getPrice).average().orElse(0);

        //minimum number and maximum number
        //what is the price of the most expensive item?
        var maxPrice = products.stream().mapToDouble(Product::getPrice).max().orElse(0);
    }
}