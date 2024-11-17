package Day08.labs.First;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneTimeExample {
    public static void main(String[] args) {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println(zones);

        LocalDateTime indialocal = LocalDateTime.now();
        System.out.println(indialocal);

        //ZonedDateTime indiazone = ZonedDateTime.now();
        ZonedDateTime indiazone = indialocal.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println(indiazone);

        Instant indiainstant = indiazone.toInstant();
        System.out.println(indiainstant);

        ZonedDateTime indiazone1 = indiainstant.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println(indiazone1);

        ZonedDateTime losangeles = indiainstant.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println(losangeles);

    }
}
