package praktikum.pretest.circular.cdll;

public class CircularDoubleLinkedList {
    private NodeCDLL head;

    private int size;

    public CircularDoubleLinkedList() {
        head = null;
        size = 0;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL newNode = new NodeCDLL(data);
        newNode.prev = newNode;
        newNode.next = newNode;
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCDLL newNode = new NodeCDLL(data);
        newNode.prev = newNode;
        newNode.next = newNode;

        if (head == null) {
            head = newNode;
        } else {
            NodeCDLL tail = loopToEnd();
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }

        size++;

    }

    public void hapusData(Object data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
            size--;
            return;
        }

        NodeCDLL curr = head.next;
        do {

            if (curr.data.equals(data)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                curr = null;
                size--;
                return;
            }
            curr = curr.next;

        } while (curr != head);
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        NodeCDLL curr;
        curr = head;
        int i = 0;
        while ((i < size)) {
            System.out.print(curr.data + "->");
            curr = curr.next;
            i++;
        }
        System.out.println();
    }

    

    private NodeCDLL loopToEnd() {
        NodeCDLL curr = head;

        while (curr.next != head) {
            curr = curr.next;
        }

        return curr;
    }

    public int getSize() {
        return size;
    }
}