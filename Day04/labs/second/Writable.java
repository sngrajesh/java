package Day4.labs.second;

public interface Writable{
    public void write();

    default void foo(){
        System.out.println("foo");
    }
}
