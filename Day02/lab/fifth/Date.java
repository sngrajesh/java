package Day2.lab.fifth;

public class Date {
    // variables declaration
    private int day;
    private Months month;
    private int year;

    // methods declaration
    public void setDate(int day, Months month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void displayDate() {
        System.out.println("The date is " + day + "/" + month.getMonth() + "/" + year);
    }
}
