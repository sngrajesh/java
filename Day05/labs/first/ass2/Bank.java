package Day05.labs.first.ass2;

import Day05.labs.first.ass2.Excpetions.*;

import java.util.Scanner;

public class Bank {
    protected Accounts accounts;

    public Bank() {
        this.accounts = new Accounts();
    }

    public void openAccount(Scanner scanner) {
        String accountNumber = accounts.getNextAccountNumber();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        int balance = 0;
        User user = new User(name, accountNumber, password, balance);
        accounts.addUser(user);
        System.out.println("Account created with account number: " + accountNumber);
    }

    public void deposit(Scanner scanner, String accountNumber) {
        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();
        try {
            accounts.deposit(amount, accountNumber);
        } catch (IncorrectDenominationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error!!!");
        }
    }

    public void withdraw(Scanner scanner, String accountNumber) {
        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();
        try {
            accounts.withdraw(amount, accountNumber);
        } catch (InsufficientFundException | TransactionLimitExceededException | IncorrectDenominationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error!!!");
        }
    }

    public void accountRelatedTransactions(Scanner scanner) {
        try {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Account details");
            System.out.println("_. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();

            switch (choice) {
                case 1:
                    deposit(scanner, accountNumber);
                    break;
                case 2:
                    System.out.print("\nEnter password: ");
                    String password = scanner.nextLine();
                    if (accounts.authenticate(accountNumber, password)) {
                        withdraw(scanner, accountNumber);
                    }
                    break;
                case 3:
                    System.out.print("\nEnter password: ");
                    String password1 = scanner.nextLine();
                    if (accounts.authenticate(accountNumber, password1)) {
                        accounts.showBalanceWithAccountDetails(accountNumber);
                    }
                    break;
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }
        } catch (InvalidCredentialException | UserNotFoundException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        boolean run = true;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Open an account");
            System.out.println("2. Account related Transactions");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bank.openAccount(scanner);
                    break;
                case "2":
                    bank.accountRelatedTransactions(scanner);
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}
