package main.tugas.musikDoublyLinked;

public class MusikNode {
    int data;
    MusikNode selanjutnya;
    MusikNode sebelumnya;

    public MusikNode(int data) {
        this.data = data;
        this.selanjutnya = null;
        this.sebelumnya = null;
    }
}
