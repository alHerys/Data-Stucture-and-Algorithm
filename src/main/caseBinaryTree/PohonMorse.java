package main.caseBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PohonMorse {
    private static Node root;
    private static String urutanPohonMorse = "ETIANMSURWDKGOHVF L PJ BXC YZQ";

    static {
        root = new Node(' ');

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root); 

        for (char huruf : urutanPohonMorse.toCharArray()) {

            Node nodeSekarang = nodes.peek();

            if (nodeSekarang.kiri == null) {

                nodeSekarang.kiri = new Node(huruf);
                nodes.add(nodeSekarang.kiri); 

            } else if (nodeSekarang.kanan == null) {
                nodeSekarang.kanan = new Node(huruf);
                nodes.add(nodeSekarang.kanan); 
                nodes.poll(); 
            }
        }
    }

    public static Node getRoot() {
        return root;
    }
}
