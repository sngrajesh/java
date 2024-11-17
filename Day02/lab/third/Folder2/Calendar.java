package mypack;

import com.myproject.Date;

public class Calendar {
    public static void main(String[] args) {
        Date d2 = new Date();
        d2.setDate(1, "January", 2020);
        d2.displayDate();
    }
}
