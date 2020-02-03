package thread;

public class InterruptTest extends Thread {
    public void run(){
        int i = 0;
        for (i=0; i<100; i++) {
            System.out.println(i);
        }

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("!!!");
        }
    }

    public static void main(String[] args) {
        InterruptTest it = new InterruptTest();

        System.out.println("test");
        it.start();
        it.interrupt();
        System.out.println("end");
    }
}
