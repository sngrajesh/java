package Day7.labs.first;

import java.util.Set;

public class Employee {
    private int empid;
    private String name;
    private double salary;
    private String department;
    private Set<String> skillset;

    public Employee(int empid, String name, double salary, String department, Set<String> skillset) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.skillset = skillset;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<String> getSkillset() {
        return skillset;
    }

    public void setSkillset(Set<String> skillset) {
        this.skillset = skillset;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", skillset=" + skillset +
                '}';
    }
}
