package Day6.labs.third;

public class LambdaExample1 {

    public static void main(String[] args) {

        Predicate isEven = i -> i % 2 == 0;
        Predicate isOdd = i -> i % 2 != 0;
        Predicate isPrime = i -> {
            for (int j = 2; j < i; j++)
                if (i % j == 0)
                    return false;
            return true;
        };

        System.out.println(isEven.test(2));
        System.out.println(isOdd.test(2));
        System.out.println(isPrime.test(37));
    }
}
