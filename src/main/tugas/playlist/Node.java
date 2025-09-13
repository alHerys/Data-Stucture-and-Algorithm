package main.tugas.playlist;

public class Node {
    Music music;
    Node next;
    Node prev;

    public Node(Music music) {
        this.music = music;
        this.next = null;
        this.prev = null;
    }
}
