package Day1.lab.fourth;

public class Date {
    // variables declaration
    private int day;
    private String month;
    private int year;

    // Mutators declaration
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Accessors Declaration
    public int getDay() {
        return this.day;
    }
    public String getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    // Print string representation of the object [eg: print(obj)]
    public String toString(){
       return "The date is " + day + "/" + month + "/" + year;
    }

    public void displayDate() {
        System.out.println("The date is " + day + "/" + month + "/" + year);
    }
}
