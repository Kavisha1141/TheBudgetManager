package model;

public class Transaction {
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

    // returns the amount for the Earning
    public int getAmount() {
        return amount;
    }

    // returns the title for the Earning
    public String getTitle() {
        return title;
    }

}
