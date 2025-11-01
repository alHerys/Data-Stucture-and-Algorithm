package main.caseBinaryTree.morseEncoder;

public class Node {
    String data;
    Node kiri;
    Node kanan;

    public Node(String data) {
        this.data = data;
        this.kiri = null;
        this.kanan = null;
    }
}
