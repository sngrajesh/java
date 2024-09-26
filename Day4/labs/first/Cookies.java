package Day4.labs.first;

public class Cookies extends Dessert {
    public Cookies(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice(int quantity) {
        return getPrice() * Math.ceil(quantity / 12.0); // Price per dozen
    }
    @Override
    public String toString() {
        return "Name : " + this.getName() + " | Price : " + this.getPrice()+  "/Dozen";
    }
}