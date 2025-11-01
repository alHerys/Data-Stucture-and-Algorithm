package main.caseBinaryTree.morseDecoder;

public class Node {
    char data;
    Node kiri;
    Node kanan;

    public Node(char data) {
        this.data = data; 
        this.kiri = null;
        this.kanan = null;
    }
}
