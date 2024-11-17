package Day09.labs.first;

public class Thread1 extends Thread{


    @Override
    public void run() {
        for(int i = 0; i < 10 ; i++){
            System.out.println("Thread-1 " + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
