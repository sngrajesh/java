package Day09.labs.fifth;

public class MyQueue {
    int value;
    boolean hasValue;

    public synchronized void setValue(int value) {
        if (hasValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        hasValue = true;
        this.value = value;
        System.out.println("setValue " + value);
    }

    public synchronized void getValue() {
        while (!hasValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        hasValue = false;
        System.out.println("getValue " + value);
    }

}
