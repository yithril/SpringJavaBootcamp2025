package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Financial Calculator Menu ---");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value Calculator (Compound Interest)");
            System.out.println("3. Present Value of Annuity Calculator");
            System.out.println("0. Exit");
            System.out.print("Please select a calculator (0-3): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        runMortgageCalculator(scanner);
                        break;
                    case 2:
                        runFutureValueCalculator(scanner);
                        break;
                    case 3:
                        runAnnuityCalculator(scanner);
                        break;
                    case 0:
                        System.out.println("Thank you for using the Financial Calculator!");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Invalid option. Please choose between 0 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void runMortgageCalculator(Scanner scanner) {
        try {
            System.out.print("Enter loan principal: ");
            BigDecimal principal = new BigDecimal(scanner.nextLine());

            System.out.print("Enter annual interest rate (e.g., 7.625 for 7.625%): ");
            BigDecimal annualRate = new BigDecimal(scanner.nextLine());

            System.out.print("Enter loan term in years: ");
            int years = Integer.parseInt(scanner.nextLine());

            BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12 * 100), 10, RoundingMode.HALF_UP);
            int totalPayments = years * 12;

            BigDecimal numerator = monthlyRate.multiply((BigDecimal.ONE.add(monthlyRate)).pow(totalPayments));
            BigDecimal denominator = (BigDecimal.ONE.add(monthlyRate)).pow(totalPayments).subtract(BigDecimal.ONE);
            BigDecimal monthlyPayment = principal.multiply(numerator.divide(denominator, 10, RoundingMode.HALF_UP));

            BigDecimal totalPaid = monthlyPayment.multiply(BigDecimal.valueOf(totalPayments));
            BigDecimal totalInterest = totalPaid.subtract(principal);

            System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
            System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    private static void runFutureValueCalculator(Scanner scanner) {
        try {
            System.out.print("Enter initial deposit: ");
            BigDecimal deposit = new BigDecimal(scanner.nextLine());

            System.out.print("Enter annual interest rate (e.g., 1.75 for 1.75%): ");
            BigDecimal annualRate = new BigDecimal(scanner.nextLine());

            System.out.print("Enter number of years: ");
            int years = Integer.parseInt(scanner.nextLine());

            BigDecimal dailyRate = annualRate.divide(BigDecimal.valueOf(365 * 100), 10, RoundingMode.HALF_UP);
            int totalDays = 365 * years;

            BigDecimal multiplier = BigDecimal.ONE.add(dailyRate).pow(totalDays);
            BigDecimal futureValue = deposit.multiply(multiplier);
            BigDecimal interestEarned = futureValue.subtract(deposit);

            System.out.printf("Future Value: $%.2f%n", futureValue);
            System.out.printf("Total Interest Earned: $%.2f%n", interestEarned);

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    private static void runAnnuityCalculator(Scanner scanner) {
        try {
            System.out.print("Enter monthly payout amount: ");
            BigDecimal payment = new BigDecimal(scanner.nextLine());

            System.out.print("Enter annual interest rate (e.g., 2.5 for 2.5%): ");
            BigDecimal annualRate = new BigDecimal(scanner.nextLine());

            System.out.print("Enter number of years: ");
            int years = Integer.parseInt(scanner.nextLine());

            int n = years * 12;
            BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12 * 100), 10, RoundingMode.HALF_UP);

            BigDecimal factor = BigDecimal.ONE.subtract(
                    BigDecimal.ONE.divide((BigDecimal.ONE.add(monthlyRate)).pow(n), 10, RoundingMode.HALF_UP)
            );
            BigDecimal presentValue = payment.multiply(factor).divide(monthlyRate, 10, RoundingMode.HALF_UP);

            System.out.printf("Present Value of Annuity: $%.2f%n", presentValue);

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }
}