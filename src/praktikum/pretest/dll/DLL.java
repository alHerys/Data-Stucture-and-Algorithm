package praktikum.pretest.dll;

public class DLL<T> {
    private Node<T> head, tail;
    private int size = 0;

    void inisialisasi() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    // Penambahan
    void add(T input) {
        addLast(input);
    }

    void addFirst(T input) {
        Node<T> newNode = new Node<T>(input);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(T input) {
        Node<T> newNode = new Node<T>(input);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Penghapusan
    void removeFirst() {
        if (isEmpty()) {
            return;
        } else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    void removeLast() {
        if (isEmpty()) {
            return;
        } else if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    void removeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> current = _loopToIndex(index);

            current.next.prev = current.prev;
            current.prev.next = current.next;
            size--;
        }
    }

    void removeAll() {
        head = tail = null;
        size = 0;
    }

    // Penyisipan
    void addAtIndex(int index, T input) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index" + index + "tidak tersedia");
        }

        if (index == 0) {
            addFirst(input);
        } else if (index == size - 1) {
            addLast(input);
        } else {
            Node<T> newNode = new Node<T>(input);
            Node<T> current = _loopToIndex(index);

            newNode.next = current;
            newNode.prev = current.prev;

            current.prev.next = newNode;
            current.prev = newNode;

            size++;
        }
    }

    // Pencarian
    boolean isContain(T data) {
        switch (size) {
            case 0:
                return false;
            case 1:
                return head.data.equals(data);
            case 2:
                return (head.data.equals(data)) || (tail.data.equals(data));
        }

        Node<T> currentFirst = head;
        Node<T> currentLast = tail;

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

    int indexOf(T data) {
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    // Pengaksesan
    T getFirst() {
        return head.data;
    }

    T getLast() {
        return tail.data;
    }

    T getAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        }

        if (index == 0) {
            return getFirst();
        }

        if (index == size - 1) {
            return getLast();
        }

        Node<T> current = _loopToIndex(index);

        return current.data;
    }

    // Melakukan loop hingga ke elemen index
    // Berfungsi untuk menentukan apakah akan dilakukan loop dari head atau dari
    // tail
    private Node<T> _loopToIndex(int index) {
        Node<T> node;

        if (index <= size / 2.0) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    // Ini buat debug aja kak, buat print semua isi DLL nya
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
