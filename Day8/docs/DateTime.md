### 1. **`java.time` Package Overview**
The `java.time` package provides the main classes for working with dates and times, such as:

- **`LocalDate`**: Represents a date without time (e.g., `2024-10-04`). It is useful for scenarios like birthdays, anniversaries, or any date-based event.
- **`LocalTime`**: Represents a time without a date (e.g., `14:30:00`). It is useful for capturing just the time of day, like opening hours or scheduling a reminder.
- **`LocalDateTime`**: Represents both date and time (e.g., `2024-10-04T14:30:00`). This combines date and time into one object, useful for timestamping.
- **`ZonedDateTime`**: Represents date and time with time zone information (e.g., `2024-10-04T14:30:00+01:00[Europe/Paris]`).
- **`Instant`**: Represents an instantaneous point on the timeline in UTC, often used for machine-readable timestamps.
- **`Duration`** and **`Period`**: Represents the amount of time or period between two dates or times.

### 2. **`LocalDate` Example**
If you only need to represent a date without time (e.g., today’s date, a birthdate):

   ```java
   import java.time.LocalDate;

   public class Example {
       public static void main(String[] args) {
           LocalDate today = LocalDate.now();
           LocalDate birthday = LocalDate.of(1995, 10, 15); // Date of birth example

           System.out.println("Today's Date: " + today);
           System.out.println("Birthday: " + birthday);
       }
   }
   ```

**Output:**
   ```
   Today's Date: 2024-10-04
   Birthday: 1995-10-15
   ```

### 3. **`LocalTime` Example**
To represent only time (e.g., meeting time):

   ```java
   import java.time.LocalTime;

   public class Example {
       public static void main(String[] args) {
           LocalTime now = LocalTime.now();
           LocalTime meetingTime = LocalTime.of(14, 30); // Time: 14:30

           System.out.println("Current Time: " + now);
           System.out.println("Meeting Time: " + meetingTime);
       }
   }
   ```

**Output:**
   ```
   Current Time: 14:32:45.123456789
   Meeting Time: 14:30
   ```

### 4. **`LocalDateTime` Example**
Combines date and time:

   ```java
   import java.time.LocalDateTime;

   public class Example {
       public static void main(String[] args) {
           LocalDateTime currentDateTime = LocalDateTime.now();
           LocalDateTime specificDateTime = LocalDateTime.of(2024, 10, 4, 14, 30);

           System.out.println("Current Date and Time: " + currentDateTime);
           System.out.println("Specific Date and Time: " + specificDateTime);
       }
   }
   ```

**Output:**
   ```
   Current Date and Time: 2024-10-04T14:32:45.123
   Specific Date and Time: 2024-10-04T14:30
   ```

### 5. **`ZonedDateTime` Example**
If you need to work with date and time across different time zones, `ZonedDateTime` is your friend:

   ```java
   import java.time.ZonedDateTime;
   import java.time.ZoneId;

   public class Example {
       public static void main(String[] args) {
           ZonedDateTime currentDateTimeInParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
           ZonedDateTime currentDateTimeInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));

           System.out.println("Current Time in Paris: " + currentDateTimeInParis);
           System.out.println("Current Time in New York: " + currentDateTimeInNY);
       }
   }
   ```

**Output:**
   ```
   Current Time in Paris: 2024-10-04T14:32:45.123+02:00[Europe/Paris]
   Current Time in New York: 2024-10-04T08:32:45.123-04:00[America/New_York]
   ```

### 6. **`Instant` Example**
An `Instant` represents a specific moment on the timeline, in UTC:

   ```java
   import java.time.Instant;

   public class Example {
       public static void main(String[] args) {
           Instant timestamp = Instant.now();
           System.out.println("Current Timestamp (UTC): " + timestamp);
       }
   }
   ```

**Output:**
   ```
   Current Timestamp (UTC): 2024-10-04T12:32:45.123Z
   ```

### 7. **Formatting and Parsing**
You can format and parse dates and times using the `DateTimeFormatter` class:

   ```java
   import java.time.LocalDateTime;
   import java.time.format.DateTimeFormatter;

   public class Example {
       public static void main(String[] args) {
           LocalDateTime now = LocalDateTime.now();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

           String formattedDate = now.format(formatter);
           System.out.println("Formatted Date and Time: " + formattedDate);

           // Parsing
           LocalDateTime parsedDate = LocalDateTime.parse("2024-10-04 14:30:00", formatter);
           System.out.println("Parsed Date and Time: " + parsedDate);
       }
   }
   ```

**Output:**
   ```
   Formatted Date and Time: 2024-10-04 14:32:45
   Parsed Date and Time: 2024-10-04T14:30
   ```

