package Day01.lab.fourth;

public class Calender {
    public static void main(String[] args) {
        Date d2 = new Date();
        d2.setDay(1);
        d2.setMonth("January");
        d2.setYear(2024);
        d2.displayDate();
        System.out.println(d2.getDay() + "/" + d2.getMonth() + "/"+ d2.getYear());
        System.out.println(d2);
    }
}
