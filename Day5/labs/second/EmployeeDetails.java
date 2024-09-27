package Day5.labs.second;

import java.util.Comparator;
import java.util.Set;

public class EmployeeDetails implements Comparable<EmployeeDetails> {
    private int empid;
    private String name;
    private double salary;
    private Set<String> skillset;

    public EmployeeDetails(int empid, String name, double salary, Set<String> skillset) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
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

    public Set<String> getSkillset() {
        return skillset;
    }

    public void setSkillset(Set<String> skillset) {
        this.skillset = skillset;
    }

    @Override
    public String toString() {
        return "Id :" + empid + " | Name: " + name + " | Salary: " + salary + " | Skillset: " + skillset.toString();
    }

    @Override
    public int compareTo(EmployeeDetails employeeDetails) {
        /*
        if (this.getEmpid() < employeeDetails.getEmpid()) {
            return -1;
        }else {
            return 1;
        }
        */
        return this.getEmpid() - employeeDetails.getEmpid();
    }
}



class EmployeeNameComparator implements Comparator<EmployeeDetails> {
    @Override
    public int compare(EmployeeDetails employeeDetails1, EmployeeDetails employeeDetails2) {
        return employeeDetails1.getName().compareTo(employeeDetails2.getName());
    }
}

class EmployeeSalaryComparator implements Comparator<EmployeeDetails> {
    @Override
    public int compare(EmployeeDetails employeeDetails1, EmployeeDetails employeeDetails2) {
        return Double.compare(employeeDetails1.getSalary(), employeeDetails2.getSalary());
    }
}
