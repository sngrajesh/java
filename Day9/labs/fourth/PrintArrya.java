package Day9.labs.fourth;

public class PrintArrya implements Runnable {

    final char[] greeting = {'G', 'o', 'o', 'd', ' ', 'M', 'o', 'r', 'n', 'i', 'n', 'g'};

    @Override
    public void run() {
        synchronized (greeting) {
            System.out.println();
            for (char c : greeting){
                System.out.print(c);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

