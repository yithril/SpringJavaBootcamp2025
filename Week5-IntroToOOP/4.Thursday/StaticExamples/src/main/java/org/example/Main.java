package org.example;

public class Main {
    public static void main(String[] args) {
        //we've used static before
        System.out.println(Math.PI);

        //The math class is an example of a static class
        //In a static class, everything is static
        //utility class is another word for it

        //To use a static method, use the class
        MathUtility.add(10, 25);
    }

    public static void sayHello(){
        System.out.println("Hi there!");
    }
}