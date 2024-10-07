package Day9.labs.sixth;


import static java.lang.Thread.sleep;

public class MyQueue {
    FixedSizeQueue<Integer> queue = new FixedSizeQueue(10);


    public synchronized void setValue(int value) throws InterruptedException {
        if (queue.isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.enqueue(value);
        notifyAll();
        System.out.println("setValue " + value);
    }

    public synchronized void getValue() throws InterruptedException {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value = queue.dequeue();
        notifyAll();
        System.out.println("getValue " + value);
    }

}
