package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What is your name?");

        //Step 1 make the scanner
        Scanner scanner = new Scanner(System.in);
        //If we think the user will give us a string
        String userInput = scanner.nextLine();

        System.out.println("Hi there " + userInput);

        //lets ask them another question
        System.out.println("How old are you?");

        int userAge = scanner.nextInt();

        System.out.println("You are " + userAge + " years old.");

        //print format
        System.out.printf("Hi there %s you are %d years old", userInput, userAge);
    }
}