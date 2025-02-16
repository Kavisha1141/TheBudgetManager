package model;

import java.util.ArrayList;

// creates an account with name, balance, list of earnings, list of expenses and savings in dollars
public class Account {

    // fields
    private String name;
    private int balance;
    private ArrayList<Transaction> listOfEarnings;
    private ArrayList<Transaction> listOfExpenses;
    private int savings;

    // constructs an account with name, balance and savings set to 0 and empty list
    // of earnings, and
    // expenses in dollars
    public Account(String name) {
        balance = 0;
        listOfEarnings = new ArrayList<>();
        listOfExpenses = new ArrayList<>();
        savings = 0;
        this.name = name;
    }

    // returns the account balance
    public int getBalance() {
        return -1;
    }

    // returns the account name
    public String getName() {
        return "";
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

    // REQURIES: balance - amount >= 0; day <= 31; month <= 12; year <= current year; amount > 0
    // MODIFIES: this
    // EFFECTS: adds an expense transaction with given info, withdraws amount from
    // balance, and adds it to the
    // list of Expenses
    public void addExpense(int amount, int day, int month, int year, String title) {

    }

    // REQUIRES: day <= 31; month <= 12; year <= current year; day/month/year less; amount > 0
    // than or equal to current date
    // MODIFIES: this
    // EFFECTS: adds an earning and adds it to the list of Earnings, adds amount to
    // balance
    public void addEarning(int amount, int day, int month, int year, String title) {

    }

    // REQUIRES: savings + amount <= target; amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount to savings
    public void saveAmount(int amount) {

    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: sets a target for savings
    public void setSavingTarget(int amount) {

    }

}
