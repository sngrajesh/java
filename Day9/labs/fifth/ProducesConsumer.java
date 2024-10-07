package Day9.labs.fifth;

public class ProducesConsumer {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.setValue(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.getValue();
            }
        }).start();
    }
}
