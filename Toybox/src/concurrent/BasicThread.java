package concurrent;

public class BasicThread {
    public static void main(String... args) throws InterruptedException {
        Thread thread = new Thread(() ->  System.out.println("new thread invoked..."));
        thread.start();
        thread.join();
    }
}
