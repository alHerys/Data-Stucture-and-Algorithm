package main.singlyLinkedList.real;

public class SinglyLinkedList {
    private Node last;
    private Node first;
    private Node assistant;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
        last = null;
        first = null;
    }

    public void add(int data) {
        size++;
        assistant = new Node(data);
        if (size > 1) {
            last.next = assistant;
            last = assistant;
        } else {
            first = assistant;
            last = assistant;
        }
    }

    public void addFirst(int data) {
        if (first == null) {
            add(data);
        }

        size++;
        assistant = new Node(data);
        assistant.next = first;
        first = assistant;
    }

    public void addLast(int data) {
        if (first == null) {
            add(data);
        }

        size++;
        assistant = new Node(data);
        last.next = assistant;
        last = assistant;
    }

    public void addAtIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size - 1) {
            addLast(data);
            return;
        }

        size++;
        Node newNode = new Node(data);
        assistant = first;

        for (int i = 0; i < index - 1; i++) {
            assistant = assistant.next;
        }

        newNode = assistant.next;
        assistant.next = newNode;
    }

    public void removeLast() {
        if (first == null) {
            return;
        }

        if (first.next != null) {
            size--;
            assistant = first;
            for (int i = 0; i < size - 1; i++) {
                assistant = assistant.next;
            }
            assistant.next = null;
            last = assistant;
        } else {
            size = 0;
            first = last = assistant = null;
        }
    }

    public void removeFirst() {
        if (first == null) {
            return;
        }

        if (first.next != null) {
            size--;
            first = first.next;
        } else {
            size = 0;
            first = last = assistant = null;
        }
    }

    public void removeAtIndex(int index) {
        if (first == null) {
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        assistant = first;
        for (int i = 0; i < index - 1; i++) {
            assistant = assistant.next;
        }

        Node selectedNode = assistant.next;
        assistant.next = selectedNode.next;
        selectedNode.next = null;
        size--;
    }

    public int getLast() {
        if (last == null) {
            return 0;
        }

        int data = last.data;
        removeLast();
        return data;
    }

    public int getFirst() {
        if (first == null) {
            return 0;
        }

        int data = first.data;
        removeFirst();
        return data;
    }

    public int getAtIndex(int index) {

        if (first == null) {
            return 0;
        }

        if (index == 0) {
            return getFirst();
        }

        if (index == size - 1) {
            return getLast();
        }

        assistant = first;
        int hasil = 0;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                hasil = assistant.data;
            }
            assistant = assistant.next;
        }

        removeAtIndex(index);
        return hasil;
    }

    public int peekLast() {
        if (last == null) {
            return 0;
        }

        return last.data;
    }

    public int peekFirst() {
        if (first == null) {
            return 0;
        }

        return first.data;
    }

    public int peekAtIndex(int index) {
        if (first == null) {
            return 0;
        }

        if (index == 0) {
            return peekFirst();
        }

        if (index == size - 1) {
            return peekLast();
        }

        assistant = first;
        int hasil = 0;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                hasil = assistant.data;
            }
            assistant = assistant.next;
        }

        return hasil;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        assistant = first;

        for (int i = 0; i < size; i++) {
            sb.append(assistant.data);
            if (i < size - 1) {
                sb.append(", ");
            }
            assistant = assistant.next;
        }
        sb.append("]");

        return sb.toString();
    }

}