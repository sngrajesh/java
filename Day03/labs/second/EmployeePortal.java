package Day3.labs.second;

public class EmployeePortal {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();

        SalariedEmployee se = new SalariedEmployee("Ramesh", 7, 14000);
        payroll.displayGross(se);
        payroll.displayNet(se);
        System.out.println();

        Employee[] emps = new Employee[3];
        emps[0] = new SalariedEmployee("ppp", 22, 40000);
        emps[1] = new Manager("pwp", 12, 40000, 78000);
        emps[2] = new ContractEmployee("qwp", 12, 65, 16);

        for (Employee emp : emps) {
            payroll.displayGross(emp);
            if (emp instanceof SalariedEmployee ss) {
                payroll.displayNet(ss);
                if(ss instanceof Manager es){
                    es.displayAllawance();
                }
            }
            else {
                System.out.println("Not a salaried employee, net salary not applicable.");
            }
            System.out.println();
        }
    }
}
