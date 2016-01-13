package thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        Thread t1 = new Thread(waiter, "waiter1");
        t1.start();
        Waiter waiter1 = new Waiter(msg);
        Thread t2 = new Thread(waiter1, "waiter2");
        t2.start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        t1.join();
        System.out.println("All the threads are started.");
        Thread.sleep(1000);
//        t2.join();
        t2.interrupt();
    }
}
