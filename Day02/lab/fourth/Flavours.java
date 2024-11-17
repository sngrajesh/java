package Day2.lab.fourth;


public enum Flavours {
    CHOCOLATE(100),
    VANILLA(50),
    STRAWBERRY(200);

    private int price;

    private Flavours(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}