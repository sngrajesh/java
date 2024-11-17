package Day05.labs.first.ass2;
import Day05.labs.first.ass2.Excpetions.*;
import java.util.ArrayList;

public class Accounts {
    protected ArrayList<User> users;

    public Accounts() {
        this.users = new ArrayList<>();
    }

    public String getNextAccountNumber() {
        return (this.users.size() + 1) + "";
    }

    public User getUser(String accountNumber) {
        User user = null;
        for (User u : this.users) {
            if (u.getAccountNumber().equals(accountNumber))
                user = u;
        }
        return user;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean authenticate(String accountNumber, String password) throws UserNotFoundException, InvalidCredentialException {
        User currentuser = this.getUser(accountNumber);
        if (currentuser == null)
            throw new UserNotFoundException("User not found");

        if (!currentuser.isValid(password))
            throw new InvalidCredentialException("Invalid credential");
        else
            return true;
    }

    public void deposit(int amount, String accountNumber) throws IncorrectDenominationException {
        User currentuser = this.getUser(accountNumber);
        if (amount < 0 || amount % 100 != 0){
            throw new IncorrectDenominationException("Invalid denomination");
        }
        else{
            currentuser.setBalance(currentuser.getBalance() + amount);
            System.out.println("Ammount deposited : " + amount + " to account " + accountNumber);
        }
    }


    public void withdraw(int amount, String accountNumber)
            throws InsufficientFundException,
            TransactionLimitExceededException,
            IncorrectDenominationException {

        User currentuser = this.getUser(accountNumber);
        if(currentuser.getTransactionLimit() < amount)
            throw new TransactionLimitExceededException("Transaction limit exceeded");

        else if (amount < 0 || amount % 100 != 0) {
            throw new IncorrectDenominationException("Invalid denomination");
        } else if (currentuser.getBalance() < amount) {
            throw new InsufficientFundException("Insufficient fund");
        } else {
            currentuser.setBalance(currentuser.getBalance() - amount);
            currentuser.setTransactionLimit(currentuser.getTransactionLimit() - amount);
            System.out.println("Ammount withdrawn : " + amount + " from account " + accountNumber);
        }
    }

    public void showBalanceWithAccountDetails(String accountNumber) {
        User currentuser = this.getUser(accountNumber);
        System.out.println("Account details : ");
        System.out.println("Account number : " + currentuser.getAccountNumber());
        System.out.println("Name : " + currentuser.getName());
        System.out.println("Balance : " + currentuser.getBalance());

    }


}
