package org.example;

import java.time.LocalDate;

public class DateMathExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Go back 7 days
        LocalDate sevenDaysAgo = today.minusDays(7);
        System.out.println("7 days ago: " + sevenDaysAgo);

        // Go back 1 month
        LocalDate oneMonthAgo = today.minusMonths(1);
        System.out.println("1 month ago: " + oneMonthAgo);

        // Go back 1 year
        LocalDate oneYearAgo = today.minusYears(1);
        System.out.println("1 year ago: " + oneYearAgo);
    }
}
