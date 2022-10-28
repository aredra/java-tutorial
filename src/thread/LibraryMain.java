package thread;

import java.util.ArrayList;

class FastLibrary {
    public ArrayList<String> books = new ArrayList<>();

    public FastLibrary() {
        books.add("A");
        books.add("B");
        books.add("C");
//        books.add("D");
//        books.add("E");
//        books.add("F");
    }

    public synchronized String lendBook() throws InterruptedException{
        Thread th = Thread.currentThread();
        while (books.size() == 0) {
            System.out.println(th.getName() + " waiting start");
            wait();
            System.out.println(th.getName() + " waiting end");
        }
        String title = books.remove(0);
        System.out.println(th.getName() + " lend : " + title);
        return title;
    }

    public synchronized void returnBook(String title) {
        Thread th = Thread.currentThread();
        books.add(title);
        notifyAll();
        System.out.println(th.getName() + " return : " + title);
    }
}

class Person extends Thread {
    public void run() {
        try {
            String title = LibraryMain.library.lendBook();
            sleep(2000);
            LibraryMain.library.returnBook(title);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LibraryMain {
    public static FastLibrary library = new FastLibrary();
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        Person p5 = new Person();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}
