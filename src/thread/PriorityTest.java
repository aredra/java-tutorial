package thread;

class PriorityThread extends Thread {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t + " start!");

        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            sum += i;
        }

        System.out.println(t.getPriority() + " end");
    }
}

public class PriorityTest {

    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread();
        PriorityThread t2 = new PriorityThread();
        PriorityThread t3 = new PriorityThread();

        t1.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
