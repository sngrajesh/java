package Day8.labs.First;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatingAndParsing {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2024, 10, 7, 14, 30, 45);
        System.out.println(dt);

        String date = dt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        System.out.println(date);

        date = dt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a"));
        System.out.println(date);

        String myDate = "2024-10-07 02:30:45";
        LocalDateTime dt1 = LocalDateTime.parse(myDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dt1);

    }
}
