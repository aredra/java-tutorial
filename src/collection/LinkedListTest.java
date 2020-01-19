package collection;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");

        System.out.println(myList);
        myList.add(1, "d");
        System.out.println(myList);

        for (String el : myList) {
            String str = el;
            System.out.println(str);
        }
    }
}
