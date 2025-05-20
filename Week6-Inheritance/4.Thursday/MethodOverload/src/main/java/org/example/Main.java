package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double sum = calculator.add(10, 20, 30);
        double sum2 = calculator.add(5, 2);

        System.out.println(sum);

        double product = calculator.multiply(10, 5, 6, 2, 8, 10);
    }
}