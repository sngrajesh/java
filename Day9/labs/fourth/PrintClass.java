package Day9.labs.fourth;

public class PrintClass {
    /*
        MyArray class has a method to Print Character Array.
        Write a multithreaded program to print the given char array by 2 threads
        char [] greeting = {'G','o','o', 'd', '', 'M', 'o','r','n','i','n','g'}
     */
    public static void main(String[] args) throws InterruptedException {
        PrintArrya tp = new PrintArrya();
        Thread t1 = new Thread(tp);
        Thread t2 = new Thread(tp);

        t1.start();
        // t1.join();
        t2.start();
    }
}
