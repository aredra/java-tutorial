package array;

public class ArrayTest {
    public static void main(String[] args) {
        char[] alpahbets = new char[26];
        char ch = 'A';
        Book[] books = new Book[5];
        Book[] books2 = new Book[5];

        for (int i = 0; i<alpahbets.length; i++) {
            alpahbets[i] = ch++;
            System.out.println(alpahbets);
        }

        for (int i = 0; i<books.length; i++) {
            books[i] = new Book("HaHa", "Aredra");
        }

        System.arraycopy(books, 0, books2, 0, 5);

        for (Book book : books2) {
            book.showBookInfo();
        }

    }
}
