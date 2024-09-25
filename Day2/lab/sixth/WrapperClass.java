package Day2.lab.sixth;

public class WrapperClass {
    public static void main(String[] args) {
        // Primitive type
        int num = 5;

        // Converting int to Integer (Wrapper class)
        Integer wrappedNum = Integer.valueOf(num);
        System.out.println("Wrapped Integer: " + wrappedNum);

        // Unboxing (converting wrapper class to primitive)
        int unwrappedNum = wrappedNum.intValue();
        System.out.println("Unwrapped Integer: " + unwrappedNum);

        // Autoboxing (automatic conversion from primitive to wrapper)
        Integer autoWrappedNum = num;
        System.out.println("Autoboxed Integer: " + autoWrappedNum);

        // Auto-unboxing (automatic conversion from wrapper to primitive)
        int autoUnwrappedNum = autoWrappedNum;
        System.out.println("Auto-unboxed Integer: " + autoUnwrappedNum);

    }
}
