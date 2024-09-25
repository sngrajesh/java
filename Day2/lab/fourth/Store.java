package Day2.lab.fourth;

import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Flavours[] flavours = Flavours.values();
        for (Flavours f : flavours) {
            System.out.println(f.name() + " costs " + f.getPrice());
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the flavour : ");
        String f = sc.nextLine().toUpperCase();
        Flavours flav = Flavours.valueOf(f);
        switch (flav) {
            case CHOCOLATE:
                System.out.println("You have chosen chocolate and cost is " + flav.getPrice());
                break;
            case VANILLA:
                System.out.println("You have chosen vanilla and cost is " + flav.getPrice());
                break;
            case STRAWBERRY:
                System.out.println("You have chosen strawberry and cost is " + flav.getPrice());
                break;
        }
    }
}
