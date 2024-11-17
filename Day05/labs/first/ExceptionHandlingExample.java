package Day05.labs.first;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {

        int dividend = Integer.parseInt(args[0]);
        int divisor = Integer.parseInt(args[1]);
        int res = dividend/divisor;
        System.out.println(res);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Custom message on console");
            System.out.println(e);
        }
    }
}

