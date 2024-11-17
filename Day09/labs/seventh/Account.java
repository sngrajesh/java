package Day09.labs.seventh;

/*
Create account class with deposite and withdraw method
The withdrawal method should wait for deposite if funds are insufficient
Amount should be withdrawn only if balance > amount
 */
public class Account {
    private int balance;

    public Account(int initialBalance) {
        balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        notifyAll();
    }

    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            try {
                System.out.println("Deposite ammount first");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}