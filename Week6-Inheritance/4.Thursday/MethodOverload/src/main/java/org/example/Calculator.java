package org.example;

public class Calculator {
    //an add method, takes in two numbers, returns their sum
    public double add(double a, double b){
        return a + b;
    }

    //method overloading
    //we can keep the name of the method, but change the number and type of arguments
    public double add(double a, double b, double c){
        return a + b + c;
    }

    //variable arguments - varargs
    //Allow any number of arguments
    //... => you say this as varargs
    public double multiply(double... nums){
        double startValue = 1;
        for(double num : nums){
            startValue *= num;
        }

        return startValue;
    }
}
