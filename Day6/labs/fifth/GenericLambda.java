package Day6.labs.fifth;

public class GenericLambda
{
    public static <T> T operateOnData(GenericPredicate<T> f, T data)
    {
        return f.apply(data);
    }

    public static void main(String[] args)
    {
        String substring = operateOnData((s)-> s.substring(3), "Rajesh Boy");
        System.out.println(substring);

        Integer square = operateOnData((n)->n*n, 24);
        System.out.println(square);
    }
}
