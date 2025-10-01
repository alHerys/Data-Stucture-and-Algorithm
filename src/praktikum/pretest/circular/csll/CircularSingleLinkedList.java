package praktikum.pretest.circular.csll;

public class CircularSingleLinkedList {
    private NodeCSLL head, tail;

    public CircularSingleLinkedList() {
        head = null;
        tail = null;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCSLL newNode = new NodeCSLL(data);
        newNode.next = newNode;
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCSLL newNode = new NodeCSLL(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void hapusData(Object data) {
        if (head != null) {
            NodeCSLL prev, curr;
            prev = null;
            curr = head;

            boolean ketemu = false;

            do {
                if (curr.data.equals(data)) {
                    ketemu = true;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            } while (!ketemu && curr != head);

            if (ketemu) {
                if (head == tail) {
                    head = tail = null;
                } else if (prev == null) {
                    head = curr.next;
                    tail.next = head;
                } else {
                    if (tail == curr) {
                        tail = prev;
                    }
                    prev.next = curr.next;
                }
                curr = null;
            }
        }
    }

    public void hapusSatuDataDiAwal() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    public void hapusSatuDataDiAkhir() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        NodeCSLL curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }

        curr.next = head;
        tail = curr;
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);

        if (head == null) {
            return;
        }

        NodeCSLL curr;
        curr = head;

        do {
            System.out.print(curr.data + "->");
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }
}
