package Day4.labs.second;

public class Printer {
    public void printData(Printable p){
        p.print();
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        Book b = new Book("Head ForstJava", 800);
        p.printData(b);

        Book nb =new Notebbok("C++", 458);
        p.printData(nb);

        nb.foo();
    }
}
