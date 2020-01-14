package interfaceex;

public class BookShelfTest {
    public static void main(String[] args) {
        Queue bookQueue = new BookShelf("Fantasy");

        bookQueue.enQueue("Harry Potter");
        bookQueue.enQueue("Return of King");
        bookQueue.enQueue("Lord of Ring");

        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
        System.out.println(bookQueue.deQueue());
    }
}
