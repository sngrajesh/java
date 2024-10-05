package Day8.labs.First;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

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
}
