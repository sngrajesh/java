package Day03.labs.second;

public class Manager extends SalariedEmployee{
    protected double allowance;
    public Manager(String name, int empid,double basic,  double allowance ){
        super(name,empid, basic);
        this.allowance = allowance;
    }

    @Override
    public double calculateGross() {
        return super.calculateGross() + allowance;
    }

    public void displayAllawance(){
        System.out.println(this.name+"'s " + "Allowance : " + this.allowance);
    }
}
