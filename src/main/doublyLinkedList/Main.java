package main.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println(list);

        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        System.out.println(list);

        System.out.println(list.contain(0));

        // System.out.println(list.getAtIndex(3));

        System.out.println(list.indexOf(1));

        System.out.println(list);

        list.removeAll();

        System.out.println(list);

        // list.addAtIndex(2, 2);

        // System.out.println(list);

        // list.removeFirst();
        
        // System.out.println(list);
        
        // list.removeLast();

        // System.out.println(list);

        // list.addFirst(5);

        // System.out.println(list);

        // list.addLast(9);

        // System.out.println(list);

        // list.removeAtIndex(2);

        // System.out.println(list);

    }
}
