package main.singlyLinkedList.real;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList example = new SinglyLinkedList();

        example.add(0);
        example.add(1);
        example.add(2);
        example.add(3);
        example.add(4);

        example.printList();

        example.removeLast();

        example.printList();
    }
}
