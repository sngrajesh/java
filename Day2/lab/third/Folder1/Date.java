package com.myproject;

public class Date {
    // variables declaration
    private int day;
    private String month;
    private int year;

    // methods declaration
    public void setDate(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void displayDate() {
        System.out.println("The date is " + day + "/" + month + "/" + year);
    }
}
