package Day04.labs.first;

public class IceCream extends Dessert {
    public IceCream(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice(int quantity) {
        return getPrice() * quantity;       //Price per piece
    }

    @Override
    public String toString() {
        return "Name : " + this.getName() + " | Price : " + this.getPrice()+  "/Piece";
    }
}
