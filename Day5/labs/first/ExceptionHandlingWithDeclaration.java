package Day5.labs.first;

public class ExceptionHandlingWithDeclaration {

    public static void divide(String s1, String s2)
            throws ArrayIndexOutOfBoundsException,
            ArithmeticException, NumberFormatException {
        int dividend = Integer.parseInt(s1);
        int divisor = Integer.parseInt(s2);
        int res = dividend / divisor;
        System.out.println(res);
    }

    public static void main(String[] args) {
        try {
            divide(args[0], args[1]);
        } catch (ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}

