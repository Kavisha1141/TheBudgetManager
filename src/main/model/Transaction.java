package model;

import org.json.JSONObject;

import persistence.Writable;

// constructs a Transaction with amt, date and title
public class Transaction implements Writable {
    private int amount;
    private int month;
    private int day;
    private int year;
    private String title;

    // constructs a Transaction of amount amt, date consisting of day, month year
    // and title
    public Transaction(int amt, int day, int month, int year, String title) {
        this.amount = amt;
        this.day = day;
        this.month = month;
        this.year = year;
        this.title = title;
    }

    // returns the day
    public int getDay() {
        return day;
    }

    // returns the month
    public int getMonth() {
        return month;
    }

    // returns the year
    public int getYear() {
        return year;
    }

    // returns the amount for the transaction
    public int getAmount() {
        return amount;
    }

    // returns the title for the transaction
    public String getTitle() {
        return title;
    }

    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("amount", amount);
        json.put("day", day);
        json.put("month", month);
        json.put("year", year);
        json.put("title", title);
        return json;
    }
}
