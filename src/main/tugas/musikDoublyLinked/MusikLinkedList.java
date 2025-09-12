package main.tugas.musikDoublyLinked;

public class MusikLinkedList {
    private int size;
    private MusikNode awal;
    private MusikNode baru;
    private MusikNode akhir;

    public void add(int data) {
        akhir = new MusikNode(data);
    }
}
