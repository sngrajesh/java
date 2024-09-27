## Assignment 1
##### Date : 27th Sep, 2024
    Rajesh Singh
    PR No: 240-840-128-028


#### Base class (abstract) `Dessert`
```java
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
```



#### Child class Cookies of class `Dessert`
```java
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
```



#### Child class Candies of class `Dessert`
```java
package Day4.labs.first;

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
```



#### Child class Ice-Cream of class `Dessert`
```java
package Day4.labs.first;

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

```




#### class Cart
```java
package Day4.labs.first;

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
```




#### class Store
```java
package Day4.labs.first;
import java.util.Scanner;

public class Store {
    public static Dessert items[] = {
            new IceCream("Chocolate", 20),
            new IceCream("Vanilla", 22),
            new IceCream("PineApple", 25),
            new IceCream("Mango", 30),
            new Cookies("Chocolate Chip", 10),
            new Cookies("Oatmeal Raisin", 12),
            new Cookies("Peanut Butter", 15),
            new Cookies("Snickerdoodle", 18),
            new Candies("Milky Way", 5),
            new Candies("Reese's Cup", 6),
            new Candies("M&M", 7),
            new Candies("Jolly Rancher", 8),
    };

    public static void buyItem(Cart cart){
        System.out.println();
        for(int i = 0; i < items.length; i++){
            System.out.println(i + " > " + items[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item number : ");
        int itemno = scanner.nextInt();
        if(itemno >= items.length){
            System.out.println("Item not exist!!!!\n");
            return;
        }
        System.out.print("Enter Quantity of item : ");
        int qunat = scanner.nextInt();
        cart.addToCart(items[itemno],qunat );
        System.out.println("Item Added Successfull!!!!\n");
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("\nOptions");
            System.out.println("1. Buy Item");
            System.out.println("2. Get Total Count");
            System.out.println("3. Get Total Bill");
            System.out.println("4. View Cart");
            System.out.println("5. Clear Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter : ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    buyItem(cart);
                    break;
                case 2:
                    System.out.println("\nTotal items in the cart : " + cart.getTotalCount());
                    break;
                case 3:
                    System.out.println("\nTotal price of products : " + cart.getTotalBill());
                    break;
                case 4:
                    cart.printCart();
                    break;
                case 5:
                    cart.clearCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}
```
#### Output 
```shell
Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 1

0 > Name : Chocolate | Price : 20.0/Piece
1 > Name : Vanilla | Price : 22.0/Piece
2 > Name : PineApple | Price : 25.0/Piece
3 > Name : Mango | Price : 30.0/Piece
4 > Name : Chocolate Chip | Price : 10.0/Dozen
5 > Name : Oatmeal Raisin | Price : 12.0/Dozen
6 > Name : Peanut Butter | Price : 15.0/Dozen
7 > Name : Snickerdoodle | Price : 18.0/Dozen
8 > Name : Milky Way | Price : 5.0/KG
9 > Name : Reese's Cup | Price : 6.0/KG
10 > Name : M&M | Price : 7.0/KG
11 > Name : Jolly Rancher | Price : 8.0/KG
Enter Item number : 1
Enter Quantity of item : 12
Item Added Successfull!!!!


Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 1

0 > Name : Chocolate | Price : 20.0/Piece
1 > Name : Vanilla | Price : 22.0/Piece
2 > Name : PineApple | Price : 25.0/Piece
3 > Name : Mango | Price : 30.0/Piece
4 > Name : Chocolate Chip | Price : 10.0/Dozen
5 > Name : Oatmeal Raisin | Price : 12.0/Dozen
6 > Name : Peanut Butter | Price : 15.0/Dozen
7 > Name : Snickerdoodle | Price : 18.0/Dozen
8 > Name : Milky Way | Price : 5.0/KG
9 > Name : Reese's Cup | Price : 6.0/KG
10 > Name : M&M | Price : 7.0/KG
11 > Name : Jolly Rancher | Price : 8.0/KG
Enter Item number : 6
Enter Quantity of item : 2
Item Added Successfull!!!!


Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 2

Total items in the cart : 14

Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 3

Total price of products : 279.0

Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 4

Cart Details:
Name : Peanut Butter Price :  Quantity : 2 Total Price : 15.0
Name : Vanilla Price :  Quantity : 12 Total Price : 264.0

Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 6

Cart Details:
Name : Peanut Butter Price :  Quantity : 2 Total Price : 15.0
Name : Vanilla Price :  Quantity : 12 Total Price : 264.0
Total Items : 14 Total Price : 279.0

Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 5

Options
1. Buy Item
2. Get Total Count
3. Get Total Bill
4. View Cart
5. Clear Cart
6. Checkout
0. Exit
Enter : 0

Process finished with exit code 0
```