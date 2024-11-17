package Day1.lab.fifth;

public class Class {
    public static void main(String[] args) {
        Studnets raj = new Studnets("Rajesh Singh");
        Studnets van = new Studnets("Van D Nayak");
        Studnets anu = new Studnets("Anurag P Ekka");
        System.out.println("\n" + raj + "\n" + van + "\n" + anu);
        System.out.println("\nTotal Studnets : "+ Studnets.getTotal());
    }
}
