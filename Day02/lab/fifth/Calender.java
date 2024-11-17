package Day02.lab.fifth;

public class Calender {
    public static void main(String[] args) {
        Date d2 = new Date();
//        Months[] mts = Months.values();
        Months month =  Months.JANUARY;
        d2.setDate(21, month, 2022);
        d2.displayDate();
    }
}
