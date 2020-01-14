package interfaceex;

public class BookShelf extends Shelf implements Queue {
    public BookShelf(String name) {
        super(name);
    }

    @Override
    public void enQueue(String title) {
        shelf.add(title);
    }

    @Override
    public String deQueue() {
        return shelf.remove(0);
    }

    @Override
    public int getQueueSize() {
        return getCountBook();
    }
}
