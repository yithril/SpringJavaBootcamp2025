package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> allProducts = FileLoader.readFile();
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Welcome to the store! Choose an option:");
            System.out.println("1. View all products");
            System.out.println("2. Search by SKU");
            System.out.println("3. Search by price range");
            System.out.println("4. Search by name");
            System.out.println("5. Add to cart");
            System.out.println("6. Remove from cart");
            System.out.println("7. View cart");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Call method to display all products
                    break;
                case 2:
                    // Prompt for SKU and call method to search product by SKU
                    break;
                case 3:
                    // Prompt for min and max price and call method to filter products
                    break;
                case 4:
                    // Prompt for name and call method to search products by name
                    break;
                case 5:
                    // Prompt for SKU, find product, and add to cart
                    //Remember to use the shopping cart we made above!
                    break;
                case 6:
                    // Prompt for SKU to get the product, remove from cart
                    break;
                case 7:
                    // Display cart items. Remember, use the shopping cart above!
                    break;
                case 8:
                    // Display total and thank the user
                    checkOut(cart, scanner);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void checkOut(ShoppingCart cart, Scanner scanner){
        //Display how much the cart total
        //Ask them to pay and how much they are paying
        //If they don't pay enough, tell them its not enough and try again
        //else they paid equal to or more, so tell them their change
        //print out what items they bought, how much they paid, and chane
        //clear the cart
    }

    //This method could be re-used over and over again if you play
    //your cards right!
    public static void displayProducts(List<Product> products) {
        // TODO: Loop through products
        // Print SKU, Name, Price, and Department nicely
    }

    public static Product findBySku(List<Product> products, String sku) {
        // TODO: Loop through products
        // If sku matches, return the product
        return null; // if not found
    }

    // Returns a list of products with names that contain the search string (case-insensitive)
    public static List<Product> searchByName(List<Product> products, String name) {
        List<Product> matches = new ArrayList<>();
        // TODO: Loop through products
        // If product name contains the search string, add to matches
        return matches;
    }

    // Returns a list of products within the given price range (inclusive)
    public static List<Product> filterByPriceRange(List<Product> products,
                                                   double min, double max) {
        List<Product> matches = new ArrayList<>();
        // TODO: Loop through products
        // If product price is between min and max, add to matches
        return matches;
    }
}