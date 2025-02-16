package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAccount {

    Account testAccount;

    @BeforeEach
    void runBefore() {
        testAccount = new Account("Kavisha", "123456");
    }

    @Test
    void testConstructor() {
        assertEquals("Kavisha", testAccount.getName());
        assertEquals(0, testAccount.getBalance());
        assertEquals(0, testAccount.getSavings());
        assertEquals("123456", testAccount.getPassword());
        assertTrue(testAccount.getListOfEarnings().isEmpty());
        assertTrue(testAccount.getListOfExpenses().isEmpty());
    }

    @Test
    void testAddOneEarning() {
        assertEquals(0, testAccount.getBalance());
        testAccount.addEarning(100, 23, 3, 2024, "birthday gift from dad");
        assertEquals(100, testAccount.getBalance());
        assertEquals(1, testAccount.getListOfEarnings().size());
        assertEquals(100, testAccount.getListOfEarnings().get(0).getAmount());
        assertEquals("birthday gift from dad", testAccount.getListOfEarnings().get(0).getTitle());
        assertEquals(23, testAccount.getListOfEarnings().get(0).getDay());
        assertEquals(3, testAccount.getListOfEarnings().get(0).getMonth());
        assertEquals(2024, testAccount.getListOfEarnings().get(0).getYear());
    }

    @Test
    void testAddTwoEarnings() {
        assertEquals(0, testAccount.getBalance());
        testAccount.addEarning(100, 23, 3, 2024, "birthday gift from dad");
        assertEquals(100, testAccount.getBalance());
        assertEquals(1, testAccount.getListOfEarnings().size());
        assertEquals(100, testAccount.getListOfEarnings().get(0).getAmount());
        assertEquals("birthday gift from dad", testAccount.getListOfEarnings().get(0).getTitle());
        assertEquals(23, testAccount.getListOfEarnings().get(0).getDay());
        assertEquals(3, testAccount.getListOfEarnings().get(0).getMonth());
        assertEquals(2024, testAccount.getListOfEarnings().get(0).getYear());

        assertEquals(100, testAccount.getBalance());
        testAccount.addEarning(5000, 12, 2, 2024, "scholarship");
        assertEquals(5100, testAccount.getBalance());
        assertEquals(2, testAccount.getListOfEarnings().size());
        assertEquals(5000, testAccount.getListOfEarnings().get(1).getAmount());
        assertEquals("scholarship", testAccount.getListOfEarnings().get(1).getTitle());
        assertEquals(12, testAccount.getListOfEarnings().get(1).getDay());
        assertEquals(2, testAccount.getListOfEarnings().get(1).getMonth());
        assertEquals(2024, testAccount.getListOfEarnings().get(1).getYear());
    }

    @Test
    void testAddOneExpense() {
        assertEquals(0, testAccount.getBalance());
        testAccount.addEarning(100, 23, 3, 2024, "birthday gift from dad");
        assertEquals(100, testAccount.getBalance());
        assertEquals(1, testAccount.getListOfEarnings().size());
        assertEquals(100, testAccount.getListOfEarnings().get(0).getAmount());
        assertEquals("birthday gift from dad", testAccount.getListOfEarnings().get(0).getTitle());
        assertEquals(23, testAccount.getListOfEarnings().get(0).getDay());
        assertEquals(3, testAccount.getListOfEarnings().get(0).getMonth());
        assertEquals(2024, testAccount.getListOfEarnings().get(0).getYear());

        assertEquals(100, testAccount.getBalance());
        testAccount.addExpense(50, 12, 2, 2024, "paid phone bill");
        assertEquals(50, testAccount.getBalance());
        assertEquals(1, testAccount.getListOfExpenses().size());
        assertEquals(50, testAccount.getListOfExpenses().get(0).getAmount());
        assertEquals("paid phone bill", testAccount.getListOfExpenses().get(0).getTitle());
        assertEquals(12, testAccount.getListOfExpenses().get(0).getDay());
        assertEquals(2, testAccount.getListOfExpenses().get(0).getMonth());
        assertEquals(2024, testAccount.getListOfExpenses().get(0).getYear());
    }

    @Test
    void testAddTwoExpenses() {
        assertEquals(0, testAccount.getBalance());
        testAccount.addEarning(100, 23, 3, 2024, "birthday gift from dad");
        assertEquals(100, testAccount.getBalance());
        assertEquals(1, testAccount.getListOfEarnings().size());
        assertEquals(100, testAccount.getListOfEarnings().get(0).getAmount());
        assertEquals("birthday gift from dad", testAccount.getListOfEarnings().get(0).getTitle());

        assertEquals(100, testAccount.getBalance());
        testAccount.addExpense(50, 12, 2, 2024, "paid phone bill");
        assertEquals(50, testAccount.getBalance());
        assertEquals(1, testAccount.getListOfExpenses().size());
        assertEquals(50, testAccount.getListOfExpenses().get(0).getAmount());
        assertEquals("paid phone bill", testAccount.getListOfExpenses().get(0).getTitle());

        assertEquals(50, testAccount.getBalance());
        testAccount.addExpense(50, 9, 1, 2019, "monthly bus pass");
        assertEquals(0, testAccount.getBalance());
        assertEquals(2, testAccount.getListOfExpenses().size());
        assertEquals(50, testAccount.getListOfExpenses().get(1).getAmount());
        assertEquals("monthly bus pass", testAccount.getListOfExpenses().get(1).getTitle());
        assertEquals(9, testAccount.getListOfExpenses().get(1).getDay());
        assertEquals(1, testAccount.getListOfExpenses().get(1).getMonth());
        assertEquals(2019, testAccount.getListOfExpenses().get(1).getYear());
    }

    @Test
    void testSaveAmount() {
        assertEquals(0, testAccount.getBalance());
        testAccount.addEarning(110, 23, 3, 2024, "birthday gift from dad");
        assertEquals(110, testAccount.getBalance());
        testAccount.setSavingTarget(100);
        assertEquals(100, testAccount.getSavingsTarget());

        testAccount.saveAmount(55);
        assertEquals(55, testAccount.getBalance());
        assertEquals(55, testAccount.getSavings());
    }

    @Test
    void testTotalExpenses() {
        assertEquals(0, testAccount.getBalance());
        testAccount.addEarning(100, 23, 3, 2024, "birthday gift from dad");
        testAccount.addEarning(60, 3, 3, 2021, "gift");
        assertEquals(160, testAccount.getBalance());
        testAccount.addExpense(60, 3, 3, 2021, "paid for car gas");
        testAccount.addExpense(10, 3, 3, 2021, "bought hand cream");

        assertEquals(160, testAccount.getTotalEarnings());
        assertEquals(70, testAccount.getTotalExpenses());
    }

}
