package main.tugas.playlist;

public class DoublyPlaylist {
    private Node first;
    private Node last;
    private Node selectedMusic;
    private int size;

    public DoublyPlaylist() {
        this.size = 0;
    }

    public void add(Music music) {
        addLast(music);
    }

    public void addFirst(Music music) {
        Node newNode = new Node(music);
        if (size == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;

    }

    public void addLast(Music music) {
        Node newNode = new Node(music);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, Music music) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is not available", index));
        }

        if (index == 0) {
            addFirst(music);
            return;
        }

        if (index == size) {
            addLast(music);
            return;
        }

        Node newNode = new Node(music);
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
        } else if (size == 1) {
            first = last = null;
            size--;
        } else {
            first = first.next;
            first.prev = null;
            size--;
        }
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

    public boolean check(Music music) {
        switch (size) {
            case 0:
                return false;
            case 1:
                return first.music == music;
            case 2:
                return (first.music == music) || (last.music == music);
        }

        Node currentFirst = first;
        Node currentLast = last;

        while (currentFirst.music != music && currentLast.music != music) {
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

    public int indexOf(Music music) {
        Node current = first;

        for (int i = 0; i < size; i++) {
            if (current.music == music) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    public Music takeFirst() {
        Music result = first.music;
        removeFirst();
        return result;
    }

    public Music takeLast() {
        Music result = last.music;
        removeLast();
        return result;
    }

    public Music takeAtIndex(int index) {
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

        Music result = current.music;

        current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;

        return result;
    }

    public Music peekFirst() {
        if (size == 0) {
            return null;
        }

        Music result = first.music;
        return result;
    }

    public Music peekLast() {
        if (size == 0) {
            return null;
        }

        Music result = last.music;
        return result;
    }

    public Music peekAtIndex(int index) {
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

        return current.music;
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

    public void selectMusic() {
        
    }

    public void nextMusic() {
        
    }

    public void prevMusic() {

    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        Node current = first;

        result.append(current.music);

        while (current.next != null) {
            result.append(", ");
            current = current.next;
            result.append(current.music);
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