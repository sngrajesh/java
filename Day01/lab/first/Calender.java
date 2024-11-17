package Day01.lab.first;

public class Calender {
    public static void main(String[] args) {
        // Part 1 - Date without new keyword
        // Error -> NullPointerException
        //Date d1 = null;
        //d1.setDate(1, 1, 2020);
        //d1.displayDate();


        // Part 2 - Date with new keyword
        // Output: The date is 1/1/2020
        Date d2 = new Date();
        d2.setDate(1, "January", 2020);
        d2.displayDate();

    }
}
