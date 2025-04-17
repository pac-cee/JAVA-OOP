// Demonstrates Thread, Runnable, and synchronized keyword
public class ThreadDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
    public static void main(String[] args) {
        // Using Thread subclass
        ThreadDemo t = new ThreadDemo();
        t.start();
        // Using Runnable
        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Runnable: " + i);
            }
        };
        Thread t2 = new Thread(task);
        t2.start();
        // Synchronized example
        Counter counter = new Counter();
        Thread inc1 = new Thread(() -> counter.incrementMany());
        Thread inc2 = new Thread(() -> counter.incrementMany());
        inc1.start();
        inc2.start();
    }
}
// Synchronized counter
class Counter {
    private int value = 0;
    public synchronized void increment() {
        value++;
    }
    public void incrementMany() {
        for (int i = 0; i < 1000; i++) increment();
        System.out.println("Final value: " + value);
    }
}
