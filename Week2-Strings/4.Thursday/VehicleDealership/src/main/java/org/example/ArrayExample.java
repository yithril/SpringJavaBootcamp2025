package org.example;

public class ArrayExample {
    public static void main(String[] args) {
        //apartment building mailboxes
        //square brackets
        //indexes: 0, 1, 2, 3, 4
        int[] mailboxes = new int[5];

        //the mail lady comes and she wants to put the mail
        //in box number 2
        mailboxes[2] = 25;
        mailboxes[4] = 100;

        //This will cause an exception
        //mailboxes[10] = 1000;

        //start an array with values
        //instead of line by line, let's start the array with
        //all the values
        String[] fruits = { "Banana", "Orange", "Strawberry", "Grapes" };

        //loop through an array
        //to loop through an array use a for loop
        //start -> index 0, end size of the array - 1
        for(int i = 0; i < fruits.length; i++){
            System.out.println(fruits[i]);
        }

        //enhanced for loop
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }
}
