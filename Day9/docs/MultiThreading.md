### Multithreading in Java

Multithreading in Java is a powerful tool for performing multiple tasks concurrently. Java’s `java.lang.Thread` class and `java.util.concurrent` package provide comprehensive support for multithreading and concurrency. This guide will walk you through the key concepts and provide detailed instructions for implementing multithreading.

---

### Table of Contents:
1. **What is Multithreading?**
2. **Multithreading vs. Multiprocessing**
3. **Java Thread Class**
4. **Creating Threads in Java**
    - Extending the `Thread` class
    - Implementing the `Runnable` interface
5. **Thread Lifecycle**
6. **Thread Methods**
7. **Thread Synchronization**
    - Synchronized Methods
    - Synchronized Blocks
    - `wait()`, `notify()`, and `notifyAll()`
8. **Thread Pools and the Executor Framework**
9. **Concurrency Utilities**
    - `Callable` and `Future`
    - `Locks`
    - `CountDownLatch`
    - `CyclicBarrier`
    - `Semaphore`
    - `BlockingQueue`
10. **Best Practices**
---

### 1. What is Multithreading?

Multithreading refers to the ability of a CPU to execute multiple threads concurrently. A thread is a lightweight sub-process, the smallest unit of processing. In Java, multithreading is achieved by extending the `Thread` class or implementing the `Runnable` interface.

Multithreading allows:
- Efficient CPU utilization.
- Enhanced performance, especially in multi-core processors.
- The ability to perform background tasks without interrupting the main thread, like UI handling.

---

### 2. Multithreading vs. Multiprocessing

- **Multithreading:** Multiple threads within a single process share the same memory but execute concurrently.
- **Multiprocessing:** Multiple processes run concurrently, each with its own memory space.

---

### 3. Java `Thread` Class

The `Thread` class in Java provides constructors and methods to manage threads, including:
- **Constructors**:
    - `Thread()`
    - `Thread(Runnable target)`
    - `Thread(Runnable target, String name)`

- **Important Methods**:
    - `start()`: Starts a new thread.
    - `run()`: The entry point for the thread. This should be overridden in subclasses or when using `Runnable`.
    - `sleep(long millis)`: Pauses the thread for the specified time.
    - `join()`: Waits for the thread to finish execution.
    - `interrupt()`: Interrupts a thread.

---

### 4. Creating Threads in Java

There are two main ways to create threads:

#### a. Extending the `Thread` Class
Subclass the `Thread` class and override the `run()` method.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Starts the thread, which will invoke the run() method.
    }
}
```

#### b. Implementing the `Runnable` Interface
This is preferred for most cases since Java doesn't support multiple inheritance.

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

---

### 5. Thread Lifecycle

A thread in Java can be in one of the following states:
- **New**: After a thread object is created but before `start()` is called.
- **Runnable**: After `start()` is called, but before the thread actually runs.
- **Blocked**: Waiting for a monitor lock.
- **Waiting**: Waiting indefinitely for another thread to perform a specific action.
- **Timed Waiting**: Waiting for a specific amount of time.
- **Terminated**: After the thread's `run()` method completes execution.

![Thread Lifecycle](https://d2jdgazzki9vjm.cloudfront.net/core/images/life-cycle-of-a-thread.png)

---

### 6. Thread Methods

Some key methods used in thread management:

- `start()`: Begins the execution of a thread.
- `sleep(long millis)`: Causes the current thread to sleep for a specified period.
- `yield()`: Causes the current thread to temporarily pause and allow other threads to execute.
- `join()`: Waits for another thread to finish.
- `interrupt()`: Interrupts a thread that is sleeping or waiting.

Example of `join()`:

```java
public class JoinExample extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        JoinExample t1 = new JoinExample();
        JoinExample t2 = new JoinExample();
        t1.start();
        t1.join();  // Ensures t1 completes before t2 starts
        t2.start();
    }
}
```

---

### 7. Thread Synchronization

Synchronization is used to control the access of multiple threads to shared resources to prevent thread interference and data inconsistency.

#### a. Synchronized Methods

```java
class Counter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}
```

#### b. Synchronized Blocks
Instead of synchronizing the entire method, you can synchronize only a block of code.

```java
class Counter {
    private int count = 0;
    
    public void increment() {
        synchronized(this) {
            count++;
        }
    }
    
    public int getCount() {
        return count;
    }
}
```

#### c. `wait()`, `notify()`, and `notifyAll()`
These methods allow threads to communicate with each other while using synchronized blocks.

```java
class Shared {
    synchronized void waitMethod() throws InterruptedException {
        wait(); // Thread waits until notified
    }
    
    synchronized void notifyMethod() {
        notify(); // Wakes up a waiting thread
    }
}
```

---

### 8. Thread Pools and the Executor Framework

Managing thread creation can be complex. Java provides an Executor framework to create thread pools for better management.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

---

### 9. Concurrency Utilities

Java provides several utilities in the `java.util.concurrent` package for managing concurrency:

#### a. `Callable` and `Future`
The `Callable` interface is similar to `Runnable`, but it can return a value and throw exceptions.

```java
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Callable<Integer> task = () -> {
            return 123;
        };
        
        Future<Integer> future = executor.submit(task);
        System.out.println(future.get()); // Waits for the result
        
        executor.shutdown();
    }
}
```

#### b. `Locks`
`ReentrantLock` provides explicit locking mechanisms.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

#### c. `CountDownLatch`
Used to wait for a set of threads to complete.

```java
import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private CountDownLatch latch;
    
    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }
    
    public void run() {
        // Perform some work
        latch.countDown();  // Decrement the count of latch
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new Worker(latch).start();
        new Worker(latch).start();
        new Worker(latch).start();
        
        latch.await();  // Waits until the count reaches zero
        System.out.println("All workers are done");
    }
}
```

#### d. `CyclicBarrier`
Useful for creating barriers for a group of threads to wait until all threads reach a common point.

#### e. `Semaphore`
A counting semaphore is used to control access to a resource with a fixed number of permits.

#### f. `BlockingQueue`
A thread-safe queue that supports operations such as `take()` and `put()`.

---

### 10. Best Practices

1. **Use `ExecutorService` over manually creating threads**: It manages thread lifecycle and pooling efficiently.
2. **Avoid unnecessary synchronization**: Over-synchronization can cause performance issues.
3. **Use thread-safe collections**: Like `ConcurrentHashMap`, `CopyOnWriteArrayList` instead of `synchronized` blocks for collections.
4. **Graceful Shutdown**: Always shut down thread