package Day06.labs.sixth;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsExample {
    public static void main(String[] args) {
        // Array of integers
        int num[] = {22, 48, 90, 83, 20, 87, 24, 18, 22, 14, 44, 23, 1, 23, 57, 79, 17, 12, 78, 84, 32, 28, 60, 62, 67, 21, 79, 10, 87, 97, 13, 14, 9, 64, 52, 73, 53, 22, 47, 98, 82};


        // Create a new stream, sort the elements, and print each one
        IntStream stream = Arrays.stream(num);
        // Method reference -> It is a shorthand for calling a method on an object reference
        //stream.sorted().forEach(System.out::println);

        // Create a stream from the array and print the total count of elements
        stream = Arrays.stream(num);
        System.out.println(stream.count()); // Output: Total number of elements

        // Create a new stream, remove duplicates, sort the elements, and print them
        stream = Arrays.stream(num);
        System.out.println(stream.distinct().sorted()); // Sorted distinct elements

        // Create a new stream, multiply each element by 2, box them to Integers, and collect into a list
        stream = Arrays.stream(num);
        System.out.println(stream.map(i -> i * 2).boxed().collect(Collectors.toList())); // Doubled values

        // Create a new stream, filter numbers greater than 50, and count how many
        stream = Arrays.stream(num);
        System.out.println(stream.filter(i -> i > 50).count()); // Numbers greater than 50 count

        // Create a new stream, limit to the first 5 elements, and count them
        stream = Arrays.stream(num);
        System.out.println(stream.limit(5).count()); // Count of the first 5 elements

        // Create a new stream and sum the elements using reduce
        stream = Arrays.stream(num);
        System.out.println(stream.reduce(0, (a, b) -> a + b)); // Sum of elements using reduce

        // Create a new stream and sum the elements using sum() method
        stream = Arrays.stream(num);
        System.out.println(stream.sum()); // Sum of elements using sum

        // Create a new stream, filter even numbers, box them to Integers, and collect into a list
        stream = Arrays.stream(num);
        List<Integer> even = stream.filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(even); // List of even numbers

        // Working with Optional return types:

        // Find the maximum value in the stream
        stream = Arrays.stream(num);
        OptionalInt max = stream.max();
        if (max.isPresent())
            System.out.println(max.getAsInt()); // Print max value if present

        // Find the minimum value in the stream
        stream = Arrays.stream(num);
        OptionalInt min = stream.min();
        if (min.isPresent())
            System.out.println(min.getAsInt()); // Print min value if present

        // Calculate the average of the elements in the stream
        stream = Arrays.stream(num);
        OptionalDouble average = stream.average();
        if (average.isPresent())
            System.out.println(average.getAsDouble()); // Print average value if present

        // Use reduce to sum the elements (Optional return type)
        stream = Arrays.stream(num);
        OptionalInt sum = stream.reduce((a, b) -> a + b);
        if (sum.isPresent())
            System.out.println(sum.getAsInt()); // Print the sum if present

        // Another example of using reduce with an initial value of 1 (not typical summing)
        stream = Arrays.stream(num);
        double sum_2 = stream.reduce(1, (a, b) -> a + b);
        System.out.println(sum_2); // Output : total + 1 (unconventional summing)
    }
}
