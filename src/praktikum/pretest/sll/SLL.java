package praktikum.pretest.sll;

import java.util.NoSuchElementException;

public class SLL<T> {
    private Node<T> head, tail;
    private int size = 0;

    void inisialisasi() {
        head = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    // Penambahan
    void addFirst(T input) {
        Node<T> newNode = new Node<>(input);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast(T input) {
        Node<T> newNode = new Node<>(input);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    // Penghapusan
    void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List kosong");
        }

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }

        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List kosong");
        }

        if (size == 1) {
            tail = head = null;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }

            current.next = null;
            tail = current;
        }

        size--;
    }

    void removeAtIndex(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("List kosong");
        }

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " tidak ada");
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            current.next = current.next.next;
            size--;
        }
    }

    void clear() {
        tail = head = null;
        size = 0;
    }

    // Penyisipan
    void addAtIndex(int index, T input) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " tidak tersedia");
        }

        if (index == 0) {
            addFirst(input);
        } else if (index == size - 1) {
            addLast(input);
        } else {
            Node<T> newNode = new Node<T>(input);

            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Pencarian
    int indexOf(T input) {
        Node<T> current = head;
        int index = 0;
        while (current.data != input) {
            if (current.next == null) {
                return -1;
            }
            current = current.next;
            index++;
        }
        return index;
    }

    boolean contain(T input) {
        Node<T> current = head;
        while (current.data != input) {
            if (current.next == null) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Pengaksesan
    T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List kosong");
        }

        return head.data;
    }

    T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List kosong");
        }

        return tail.data;
    }

    T getAtIndex(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("List kosong");
        }

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " tidak tersedia");
        }

        if (index == 0) {
            return getFirst();
        } else if (index == size - 1) {
            return getLast();
        } else {
            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.data;
        }
    }

    // Ini buat debug aja kak, buat print semua isi SLL nya
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        Node<T> current = head;
        for (int i = 0; current != null; i++) {
            sb.append(i + " ");
            sb.append(current.data + "\n");
            current = current.next;
        }

        return sb.toString();
    }
}