package Day3.labs.second;

public class Payroll {
    public void displayGross(Employee e){
        System.out.println("Gross salary of " + e.name+ " : " + e.calculateGross());
    }
    public void displayNet(SalariedEmployee e){
        System.out.println("Net salary of "+ e.name+ " : " + e.calculateNet());
    }
}
