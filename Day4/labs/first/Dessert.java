package Day4.labs.first;

public abstract class Dessert {
    private String name;
    private double price;

    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculatePrice(int quantity);

    public abstract String toString();
}