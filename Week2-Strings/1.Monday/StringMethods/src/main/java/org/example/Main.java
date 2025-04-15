package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //method - basically functionality
        String s1 = "ABC";

        s1 = s1.toLowerCase();
        //toUpperCase() is the opposite

        System.out.println(s1);

        String s2 = "Jonathan   ";

        System.out.println(s2.length());

        s2 = s2.trim();

        System.out.println(s2.length());

        //instantiate
        //On line 25 I instantiate a Scanner
        Scanner scanner = new Scanner(System.in);
    }
}