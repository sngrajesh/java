package Practice;

public class Wrap {
    public static void main(String[] args)
    {
        Integer a = 10;
        int a1 = 5;
        System.out.println(a);
        System.out.println(a.intValue());
        int b = a;
        System.out.println(b);

        System.out.println("hash: "+ a.hashCode());
        System.out.println("identity hash: "+ System.identityHashCode(a));
    }
}
