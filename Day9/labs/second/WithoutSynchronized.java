package Day9.labs.second;

public class SynchronizedExample1 {
    public static void main(String[] args) {
        Counter c = new Counter();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                c.incerement();
                System.out.println("Thread-1 " + Thread.currentThread().getName() + " " + c.getCount());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                c.incerement();
                System.out.println("Thread-2 " + Thread.currentThread().getName() + " " + c.getCount());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
