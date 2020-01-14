package interfaceex;

import java.util.ArrayList;

public class Shelf {
    protected ArrayList<String> shelf;
    private String shelfName;

    public Shelf(String name) {
        this.shelfName = name;
        shelf = new ArrayList<String>();
    }

    public ArrayList<String> getShelf() {
        return shelf;
    }

    public int getCountBook() {
        return shelf.size();
    }
}
