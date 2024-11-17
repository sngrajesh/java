package Day04.labs.first;

public class Candies extends Dessert {
    public Candies(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice(int quantity) {
        return getPrice() * quantity;   // Price per kg
    }

    @Override
    public String toString() {
        return "Name : " + this.getName() + " | Price : " + this.getPrice()+  "/KG";
    }
}