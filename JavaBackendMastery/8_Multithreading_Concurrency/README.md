# 8. Multithreading & Concurrency

## Overview
Learn how to run tasks in parallel in Java: threads, synchronization, executors, and concurrent collections.

## Topics
- Threads and Runnable
- Synchronization, locks
- Executors, thread pools
- Concurrent collections
- Atomic classes

## Example: Thread
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
// Usage:
MyThread t = new MyThread();
t.start();
```

## Exercise
- Create a thread that prints numbers 1-5.
- Use an ExecutorService to run multiple tasks in parallel.

Continue to 9_FileIO_Serialization_Networking after this.
