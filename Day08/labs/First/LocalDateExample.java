package Day08.labs.First;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate diwali = LocalDate.of(2025, 11, 25);
        System.out.println(diwali);

        Period timeToDiwali = today.until(diwali);
        System.out.println(timeToDiwali);
        System.out.println(timeToDiwali.getYears() + " year(s) " + timeToDiwali.getMonths()  + " month(s) " +  timeToDiwali.getDays()  + " days(s)" );

        long daystodiwali =  today.until(diwali, ChronoUnit.DAYS);
        System.out.println(daystodiwali + " days");

        System.out.println(today.getDayOfMonth());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getMonthValue());
        System.out.println(today.getMonth());
        System.out.println(today.getYear());


        LocalDate tomorrow = today.plusDays(10);
        System.out.println(tomorrow);

        LocalDate nextFriday = today.plus(Period.ofDays(7));
        System.out.println(nextFriday);


        System.out.println("----------------------------------------------------------------------");
        Stream<LocalDate> currentyear = LocalDate.of(2025, 1, 1).datesUntil(LocalDate.of(2026, 1, 1));
        // currentyear.forEach(System.out::println);

        currentyear
                .filter(d -> d.getDayOfWeek().equals(DayOfWeek.FRIDAY))
                .filter(d -> d.getDayOfMonth() == 13)
                .forEach(System.out::println);



        // Temporal Adjusters
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek());
        System.out.println(today.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek());
        System.out.println(today.with(TemporalAdjusters.next((DayOfWeek.SUNDAY))));
        System.out.println(today.with(TemporalAdjusters.firstInMonth((DayOfWeek.SUNDAY))));
    }

}
