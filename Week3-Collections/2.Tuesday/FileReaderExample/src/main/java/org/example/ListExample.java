package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListExample {
    public static void main(String[] args) {
        //the List data structure
        //it is resizeable unlike an array
        //It DOES have indices, starting at 0
        List<String> groceryList = new ArrayList<>();

        //add to our list
        groceryList.add("Oranges");
        groceryList.add("Bananas");
        groceryList.add("Oreos");

        System.out.println(groceryList.get(0));

        groceryList.remove("Bananas");

        //loop through our list
        //enhanced loop
        for(String groceryItem : groceryList){
            System.out.println(groceryItem);
        }

        //how many things are in my list?
        System.out.println(groceryList.size());
    }
}
