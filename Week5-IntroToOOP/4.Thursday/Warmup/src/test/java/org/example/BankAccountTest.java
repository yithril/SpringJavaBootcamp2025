package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void testDepositPositiveAmount() {
        BankAccount account = new BankAccount("Alice", 100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdrawWithinBalance() {
        BankAccount account = new BankAccount("Charlie", 100);
        boolean success = account.withdraw(50);
        assertTrue(success);
        assertEquals(50, account.getBalance());
    }

    @Test
    void testWithdrawIntoOverdraftButAboveLimit() {
        BankAccount account = new BankAccount("Dana", 100);
        boolean success = account.withdraw(250);  // Will go to -150, apply overdraft fee
        assertTrue(success);
        assertEquals(-170, account.getBalance());  // -150 - 20 fee
    }

    @Test
    void testWithdrawBeyondOverdraftLimitFails() {
        BankAccount account = new BankAccount("Eve", 100);
        boolean success = account.withdraw(350);  // Would go to -250 → should fail
        assertFalse(success);
        assertEquals(100, account.getBalance());  // Balance unchanged
    }

    @Test
    void testGetAccountHolder() {
        BankAccount account = new BankAccount("Frank", 200);
        assertEquals("Frank", account.getAccountHolder());
    }

    //Extra Credit
    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount("Bob", 100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
    }
}