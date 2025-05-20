package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        //We use BigDecimal for financial stuff
        //We cannot use + - * / < > ==

        //Two ways to create a BigDecimal, either is cool
        BigDecimal firstNumber = new BigDecimal(".1");
        BigDecimal secondNumber = BigDecimal.valueOf(.2);

        //math operations
        var sum = firstNumber.add(secondNumber);
        var difference = firstNumber.subtract(secondNumber);
        var product = firstNumber.multiply(secondNumber);
        var quotient = firstNumber.divide(secondNumber);

        //how to compare two big decimals
        //again cannot use < > == !=
        //use the compareTo method
        //1 means greater than, -1 means less than, 0 means equal
        int compareResult = secondNumber.compareTo(firstNumber);
        System.out.println(compareResult);

        System.out.println(sum);

        var weirdNumber = new BigDecimal("10.7852839203893");

        BigDecimal roundedValue = weirdNumber.setScale(2, RoundingMode.HALF_UP);

        System.out.println(roundedValue);
    }
}