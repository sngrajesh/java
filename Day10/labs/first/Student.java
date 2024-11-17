package Day10.labs.first;

public class Student {
    private int rollNumber;
    private String name;

    public Student(){
        this.rollNumber = 0;
        this.name = "default";
    }

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public void displayData(){
        System.out.println("Student roll number: " + rollNumber);
        System.out.println("Student name: " + name);
    }

    private void privateMethod(){
        System.out.println("This is private method");
    }

    public static void staticMethod(){
        System.out.println("This is static method");
    }


    @CreatedBy(priority = 1, createdBy = "Student")
    public void getData() {
        System.out.println("Student roll number: " + rollNumber);
        System.out.println("Student name: " + name);
    }

    public void methodWithParameters(int rollNumber){
        this.rollNumber = rollNumber;
        System.out.println("Roll number set to: " + rollNumber);
    }
}
