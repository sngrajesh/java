package Day03.labs.second;

public class SalariedEmployee extends Employee {
    protected double basic;
    public SalariedEmployee(String name, int empid, double basic){
        super(name,empid);
        this.basic = basic;
    }

    @Override
    public double calculateGross() {
        double hra = basic*0.4;
        double da = basic*0.12;
        return basic+da+hra;
    }


    public double calculateNet(){
        double gross = calculateGross();
        double tax = 0.2;
        return gross*(1 - tax);
    }
}
