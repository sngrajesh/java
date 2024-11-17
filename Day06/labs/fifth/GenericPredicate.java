package Day6.labs.fifth;

@FunctionalInterface
public interface GenericPredicate<T> {
    public T apply(T data);
}
