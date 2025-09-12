package main.singlyLinkedList.real;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<>();
        
        SinglyLinkedList example = new SinglyLinkedList();

        example.add(0);
        example.add(1);
        example.add(2);
        example.add(3);
        example.add(4);
        example.add(5);

        example.printList();

        example.addAtIndex(2, 7);

        example.printList();

        example.removeAtIndex(2);

        example.printList();
    }
}
