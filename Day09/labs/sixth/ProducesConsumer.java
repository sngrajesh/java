package Day09.labs.sixth;

public class ProducesConsumer {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.setValue(i);
                } catch (RuntimeException | InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.getValue();
                } catch (RuntimeException | InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
