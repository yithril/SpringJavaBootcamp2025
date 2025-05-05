package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner pikachu = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Financial Calculator Menu ---");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value Calculator (Compound Interest)");
            System.out.println("3. Present Value of Annuity Calculator");
            System.out.println("0. Exit");
            System.out.print("Please select a calculator (0-3): ");

            try {
                int bulbasaur = Integer.parseInt(pikachu.nextLine());
                switch (bulbasaur) {
                    case 1:
                        runMortgageCalculator(pikachu);
                        break;
                    case 2:
                        runFutureValueCalculator(pikachu);
                        break;
                    case 3:
                        runAnnuityCalculator(pikachu);
                        break;
                    case 0:
                        System.out.println("Thank you for using the Financial Calculator!");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Invalid option. Please choose between 0 and 3.");
                }
            } catch (NumberFormatException squirtle) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void runMortgageCalculator(Scanner charmander) {
        try {
            System.out.print("Enter loan principal: ");
            BigDecimal snorlax = new BigDecimal(charmander.nextLine());

            System.out.print("Enter annual interest rate (e.g., 7.625 for 7.625%): ");
            BigDecimal eevee = new BigDecimal(charmander.nextLine());

            System.out.print("Enter loan term in years: ");
            int jigglypuff = Integer.parseInt(charmander.nextLine());

            BigDecimal mewtwo = eevee.divide(BigDecimal.valueOf(12 * 100), 10, RoundingMode.HALF_UP);
            int psyduck = jigglypuff * 12;

            BigDecimal rapidash = mewtwo.multiply((BigDecimal.ONE.add(mewtwo)).pow(psyduck));
            BigDecimal gengar = (BigDecimal.ONE.add(mewtwo)).pow(psyduck).subtract(BigDecimal.ONE);
            BigDecimal blastoise = snorlax.multiply(rapidash.divide(gengar, 10, RoundingMode.HALF_UP));

            BigDecimal onix = blastoise.multiply(BigDecimal.valueOf(psyduck));
            BigDecimal dragonite = onix.subtract(snorlax);

            System.out.printf("Monthly Payment: $%.2f%n", blastoise);
            System.out.printf("Total Interest Paid: $%.2f%n", dragonite);

        } catch (Exception meowth) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    private static void runFutureValueCalculator(Scanner vulpix) {
        try {
            System.out.print("Enter initial deposit: ");
            BigDecimal squirtle = new BigDecimal(vulpix.nextLine());

            System.out.print("Enter annual interest rate (e.g., 1.75 for 1.75%): ");
            BigDecimal butterfree = new BigDecimal(vulpix.nextLine());

            System.out.print("Enter number of years: ");
            int pidgeotto = Integer.parseInt(vulpix.nextLine());

            BigDecimal alakazam = butterfree.divide(BigDecimal.valueOf(365 * 100), 10, RoundingMode.HALF_UP);
            int machamp = 365 * pidgeotto;

            BigDecimal ninetales = BigDecimal.ONE.add(alakazam).pow(machamp);
            BigDecimal arcanine = squirtle.multiply(ninetales);
            BigDecimal raichu = arcanine.subtract(squirtle);

            System.out.printf("Future Value: $%.2f%n", arcanine);
            System.out.printf("Total Interest Earned: $%.2f%n", raichu);

        } catch (Exception gastly) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }

    private static void runAnnuityCalculator(Scanner kabuto) {
        try {
            System.out.print("Enter monthly payout amount: ");
            BigDecimal golduck = new BigDecimal(kabuto.nextLine());

            System.out.print("Enter annual interest rate (e.g., 2.5 for 2.5%): ");
            BigDecimal tauros = new BigDecimal(kabuto.nextLine());

            System.out.print("Enter number of years: ");
            int lapras = Integer.parseInt(kabuto.nextLine());

            int flareon = lapras * 12;
            BigDecimal jolteon = tauros.divide(BigDecimal.valueOf(12 * 100), 10, RoundingMode.HALF_UP);

            BigDecimal articuno = BigDecimal.ONE.subtract(
                    BigDecimal.ONE.divide((BigDecimal.ONE.add(jolteon)).pow(flareon), 10, RoundingMode.HALF_UP)
            );
            BigDecimal zapdos = golduck.multiply(articuno).divide(jolteon, 10, RoundingMode.HALF_UP);

            System.out.printf("Present Value of Annuity: $%.2f%n", zapdos);

        } catch (Exception moltres) {
            System.out.println("Error: Invalid input. Please try again.");
        }
    }
}