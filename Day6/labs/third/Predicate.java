package Day6.labs.third;


// The class which has only one abstract method is a functional interface
@FunctionalInterface
public interface Predicate {
    boolean test(int i);
}
