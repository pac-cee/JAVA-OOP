// Demonstrates using ExecutorService to run tasks in parallel
import java.util.concurrent.*;
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - Task " + i);
            }
        };
        executor.submit(task);
        executor.submit(task);
        executor.shutdown();
    }
}
