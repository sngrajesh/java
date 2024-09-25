package day1.lab.third;

public class Accounts {

    private int accid;
    private String name;
    private static float intrate;

    static {
        intrate = 6.0f;
        System.out.println("Block 1");
    }

    static {
        System.out.println("Block 2");
    }
    // Constructor can be private/other but it should not be created as a private/others (the compile will wont give any error if created with private)
    public Accounts(){
        // this.accid = 101;
        // this.name = "No User";
        // OR
        this(101,"No User");
        System.out.println("Un-parameterize");
    }
    public Accounts(int accid,  String name){
        this.accid = accid;
        this.name = name;
        System.out.println("Parameterize");
    }

    public static void displayInterestRate(){
        System.out.println("Current interest rate is : "+intrate);
    }
}
