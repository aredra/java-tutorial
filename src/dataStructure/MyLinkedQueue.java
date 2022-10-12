package dataStructure;

interface Queue {
    public void enQueue(String data);
    public String deQueue();
}

public class MyLinkedQueue extends MyLinkedList implements Queue {

    MyListNode front;
    MyListNode rear;

    @Override
    public void enQueue(String data) {

        MyListNode newNode = addElement(data);

        if (front == null) {
            front = newNode;
        }
        rear = newNode;

        System.out.println(super.toString());
    }

    @Override
    public String deQueue() {

        if (isEmpty()) {
            return null;
        }

        MyListNode front = removeElement(0);
        String data = front.getData();
        this.front = front.next;

        if (this.front == null) {
            rear = null;
        }

        return data;
    }
}
