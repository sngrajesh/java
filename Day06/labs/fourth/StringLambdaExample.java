package Day06.labs.fourth;

public class StringLambdaExample {

    public String apply(String s, PredicateString p) {
        return p.applly(s);
    }

    public static void main(String[] args) {
        StringLambdaExample sl = new StringLambdaExample();
        System.out.println(sl.apply("Rajesh", s -> s.substring(3)));

        String sa1 = sl.apply("Rajesh", String::toUpperCase);
        System.out.println(sa1);

        String sa2 = sl.apply("Rajesh", s -> {
            StringBuilder s2 = new StringBuilder();
            for(int i = 0; i < s.length(); i++)
                s2.append(s.charAt(s.length() - i - 1));
            return s2.toString();
        });
        System.out.println(sa2);

        System.out.println(sl.apply("Rajesh", s -> {
            StringBuilder s2 = new StringBuilder();
            for(int i = 0; i < s.length(); i++)
                s2.append(s.charAt(s.length() - i - 1));
            return s2.toString();
        }));

    }
}
