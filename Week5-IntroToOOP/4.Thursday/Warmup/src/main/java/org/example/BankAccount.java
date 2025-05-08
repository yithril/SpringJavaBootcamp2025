package org.example;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private static final double OVERDRAFT_LIMIT = -200;  // Can’t go below -200
    private static final double OVERDRAFT_FEE = 20;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        double potentialBalance = balance - amount;

        if (potentialBalance >= 0) {
            balance = potentialBalance;
            return true;
        } else if (potentialBalance >= OVERDRAFT_LIMIT) {
            applyOverdraftFee(potentialBalance);
            return true;
        } else {
            return false;
        }
    }

    private void applyOverdraftFee(double potentialBalance) {
        balance = potentialBalance - OVERDRAFT_FEE;
    }
}
