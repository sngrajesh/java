package Day09.labs.third;

public class AccountProcess {
    public static void main(String[] args) {
         WithdrawJob job = new WithdrawJob();
         Thread t1 = new Thread(job);
         Thread t2 = new Thread(job);
         t1.setName("Husband");
         t2.setName("Wife");
         t1.start();
         t2.start();
    }
}
