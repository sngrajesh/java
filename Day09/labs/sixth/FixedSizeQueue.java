package Day09.labs.sixth;

import java.util.NoSuchElementException;

public class FixedSizeQueue<T> {
    private T[] array;
    private int front, rear, size;
    private final int capacity;

    public FixedSizeQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        front = rear = size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(T element) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        array[rear] = element;
        rear = (rear + 1) % capacity;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = array[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[front];
    }

    public int size() {
        return size;
    }

}