package Day08.labs.First;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime noon = LocalTime.NOON;
        System.out.println(noon);
        long diff = now.until(noon, ChronoUnit.MINUTES);
        System.out.println(diff + " minutes");

        Duration interval = Duration.between(now, noon);
        System.out.println(interval.toMinutes() + " minutes");

        now = now.plusHours(1);
        now = now.plus(10, ChronoUnit.MINUTES);
        System.out.println(now);

        LocalDateTime dt = now.atDate(LocalDate.of(2025, 11, 25));
        System.out.println(dt);

    }

    public static class DateTimeAssignment {

        public static void main(String[] args) {

            // 1. Calculate your age in no of days, months, years
            LocalDateTime db = LocalDateTime.of(1958,2,18,12,30,45);
            LocalDateTime dn = LocalDateTime.now();
            System.out.println((db.until(dn, ChronoUnit.DAYS)) + " days " + db.until(dn, ChronoUnit.MONTHS) + " months " + db.until(dn, ChronoUnit.YEARS) + " years");


            // 2. Compute programmers day without using plusDays (the 256th day of the year)
            int year = LocalDateTime.now().getYear();
            boolean isLeapYear = java.time.Year.of(year).isLeap();
            int programmersDay = 256;
            int[] daysInMonths = {31, isLeapYear ? 29 : 28 , 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int dayOfYear = programmersDay;

            int month = 0;
            while(dayOfYear > daysInMonths[month]){
                dayOfYear -= daysInMonths[month];
                month++;
            }
            month += 1;

            LocalDate programmersDayDate = LocalDate.of(year, month, dayOfYear);
            System.out.println("Programmers' Day in year is: " + programmersDayDate);


            // 3. Find out all the months that started on a Sundays in year 2024
            Stream<LocalDate> currentyear = LocalDate.of(2024, 1, 1).datesUntil(LocalDate.of(2025, 1, 1));
            currentyear.filter(d -> d.getDayOfMonth() == 1).filter(d -> d.getDayOfWeek().equals(DayOfWeek.SUNDAY)).forEach(System.out::println);



            // 4. If we leave Mumbai at 02:05 am and arrive in New York at 4:40 am. How long is the flight?
            ZonedDateTime mumbaizone = ZonedDateTime.of(2024, 10, 7, 2, 5, 0, 0, ZoneId.of("Asia/Kolkata"));
            ZonedDateTime newyorkzone = ZonedDateTime.of(2024, 10, 7, 4, 40, 0, 0, ZoneId.of("America/New_York"));
            System.out.println(Duration.between(mumbaizone, newyorkzone.withZoneSameInstant(ZoneId.of("Asia/Kolkata"))));
        }
    }
}
