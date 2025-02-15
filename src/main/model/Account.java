package model;

import java.util.ArrayList;

public class Account {

    // fields
    private int balance;
    private ArrayList<Transaction> listOfEarnings;
    private ArrayList<Transaction> listOfExpenses;
    private int savings;

    // constructs an account with balance set to 0 and empty list of earnings, savings and
    // expenses in dollars
    public Account() {
        balance = 0;
        listOfEarnings = new ArrayList<>();
        listOfExpenses = new ArrayList<>();
        savings = 0;
    }

    // returns the account balance
    public int getBalance() {
        return -1;
    }

    // returns the list of earnings
    public ArrayList<Transaction> getListOfEarnings() {
        return null;
    }

    // returns the list of expenses
    public ArrayList<Transaction> getListOfExpenses() {
        return null;
    }

    // returns the account savings
    public int getSavings() {
        return -1;
    }

    // returns total money earned in dollars
    public int getTotalEarnings() {
        return -1;
    }

    // returns total money spend in dollars
    public int getTotalExpenses() {
        return -1;
    }

    // MODIFIES: this
    // EFFECTS: adds an expense, withdraws amount from balance, and adds it to the
    // list of Expenses
    public void addExpense() {

    }

    // MODIFIES: this
    // EFFECTS: adds an earning and adds it to the list of Earnings, adds amount to
    // balance
    public void addEarning() {

    }

    // REQUIRES: savings + amount <= target
    // MODIFIES: this
    // EFFECTS: adds amount to savings
    public void saveAmount() {

    }

    // MODIFIES: this
    // EFFECTS: sets a target for savings
    public void setSavingTarget() {

    }

}
