package thread;

import java.io.IOException;

public class TerminateThread extends Thread{
    private boolean flag = false;
    int i;

    public TerminateThread(String name) {
        super(name);
    }

    public void run() {
        while (!flag) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(super.getName() + " is end");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws IOException {
        TerminateThread th1 = new TerminateThread("A");
        TerminateThread th2 = new TerminateThread("B");

        th1.start();
        th2.start();

        int in;
        while(true) {
            in = System.in.read();
            if ( in == 'A') {
                th1.setFlag(true);
            }
            else if (in == 'B') {
                th2.setFlag(true);
            }
            else if (in == 'M'){
                th1.setFlag(true);
                th2.setFlag(true);
                break;
            }
            else System.out.println("Try another letter");
        }
        System.out.println("Main end");
    }
}
