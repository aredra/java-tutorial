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
    }
}
