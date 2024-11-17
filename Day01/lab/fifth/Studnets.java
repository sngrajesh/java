package Day01.lab.fifth;

public class Studnets {
    private static int total;
    private int roll;
    private String name;
    static {
        total = 0;
    }
    public Studnets(String name){
        this.name= name;
        total+=1;
        this.roll= total;
    }

    public int getRoll(){
        return this.roll;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static int getTotal(){
        return total;
    }

    public String toString(){
        return "Roll : "+ this.roll + " Name : " + this.name;
    }
}
