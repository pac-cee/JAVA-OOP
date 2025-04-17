// Demonstrates creating and running a thread
public class ThreadDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        t.start();
    }
}
