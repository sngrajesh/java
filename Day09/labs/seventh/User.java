package Day09.labs.seventh;

public class User
{
    public static void main(String[] args) {
        Account account = new Account(10);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(30);
                System.out.println("Thread 1 deposited: " + account.getBalance());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(30);
                System.out.println("Thread 2 withdrew: " + account.getBalance());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        t2.start();
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}