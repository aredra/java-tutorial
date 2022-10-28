package thread;

class MyThread implements Runnable {
//    extends Thread
//    public void run() {
//        int i;
//
//        for (i=0; i<=200; i++) {
//            System.out.println(i);
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run() {
        int i;

        for (i=0; i<=200; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread t = Thread.currentThread();
        System.out.println(t);
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("start");
        MyThread runner1 = new MyThread();
        Thread th1 = new Thread(runner1);

        MyThread runner2 = new MyThread();
        Thread th2 = new Thread(runner2);

        th1.start();
        th2.start();

        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.println("end");
    }
}

// sleep, wait, join runnable -> non runnable
//