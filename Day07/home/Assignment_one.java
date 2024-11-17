package Day07.home;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Assignment_one {
    public static void main(String[] args) {
        String[] fruits_array = {"Mango", "orange", "Grapes", "apple", "Banana", "strawberry", "Watermelon"};
        List<String> fruits_list = Arrays.asList(fruits_array);
        System.out.print("\nOriginal list");
        fruits_list.forEach(System.out::println);

        // Creating Stream
        Stream<String> fruits;


        System.out.print("\nConvert into  lowercase");
        fruits = fruits_list.stream();
        fruits.map(String::toUpperCase).forEach(System.out::println);


        System.out.print("\nConvert into lowercase");
        fruits = fruits_list.stream();
        fruits.map(String::toLowerCase).forEach(System.out::println);


        System.out.print("\nCreate list if fruits that less than 'n' in ascending order");
        fruits = fruits_list.stream();
        // fruits.filter(s -> s.compareToIgnoreCase("n") <= 0).sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);
        fruits.filter(s -> s.compareToIgnoreCase("n") <= 0).sorted(String::compareToIgnoreCase).forEach(System.out::println);


        System.out.print("\nCreate list if fruits that less than 'n' in descending order");
        fruits = fruits_list.stream();
        // fruits.filter(s -> s.compareToIgnoreCase("n") <= 0).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::println);
        fruits.filter(s -> s.compareToIgnoreCase("n") <= 0).sorted(new FruitsReverseComparator()).forEach(System.out::println);


        System.out.print("\nCreate list if fruits with uppercase letter");
        fruits = fruits_list.stream();
        // fruits.filter(s -> (s.compareTo("A") >= 1 & s.compareTo("A") <= 26)).forEach(System.out::println);
        // fruits.filter(s -> s.matches(".*[A-Z].*")).forEach(System.out::println);
        fruits.filter(s -> Character.isUpperCase(s.charAt(0))).forEach(System.out::println);


        System.out.print("\nCreate list of fruits with 6 alphabets or less in descending order");
        fruits = fruits_list.stream();
        fruits.filter(s -> s.length() <= 6).sorted(new FruitsReverseComparator()).forEach(System.out::println);
    }
}

class FruitsReverseComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.compareToIgnoreCase(s1);
    }
}