package main.singlyLinkedList.real;

public class SinglyLinkedList {
    private Node akhir;
    private Node awal;
    private Node pembantu;
    private int ukuran;

    public SinglyLinkedList() {
        this.ukuran = 0;
        akhir = null;
        awal = null;
    }

    public void add(int data) {
        ukuran++;
        pembantu = new Node(data);
        if (ukuran > 1) {
            akhir.next = pembantu;
            akhir = pembantu;
        } else {
            awal = pembantu;
            akhir = pembantu;
        }
    }

    public void removeLast() {
        if (awal == null) {
            return;
        }

        if (awal.next != null) {
            ukuran--;
            pembantu = awal;
            for (int i = 0; i < --ukuran; i++) {
                pembantu = pembantu.next;
            }
            pembantu.next = null;
            akhir = pembantu;
        } else {
            ukuran = 0;
            awal = akhir = pembantu = null;
        }
    }

    public void removeFirst() {
        if (awal == null) {
            return;
        }

        if (awal.next != null) {
            ukuran--;
            awal = awal.next;
        } else {
            ukuran = 0;
            awal = akhir = pembantu = null;
        }
    }

    public void removeAtIndex(int index) {
        if (awal == null) {
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }
        
        if (index == ukuran - 1) {
            removeLast();
            return;
        }

        pembantu = awal;
        Node before = null, after = null;
        for (int i = 0; i <= index; i++) {
            if (i == index - 1) {
                before = pembantu;
            } else if (i == index) {
                after = pembantu;
            }
            pembantu = pembantu.next;
        }

        after.next = null;
        before.next = pembantu;
        ukuran--;
    }

    public int getLast() {
        if (akhir == null) {
            return 0;
        }

        int data = akhir.data;
        removeLast();
        return data;
    }

    public int getFirst() {
        if (awal == null) {
            return 0;
        }

        int data = awal.data;
        removeFirst();
        return data;
    }

    public int getAtIndex(int index) {

        if (awal == null) {
            return 0;
        }

        if (index == 0) {
            return getFirst();
        }

        if (index == ukuran - 1) {
            return getLast();
        }

        pembantu = awal;
        int hasil = 0;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                hasil = pembantu.data;
            }
            pembantu = pembantu.next;
        }

        removeAtIndex(index);
        return hasil;
    }

    public int peekLast() {
        if (akhir == null) {
            return 0;
        }

        return akhir.data;
    }

    public int peekFirst() {
        if (awal == null) {
            return 0;
        }

        return awal.data;
    }

    public int peekAtIndex(int index) {
        if (awal == null) {
            return 0;
        }

        if (index == 0) {
            return peekFirst();
        }

        if (index == ukuran - 1) {
            return peekLast();
        }

        pembantu = awal;
        int hasil = 0;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                hasil = pembantu.data;
            }
            pembantu = pembantu.next;
        }

        return hasil;
    }

    public void addAtIndex(int index) {

    }

    public void printList() {
        if (awal == null) {
            System.out.println("[]");
        }

        System.out.print("[");
        pembantu = awal;
        boolean isFirst = true;
        for (int i = 0; i < ukuran; i++) {
            if (!isFirst) {
                System.out.print(" ,");
            }
            isFirst = false;
            System.out.print(pembantu.data);
            pembantu = pembantu.next;
        }
        System.out.println("]");
    }
}
