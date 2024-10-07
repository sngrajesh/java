package Day9.labs.third;

public class Account {
    private double balance;
    public Account(int balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }
    public void withdraw(int ammount){
        this.balance-=ammount;
    }
}
