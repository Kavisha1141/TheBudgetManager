package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// creates an account with name, balance, list of earnings, list of expenses and savings in dollars
public class Account implements Writable {

    // fields
    private String name;
    private String password;
    private int balance;
    private ArrayList<Transaction> listOfEarnings;
    private ArrayList<Transaction> listOfExpenses;
    private int savings;
    private int savingsTarget;

    // constructs an account with name, balance and savings set to 0 and empty list
    // of earnings, and
    // expenses in dollars
    public Account(String name, String password) {
        balance = 0;
        listOfEarnings = new ArrayList<>();
        listOfExpenses = new ArrayList<>();
        this.password = password;
        savings = 0;
        savingsTarget = 0;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    // returns the account balance
    public int getBalance() {
        return balance;
    }

    // returns the account name
    public String getName() {
        return name;
    }

    // returns the list of earnings
    public ArrayList<Transaction> getListOfEarnings() {
        return listOfEarnings;
    }

    // returns the list of expenses
    public ArrayList<Transaction> getListOfExpenses() {
        return listOfExpenses;
    }

    // returns the account savings
    public int getSavings() {
        return savings;
    }

    // returns the account savings target
    public int getSavingsTarget() {
        return savingsTarget;
    }

    // returns total money earned in dollars
    public int getTotalEarnings() {
        int totalEarnings = 0;
        for (Transaction nextEarning : listOfEarnings) {
            totalEarnings += nextEarning.getAmount();
        }
        return totalEarnings;

    }

    // returns total money spend in dollars
    public int getTotalExpenses() {
        int totalExpenses = 0;
        for (Transaction nextExpense : listOfExpenses) {
            totalExpenses += nextExpense.getAmount();
        }
        return totalExpenses;
    }

    // REQURIES: balance - amount >= 0; day <= 31; month <= 12; year <= current
    // year; amount > 0
    // MODIFIES: this
    // EFFECTS: adds an expense transaction with given info, withdraws amount from
    // balance, and adds it to the
    // list of Expenses
    public void addExpense(int amount, int day, int month, int year, String title) {
        Transaction newExpense = new Transaction(amount, day, month, year, title);
        listOfExpenses.add(newExpense);
        balance -= amount;
    }

    // REQUIRES: day <= 31; month <= 12; year <= current year; day/month/year less;
    // amount > 0
    // than or equal to current date
    // MODIFIES: this
    // EFFECTS: adds an earning and adds it to the list of Earnings, adds amount to
    // balance
    public void addEarning(int amount, int day, int month, int year, String title) {
        Transaction newEarning = new Transaction(amount, day, month, year, title);
        listOfEarnings.add(newEarning);
        balance += amount;
    }

    // REQUIRES: savings + amount <= target; amount > 0; balance - savings >= 0
    // MODIFIES: this
    // EFFECTS: adds amount to savings; reduces balance by amount
    public void saveAmount(int amount) {
        savings += amount;
        balance -= amount;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: sets a target for savings
    public void setSavingTarget(int amount) {
        savingsTarget = amount;
    }

    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Account name", name);
        json.put("Account password", password);
        json.put("Balance", balance);
        json.put("List of Earnings", listToJson(listOfEarnings));
        json.put("List of Expenses", listToJson(listOfExpenses));
        json.put("Savings target", savingsTarget);
        json.put("Amount saved", savings);
        return json;
    }

    // EFFECTS: returns this account as a JSON array
    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    private JSONArray listToJson(ArrayList<Transaction> list) {
        JSONArray jsonArray = new JSONArray();

        for (Transaction t : list) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

}
