package Day03.labs.second;

public abstract class Employee {
    protected String name;
    protected int empid;
    public Employee(String name, int empid){
        this.name = name;
        this.empid = empid;
    }

    public abstract double calculateGross();

    public String toString(){
        return "Employee Data : Name -> "+ this.name + " Id -> " + this.empid;
    }

    public void displayAllawance() {

    }
}
