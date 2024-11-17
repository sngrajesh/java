package Day09.labs.first;

public class Thread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10 ; i++){
            System.out.println("Thread-2 " + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
