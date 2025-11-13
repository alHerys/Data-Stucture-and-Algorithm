package praktikum.pretest.queue.doubleLinkedList;

import java.util.NoSuchElementException;

public class QueueDLL<E> {
    private NodeQueue<E> head; // Sebagai rear dari Queue
    private NodeQueue<E> tail; // Sebagai front dari Queue

    /**
     * Menambahkan element pada queue pada node head
     * @param data -> data yang hendak disikan ke node head
     */
    public void enqueue(E data) {
        NodeQueue<E> newNode = new NodeQueue<E>(data);
        if (head == null) {
            head = tail = newNode;  
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Mengambil dan menghapus data pada tail
     * @return data tail
     * @exception NoSuchElementException jika Queue kosong 
     */
    public E dequeue() {
        if (head == null) {
            throw new NoSuchElementException("## Queue Kosong");
        }

        E result;
        result = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Ini buat print semua isi DLL nya
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        NodeQueue<E> current = head;

        result.append(current.data);

        while (current.next != null) {
            result.append(", ");
            current = current.next;
            result.append(current.data);
        }

        result.append("]");
        return result.toString();
    }
}
