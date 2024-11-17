package Day05.labs.second;
import java.util.*;


public class EmployeeCollection {
    public List<EmployeeDetails> initializeEmployeeCollectionData() {
        List<EmployeeDetails> employeelist = new ArrayList<>();
        Set<String> skillset1 = new TreeSet<>();
        skillset1.add("Java");
        skillset1.add("C++");
        skillset1.add("Python");

        Set<String> skillset2 = new TreeSet<>();
        skillset2.add("JavaScript");
        skillset2.add("C#");
        skillset2.add("PHP");

        Set<String> skillset3 = new TreeSet<>();
        skillset3.add("MySQL");
        skillset3.add("MongoDB");
        skillset3.add("Cassandra");

        Set<String> skillset4 = new TreeSet<>();
        skillset4.add("C#");
        skillset4.add("Ruby");
        skillset4.add("Rails");

        employeelist.add(new EmployeeDetails(1, "John", 10000, skillset1));
        employeelist.add(new EmployeeDetails(2, "David", 20000, skillset2));
        employeelist.add(new EmployeeDetails(3, "Mary", 30000, skillset3));
        employeelist.add(new EmployeeDetails(4, "Peter", 40000, skillset4));

        return employeelist;
    }

    public void displayEmployeeCollectionData(List<EmployeeDetails> employeelist) {
        for (EmployeeDetails employee : employeelist) {
            System.out.println(employee);
        }
        System.out.println();
    }

    public EmployeeDetails getEmployeeDetails(int empid, List<EmployeeDetails> employeelist) {
        for (EmployeeDetails employee : employeelist) {
            if (employee.getEmpid() == empid) {
                return employee;
            }
        }
        return null;
    }

    public List<EmployeeDetails> fileterBySkills(List<EmployeeDetails> employeelist, String skill) {
        List<EmployeeDetails> filteredEmployeeList = new ArrayList<>();
        for (EmployeeDetails employee : employeelist) {
            if (employee.getSkillset().contains(skill)) {
                filteredEmployeeList.add(employee);
            }
        }
        return filteredEmployeeList;
    }


    public Map<Integer, Double> getSalaryMap(List<EmployeeDetails> employeelist) {
        Map<Integer, Double> salaryMap = new HashMap<>();
        for (EmployeeDetails employee : employeelist) {
            salaryMap.put(employee.getEmpid(), employee.getSalary());
        }
        return salaryMap;
    }


    public static void main(String[] args) {
        EmployeeCollection employeeCollection = new EmployeeCollection();


        //## Create Employee Collection Data
        System.out.println("Employee Collection Data: \n");
        List<EmployeeDetails> employeeList = employeeCollection.initializeEmployeeCollectionData();
        employeeCollection.displayEmployeeCollectionData(employeeList);


        //## Get Employee Details
        int empid = 2;
        System.out.println("\nEmployee Details of Employee ID: "+ empid);
        EmployeeDetails employeeDetails = employeeCollection.getEmployeeDetails(empid, employeeList);
        System.out.println("Employee Details: \n" + employeeDetails);


        //## Filter Employee List by Skills
        String skill = "Java";
        System.out.println("\nFiltered Employee List by Skills -> "+ skill);
        List<EmployeeDetails> filteredEmployeeList = employeeCollection.fileterBySkills(employeeList, skill);
        if (!filteredEmployeeList.isEmpty()) {
            employeeCollection.displayEmployeeCollectionData(filteredEmployeeList);
        }else {
            System.out.println("No Employee Found");
        }


        //## Get Salary Map
        System.out.println("\nSalary Map of Employee Collection");
        Map<Integer, Double> salaryMap = employeeCollection.getSalaryMap(employeeList);
        for (Map.Entry<Integer, Double> entry : salaryMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



        //## Sort Employee List
        System.out.println("\nSorted Employee List by id");
        Collections.sort(employeeList);
        employeeCollection.displayEmployeeCollectionData(employeeList);



        int id = 2;
        System.out.println("\nEmployee Details of Employee ID: "+ id);
        int index = Collections.binarySearch(employeeList, new EmployeeDetails(id, null, 0, null));
        System.out.println("Index of Employee Details with empid = " + id + " is: " + index);



        //## Sort Employee List by Name
        System.out.println("\nSorted Employee List by Name");
        // employeeList.sort(new EmployeeNameComparator());
        Collections.sort(employeeList, new EmployeeNameComparator());
        employeeCollection.displayEmployeeCollectionData(employeeList);



        String name = "Mary";
        System.out.println("\nEmployee Details of Employee Name: "+ name);
        index = Collections.binarySearch(employeeList, new EmployeeDetails(0, name, 0, null), new EmployeeNameComparator());
        System.out.println("Index of Employee Details with name " + name + " is: " + index);




        //## Sort Employee List by Salary
        System.out.println("\nSorted Employee List by Salary");
        // employeeList.sort(new EmployeeSalaryComparator());
        Collections.sort(employeeList, new EmployeeSalaryComparator());
        employeeCollection.displayEmployeeCollectionData(employeeList);


        double salary = 3000;
        System.out.println("\nEmployee Details of Employee Salary: "+ salary);
        index = Collections.binarySearch(employeeList, new EmployeeDetails(0, null, salary, null), new EmployeeSalaryComparator());
        System.out.println("Index of Employee Details with salary = " + salary + " is: " + index);


        System.out.println("\nMinimum Salary of Employee Collection");
        System.out.println(Collections.min(employeeList, new EmployeeSalaryComparator()));


        System.out.println("\nMaximum Salary of Employee Collection");
        System.out.println(Collections.max(employeeList, new EmployeeSalaryComparator()));



        //## Reverse Employee List

        System.out.println("\nReverse Employee List");
        Collections.reverse(employeeList);
        employeeCollection.displayEmployeeCollectionData(employeeList);
    }
}