### 8. **Duration and Period**
- **`Duration`** is used to calculate time-based differences (hours, minutes, seconds).
- **`Period`** is used for date-based differences (years, months, days).

**Example**:

   ```java
   import java.time.Duration;
   import java.time.LocalTime;
   import java.time.LocalDate;
   import java.time.Period;

   public class Example {
       public static void main(String[] args) {
           // Time-based difference using Duration
           LocalTime startTime = LocalTime.of(9, 30);
           LocalTime endTime = LocalTime.of(14, 30);
           Duration duration = Duration.between(startTime, endTime);
           System.out.println("Duration: " + duration.toHours() + " hours");

           // Date-based difference using Period
           LocalDate startDate = LocalDate.of(2020, 10, 1);
           LocalDate endDate = LocalDate.of(2024, 10, 1);
           Period period = Period.between(startDate, endDate);
           System.out.println("Period: " + period.getYears() + " years");
       }
   }
   ```

**Output:**
   ```
   Duration: 5 hours
   Period: 4 years
   ```

### 9. **Legacy Date and Time APIs**
Before Java 8, `java.util.Date` and `java.util.Calendar` were used. These are still available for backward compatibility but are less recommended for modern development. Conversion between the new `java.time` classes and the old ones is supported via the `Date.from()` and `Instant.toEpochMilli()` methods.


### 10. **Temporal Adjusters** 
In Java are utilities used to perform date manipulations in a more human-readable and convenient way. They allow you to adjust a `Temporal` (e.g., `LocalDate`, `LocalDateTime`, `ZonedDateTime`) to meet certain conditions, like finding the next working day, the first day of the month, or the last Friday of the month.

These are part of the `java.time.temporal` package, introduced in Java 8, and work with any class that implements the `Temporal` interface.

#### **Types of Temporal Adjusters**

#### 1. **Predefined Temporal Adjusters**
The `java.time.temporal.TemporalAdjusters` class provides several predefined adjusters, which can be used out of the box. Some common ones include:

- `firstDayOfMonth()` – Adjusts the date to the first day of the month.
- `lastDayOfMonth()` – Adjusts the date to the last day of the month.
- `firstDayOfNextMonth()` – Adjusts the date to the first day of the next month.
- `firstDayOfYear()` – Adjusts the date to the first day of the current year.
- `lastDayOfYear()` – Adjusts the date to the last day of the current year.
- `firstInMonth(DayOfWeek dayOfWeek)` – Adjusts the date to the first occurrence of a specified day of the week in the current month.
- `next(DayOfWeek dayOfWeek)` – Adjusts the date to the next occurrence of the specified day of the week.
- `previous(DayOfWeek dayOfWeek)` – Adjusts the date to the previous occurrence of the specified day of the week.
- `nextOrSame(DayOfWeek dayOfWeek)` – Adjusts the date to the next occurrence of the specified day of the week, or keeps the date unchanged if it is already that day.
- `previousOrSame(DayOfWeek dayOfWeek)` – Adjusts the date to the previous occurrence of the specified day of the week, or keeps the date unchanged if it is already that day.

### **Example Usage**

Let’s explore how to use some of these predefined adjusters:

#### Example 1: Finding the First and Last Day of the Month
```java
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // First day of the current month
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First day of the month: " + firstDayOfMonth);

        // Last day of the current month
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Last day of the month: " + lastDayOfMonth);
    }
}
```

**Output:**
```
First day of the month: 2024-10-01
Last day of the month: 2024-10-31
```

#### Example 2: Finding the Next or Previous Day of the Week
```java
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Next Monday
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Next Monday: " + nextMonday);

        // Previous Friday
        LocalDate previousFriday = today.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        System.out.println("Previous Friday: " + previousFriday);
    }
}
```

**Output:**
```
Next Monday: 2024-10-07
Previous Friday: 2024-09-27
```

#### Example 3: Finding the First Monday of the Next Month
```java
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // First Monday of next month
        LocalDate firstMondayNextMonth = today
                .with(TemporalAdjusters.firstDayOfNextMonth())
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println("First Monday of next month: " + firstMondayNextMonth);
    }
}
```

**Output:**
```
First Monday of next month: 2024-11-04
```
---

### Key Points to Remember:
- **Immutable and Thread-Safe**: Classes in `java.time` are immutable and thread-safe.
- **Time Zones**: Use `ZonedDateTime` or `OffsetDateTime` when working with time zones.
- **Date Manipulation**: You can easily add or subtract time periods using methods like `plusDays()`, `minusHours()`, etc.
