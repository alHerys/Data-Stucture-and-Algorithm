package praktikum.pretest.queue.doubleLinkedList;

public class NodeQueue<E> {
    E data;
    NodeQueue<E> next;
    NodeQueue<E> prev;

    public NodeQueue(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
