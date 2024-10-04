package Day6.labs.seventh;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsWithObjects {
    public static void main(String[] args) {
        // Create an array of integers
        Integer[] num = {22, 48, 90, 83, 20, 87, 24, 18, 22, 14, 44, 23, 1, 23, 57, 79, 17, 12, 78, 84, 32, 28, 60, 62, 67, 21, 79, 10, 87, 97, 13, 14, 9, 64, 52, 73, 53, 22, 47, 98, 82};

        //Convert the array to a List
        List<Integer> list = Arrays.asList(num);

        System.out.println("\nExample 1: Calculate and print square roots using parallel stream");
        Stream<Integer> stream = list.parallelStream();
        stream.map(i -> Math.sqrt(i)).forEach(System.out::println);

        System.out.println("\nExample 2: Filter prime numbers and print them using parallel stream");
        stream = list.parallelStream();
        stream.filter(Day1.lab.second.Math::isPrime).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("\nExample 3: Print distinct numbers in sorted order");
        stream = list.stream();
        stream.distinct().sorted(Integer::compareTo).forEach(System.out::println);

        System.out.println("\nExample 4.1: Calculate sum using reduce() on sequential stream");
        stream = list.stream();
        Optional<Integer> sum = stream.reduce((a, b) -> a + b);
        if(sum.isPresent())
            System.out.println(sum.get());


        System.out.println("\nExample 4.2: Calculate sum using reduce() on sequential stream with initial value");
        stream = list.stream();
        double sum_1 = stream.reduce(1, (a, b) -> a + b);
        System.out.println(sum.get());


        // The total will be sum + 1 * number_of_parallel_threads (default number of threads is number of cores)
        System.out.println("\nExample 5: Calculate sum using reduce() on parallel stream");
        stream = list.parallelStream();
        Optional<Integer> sum_2 = stream.reduce((a, b) -> a + b);
        if(sum_2.isPresent())
            System.out.println(sum_2.get());

        System.out.println("\nExample 6: Calculate sum using reduce() with initial value on parallel stream");
        stream = list.parallelStream();
        long sum_3 = stream.reduce(1, (a, b) -> a + b);
        System.out.println(sum_3);

        System.out.println("\nExample 7: Find maximum value using sequential stream");
        stream = list.stream();
        Optional<Integer> max = stream.max(Integer::compareTo);
        if(max.isPresent())
            System.out.println(max.get());

        System.out.println("\nExample 8: Find minimum value using parallel stream");
        stream = list.parallelStream();
        Optional<Integer> min = stream.min(Integer::compareTo);
        if(min.isPresent())
            System.out.println(min.get());

        System.out.println("\nExample 9: Calculate average using sequential stream");
        stream = list.stream();
        OptionalDouble ave = stream.mapToDouble(Double::valueOf).average();
        if(ave.isPresent())
            System.out.println(ave.getAsDouble());

        System.out.println("\nExample 10: Calculate average using parallel stream");
        stream = list.parallelStream();
        OptionalDouble ave_2 = stream.mapToDouble(Double::valueOf).average();
        if(ave_2.isPresent())
            System.out.println(ave_2.getAsDouble());
    }
}