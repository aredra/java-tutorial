package dataStructure;

public class MyLinkedList {

    private MyListNode head;
    int count;

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public MyListNode addElement(String data) {
        MyListNode newNode;

        if (head == null) {
            newNode = new MyListNode(data);
            head = newNode;
        } else {
            newNode = new MyListNode(data);
            MyListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
        return newNode;
    }

    public MyListNode insertElement(int position, String data) {
        int index;
        MyListNode tempNode = head;
        MyListNode prevNode = null;
        MyListNode newNode = new MyListNode(data);

        if ( position < 0 || position > count) {
            return null;
        }

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            for (index = 0; index < position; index++) {
                prevNode = tempNode;
                tempNode = tempNode.next;
            }
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        count++;
        return newNode;
    }

    public MyListNode removeElement(int position) {
        int index;
        MyListNode tempNode = head;
        MyListNode prevNode = null;

        if ( position < 0 || position > count) {
            return null;
        }

        if (position == 0) {
            head = tempNode.next;
        } else {
            for (index = 0; index < position; index++) {
                prevNode = tempNode;
                tempNode = tempNode.next;
            }
            prevNode.next = tempNode.next;
        }
        count--;
        return tempNode;
    }

    public String getElement(int position) {
        int index;
        MyListNode tempNode = head;

        if ( position < 0 || position > count) {
            return null;
        }

        for (index = 0; index < position; index++) {
            tempNode = tempNode.next;
        }

        return tempNode.getData();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        MyListNode tempNode = head;

        for (int index = 0; index < count; index++) {
            builder.append(index == 0 ? tempNode.getData() :
                    "->" + tempNode.getData());
            tempNode = tempNode.next;
        }

        return builder.toString();
    }
}
