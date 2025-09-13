package main.doublyLinkedList;

public class DoublyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void add(int data) {
        addLast(data);
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int data) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = _loopToIndex(index);

        newNode.next = current;
        newNode.prev = current.prev;

        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            first = last = null;
            size--;
        }

        first = first.next;
        first.prev = null;
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            first = last = null;
            size--;
        } else {
            last = last.prev;
            last.next = null;
            size--;
        }
    }

    public void removeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        Node current = _loopToIndex(index);

        current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;
    }

    public boolean contain(int data) {

        switch (size) {
            case 0:
                return false;
            case 1:
                return first.data == data;
            case 2:
                return (first.data == data) || (last.data == data);
        }

        Node currentFirst = first;
        Node currentLast = last;

        while (currentFirst.data != data && currentLast.data != data) {
            if (currentFirst == currentLast) {
                return false;
            }

            if (currentFirst.next == currentLast) {
                return false;
            }

            currentFirst = currentFirst.next;
            currentLast = currentLast.prev;
        }

        return true;
    }

    public int indexOf(int data) {
        Node current = first;

        for (int i = 0; i < size; i++) {
            if (current.data == data) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    public int takeFirst() {
        int result = first.data;
        removeFirst();
        return result;
    }

    public int takeLast() {
        int result = last.data;
        removeLast();
        return result;
    }

    public int takeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        }

        if (index == 0) {
            return takeFirst();
        }

        if (index == size - 1) {
            return takeLast();
        }

        Node current = _loopToIndex(index);

        int result = current.data;

        current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;

        return result;
    }

    public int peekFirst() {
        int result = first.data;
        return result;
    }

    public int peekLast() {
        int result = last.data;
        return result;
    }

    public int peekAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        }

        if (index == 0) {
            return takeFirst();
        }

        if (index == size - 1) {
            return takeLast();
        }

        Node current = _loopToIndex(index);

        return current.data;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void removeAll() {
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        Node current = first;

        result.append(current.data);

        while (current.next != null) {
            result.append(", ");
            current = current.next;
            result.append(current.data);
        }

        result.append("]");
        return result.toString();
    }

    private Node _loopToIndex(int index) {
        Node node;

        if (index <= size / 2.0) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

}