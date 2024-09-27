package Day7.labs.first;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStream {

    public List<Employee> initializeEmployeeStreamData() {
        List<Employee> employeelist = new ArrayList<>();
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

        Set<String> skillset5 = new TreeSet<>();
        skillset5.add("Java");
        skillset5.add("C++");
        skillset5.add("Python");
        skillset5.add("JavaScript");

        Set<String> skillset6 = new TreeSet<>();
        skillset6.add("C#");
        skillset6.add("Ruby");
        skillset6.add("Rails");
        skillset6.add("MySQL");
        skillset6.add("MongoDB");


        employeelist.add(new Employee(3, "Mary", 30000, "Admin", skillset3));
        employeelist.add(new Employee(2, "David", 20000, "IT", skillset2));
        employeelist.add(new Employee(6, "David", 60000, "IT", skillset6));
        employeelist.add(new Employee(5, "John", 50000, "HR", skillset5));
        employeelist.add(new Employee(4, "Peter", 40000, "Admin", skillset4));
        employeelist.add(new Employee(1, "John", 10000, "HR", skillset1));

        return employeelist;
    }

    public static void main(String[] args) {
        EmployeeStream e = new EmployeeStream();

        List<Employee> employeelist = e.initializeEmployeeStreamData();

        Stream<Employee> empstream;
        // empstream.forEach(System.out::println);

        System.out.println("\nEmployee sorted by name");
        Comparator<Employee> cmpbyname = Comparator.comparing(Employee::getName);
        empstream = employeelist.stream();
        empstream.sorted(cmpbyname).forEach(System.out::println);


        System.out.println("\nEmployee sorted by salary");
        Comparator<Employee> cmpbysalary = Comparator.comparing(Employee::getSalary);
        empstream = employeelist.stream();
        empstream.sorted(cmpbysalary).forEach(System.out::println);

        System.out.println("\nEmployee sorted List Department");
        empstream = employeelist.stream();
        empstream.sorted(Comparator.comparing(Employee::getDepartment)).forEach(System.out::println);


        System.out.println("\nFilter Employee List by Skills -> Java");
        empstream = employeelist.stream();
        empstream.filter(emp -> emp.getSkillset().contains("Java")).forEach(System.out::println);


        System.out.println("\nFilter Employee List by Salary -> 45000 to 50000");
        empstream = employeelist.stream();
        Predicate<Employee> salrange = emp -> (emp.getSalary() < 45000 & emp.getSalary() > 25000);
        empstream.filter(salrange).forEach(System.out::println);


        System.out.println("\nGrouping Employee by Department");
        empstream = employeelist.stream();
        Map<String, List<Employee>> groupedEmployee = employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedEmployee.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nGrouping Employee by Department with counting");
        empstream = employeelist.stream();
        Map<String, Long> groupedEmployee_count = employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        groupedEmployee_count.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nGrouping Employee by Department with Summing salary");
        Map<String, Double> groupedEmployeeCount = employeelist.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        groupedEmployeeCount.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\nEmployee Id with Department");
        empstream = employeelist.stream();
        empstream.map(em -> new Department(em.getEmpid(), em.getDepartment())).forEach(System.out::println);


        System.out.println("\nEmployee Total Salary");
        empstream = employeelist.stream();
        double salaryxpense = empstream.mapToDouble(Employee::getSalary).reduce(0.0, (a, b) -> a + b);
        System.out.println("Total Salary Expense -> " + salaryxpense);
    }
}
