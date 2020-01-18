package objectex;

class Book implements Cloneable {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //instance가 Heap Memory에서 해제될 때 GC가 호출하여 수행함
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}


public class ToStringTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        Book book = new Book("Harry Potter", "J.K.Rowling");
        System.out.println(book);

        Book cloneBook = (Book)book.clone();
        System.out.println(cloneBook);

        System.out.println(book.hashCode());
        System.out.println(cloneBook.hashCode());

        String java = new String("java");
        String android = new String("android");
        System.out.println(System.identityHashCode(java));

        java = java.concat(android);
        System.out.println(java);
        System.out.println(System.identityHashCode(java));
    }
}
