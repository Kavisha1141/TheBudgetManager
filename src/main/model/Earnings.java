package model;

public class Earnings {
    private int amount;
    private int month;
    private int day;
    private int year;
    private String title;

    // constructs an Earning of amount amt, date consisting of day, month year and title
    public Earnings(){

    }

    // MODIFIES: this
    // EFFECTS: sets the amount to amt
    public void setAmount(){

    }

    // MODIFIES: this
    // EFFECTS: sets the date
    public void setDate(int day, int month, int year){

    }

    // MODIFIES: this
    // EFFECTS: sets the title
    public void setTitle(String title){

    }

    // returns the day
    public int getDay() {
        return -1;
    }

    // returns the month
    public int getMonth() {
        return -1;
    }

    // returns the year
    public int getYear() {
        return -1;
    }

    // returns the amount for the Earning
    public int getAmount() {
        return -1;
    }

    // returns the title for the Earning
    public String getTitle() {
        return "";
    }



}
