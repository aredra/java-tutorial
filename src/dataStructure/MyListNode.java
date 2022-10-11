package dataStructure;

public class MyListNode {

    private String data;
    public MyListNode next;

    public MyListNode(String data) {
        this.data = data;
    }

    public MyListNode(String data, MyListNode next) {
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return this.data;
    }
}
