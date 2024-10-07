package Day9.labs.third;
import static java.lang.Thread.currentThread;

public class WithdrawJob implements Runnable{
    Account acc = new Account(10000);
    public synchronized void withdaw(int ammount){
        System.out.println();
        if(acc.getBalance() >= ammount){
            System.out.println(currentThread().getName()+ " is ready to withdraw from available ammount : " + acc.getBalance());
            System.out.println(currentThread().getName() + " is sleeeping");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(currentThread().getName() + " is wakes up");
            acc.withdraw(ammount);
            System.out.println(currentThread().getName()+ " ammount wothdrawed succesfully. Remaining balance : " + acc.getBalance());
        }else{
            System.out.println(currentThread().getName()+ " Does not have enough money");
        }
    }

    @Override
    public void run() {
        for (int i=0; i <3; i++){
            withdaw(2000);
        }
    }
}
