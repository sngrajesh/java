package Day3.labs.second;

public class Company {
    public static void main(String[] args) {
        Employee r = new ContractEmployee("Rajesh",7,14,14.5);
        System.out.println(r.calculateGross());
    }
}
