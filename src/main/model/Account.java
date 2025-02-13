package model;

import java.util.ArrayList;

public class Account {

    private int balance;
    private ArrayList<Earnings> listOfEarnings;
    private ArrayList<Expense> listOfExpenses;

    // constructs an account with balance set to 0 and empty list of earnings and expenses
    public Account() {
        balance = 0;
        listOfEarnings = new ArrayList<>();
        listOfExpenses = new ArrayList<>();
    }

    // returns the account balance
    public int getBalance() {
        return -1;
    }

    // returns the list of earnings
    public ArrayList<Earnings> getListOfEarnings() {
        return null;
    }

    // returns the list of expenses
    public ArrayList<Expense> getListOfExpenses() {
        return null;
    } 

}
