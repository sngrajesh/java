package Day3.labs.second;

public class ContractEmployee extends Employee{
    protected double rate;
    protected int hours;
    public ContractEmployee(String name, int empid, int hours, double rate ) {
        super(name, empid);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculateGross() {
        return this.hours*this.rate;
    }
}
