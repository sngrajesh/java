package Day04.labs.second;


public class Book implements Printable, Writable {
    private String title;
    private int price;

    public Book(String title, int price) {
        super();
        this.title = title;
        this.price = price;
    }

    @Override
    public void write() {
        System.out.println("This is implementation: Title: " + title);
    }

    @Override
    public void print() {
        System.out.println("This is print implementation title :" + title + " price : "  + price);
    }

    @Override
    public void foo() {
        Printable.super.foo();
    }

    public static void main(String[] args) {
        Book b = new Book("GoT", 1400);
        b.print();
        b.write();
    }
}
