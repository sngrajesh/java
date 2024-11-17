package Day06.labs.third;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LambdaExample2 {
    public boolean operateOnNumber(Predicate predicate, int number) {
        return predicate.test(number);
    }

    public List<Integer> opetateOnNumber(Predicate predicate, List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                result.add(number);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LambdaExample2 lambdaExample = new LambdaExample2();
        Integer[] numbers = {1, 2, -3, 2, -5,12 , 45, -6};
        // List<Integer> numbersList = List.of(numbers);
        List<Integer> numbersList = Arrays.asList(numbers);

        boolean isEven = lambdaExample.operateOnNumber(i -> i % 2 == 0, numbers[5]);
        System.out.println(isEven);

        List<Integer> evenNumbers = lambdaExample.opetateOnNumber(i -> i > 0, numbersList);
        System.out.println(evenNumbers);

    }

}
