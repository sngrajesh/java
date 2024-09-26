package Day3.labs.second;

public abstract class Employee {
    protected String name;
    protected int empid;
    Employee(String name, int empid){
        this.name = name;
        this.empid = empid;
    }

    public abstract double calculateGross();

    public String toString(){
        return "Employee Data : Name -> "+ this.name + " Id -> " + this.empid;
    }
}
