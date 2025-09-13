package main.singlyLinkedList.real;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList example = new SinglyLinkedList();

        example.add(0);
        example.add(1);
        example.add(2);
        example.add(3);
        example.add(4);
        example.add(5);

        System.out.println(example);

        example.addAtIndex(2, 7);

        System.out.println(example);

        System.out.println(example.getAtIndex(2));

        System.out.println(example);

        example.removeAtIndex(2);

        System.out.println(example);
    }
}