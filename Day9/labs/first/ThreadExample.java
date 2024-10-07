package Day9.home.first;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {

        // Using extend thread
        Thread t1 = new Thread1();
        t1.setName("One");

        // Using implement Runnable
        Thread t2 = new Thread(new Thread2());
        t2.setName("Two");

        t1.start();
        t2.start();

        // Anonymous Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Anonmous " + Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        })
        //.start()
        ;



        // Using lambda
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Lambda " + Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })
        //.start()
        ;


        System.out.println("t1 alive: " + t1.isAlive());
        System.out.println("t2 alive: " + t2.isAlive());
        // Thread in the main method
        for (int i = 0; i < 10; i++) {
            System.out.println("Main " + Thread.currentThread().getName() + " " + i);
            if (i == 5) {
                Thread.yield();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
