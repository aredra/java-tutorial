package dataStructure;

public class DataStructureTest {

    public static void main(String[] args) {
//        MyArray arr = new MyArray(5);
//        System.out.println(arr.getSize());
//        arr.addElement(0);
//        arr.addElement(1);
//        arr.addElement(2);
//        arr.addElement(3);
//        System.out.println(arr);
//
//        arr.removeElement(1);
//        System.out.println(arr);
//
//        arr.insertElement(1,1);
//        System.out.println(arr);
//        arr.insertElement(1,5);
//        System.out.println(arr);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addElement("A");
        myLinkedList.addElement("B");
        System.out.println(myLinkedList);
        myLinkedList.insertElement(1, "a");
        System.out.println(myLinkedList);

        MyArrayStack stack = new MyArrayStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);

        MyLinkedQueue queue = new MyLinkedQueue();
        queue.enQueue("A");
        queue.enQueue("a");
        queue.enQueue("B");
        queue.enQueue("b");
        queue.enQueue("C");
        System.out.println(queue);
        System.out.println(queue.deQueue());
        System.out.println(queue);
    }
}
