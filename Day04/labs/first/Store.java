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


