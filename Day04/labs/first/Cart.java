package Day04.labs.first;

import java.util.HashMap;



public class Cart {
    private HashMap<Dessert, Integer> desserts;


    public Cart() {
        this.desserts = new HashMap<Dessert, Integer>();
    }

    public void addToCart(Dessert dessert, int quantity) {
        if(this.desserts.containsKey(dessert)){
            quantity = quantity+desserts.get(dessert);
        }
        this.desserts.put(dessert, quantity);
    }

    public int getTotalCount() {
        int totalCOunt = 0;
        for(int ct : desserts.values()){
            totalCOunt+= ct;
        }
        return totalCOunt;
    }

    public double getTotalBill() {
        double totalBill = 0;
        for(Dessert dt : desserts.keySet()){
            int qunat = desserts.get(dt);
            totalBill += dt.calculatePrice(qunat);
        }
        return totalBill;
    }

    public void clearCart(){
        desserts.clear();
    }

    public void printCart() {
        System.out.println("\nCart Details:");
        for(Dessert dt : desserts.keySet()){
            int qunat = desserts.get(dt);
            System.out.println("Name : " + dt.getName()+ " Price : " + " Quantity : " + qunat + " Total Price : "+ dt.calculatePrice(qunat));
        }
    }

    public void checkout(){
        int totalItems = this.getTotalCount();
        double aggreatePrice =  this.getTotalBill();
        this.printCart();
        System.out.println("Total Items : " +totalItems + " Total Price : "+ aggreatePrice);
        this.clearCart();
    }
}














