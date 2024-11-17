package Day05.labs.first.ass2;

public class User {
    private String name;
    private String accountNumber;
    private String password;
    private int balance;
    private int transactionLimit;

    public User(String name, String accountNumber, String password, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
        this.transactionLimit = 5000;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTransactionLimit() {
        return this.transactionLimit;
    }

    public void setTransactionLimit(int transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public boolean isValid(String password) {
        return this.password.equals(password);
    }
}
