package Day04.labs.second;

public interface Printable {
    void print();
    default void foo(){
        System.out.println("foo");
    }
}

