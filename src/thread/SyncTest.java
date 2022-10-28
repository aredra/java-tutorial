package thread;

class Bank {
    private int money = 100000;

    public synchronized void saveMoney(int save) {
        int m = this.getMoney();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setMoney(m + save);
    }

    public synchronized void minusMoney(int minus) throws Exception {
        int m = this.getMoney();

        if (m < minus) {
            throw new Exception("Balance is lack");
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setMoney(m - minus);
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
}

class T1 extends Thread {
    public void run() {
        synchronized (SyncTest.myBank) {
            System.out.println("start save");
            SyncTest.myBank.saveMoney(4000);
            System.out.println(super.getName()+" result = "+SyncTest.myBank.getMoney());
        }
    }
}

class T2 extends Thread {
    public void run() {
        System.out.println("start minus");
        try {
            SyncTest.myBank.minusMoney(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(super.getName()+" result = "+SyncTest.myBank.getMoney());
    }
}

public class SyncTest {
    public static final Bank myBank = new Bank();
    public static void main(String[] args) throws InterruptedException{
        T1 t1 = new T1();
        t1.start();

        Thread.sleep(1000);

        T2 t2 = new T2();
        t2.start();
    }
}
