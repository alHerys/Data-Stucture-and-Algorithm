package main.caseBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PohonMorse {
    private static Node root;
    private static String urutanPohonMorse = "ETIANMSURWDKGOHVF L PJ BXC YZQ";

    static {
        buatPohonMorse();
        // pohonMorse = new Node(" ");

        // // 1st Level
        // pohonMorse.kiri = new Node("E");
        // pohonMorse.kanan = new Node("T");

        // // 2nd Level
        // pohonMorse.kiri.kiri = new Node("I");
        // pohonMorse.kiri.kanan = new Node("A");
        // pohonMorse.kanan.kiri = new Node("N");
        // pohonMorse.kanan.kanan = new Node("M");

        // // 3rd Level
        // pohonMorse.kiri.kiri.kiri = new Node("S");
        // pohonMorse.kiri.kiri.kanan = new Node("U");
        // pohonMorse.kiri.kanan.kiri = new Node("R");
        // pohonMorse.kiri.kanan.kanan = new Node("W");
        // pohonMorse.kanan.kiri.kiri = new Node("D");
        // pohonMorse.kanan.kiri.kanan = new Node("K");
        // pohonMorse.kanan.kanan.kiri = new Node("G");
        // pohonMorse.kanan.kanan.kanan = new Node("O");

        // // 4th Level
        // pohonMorse.kiri.kiri.kiri.kiri = new Node("H");
        // pohonMorse.kiri.kiri.kiri.kanan = new Node("V");
        // pohonMorse.kiri.kiri.kanan.kiri = new Node("F");
        // pohonMorse.kiri.kanan.kiri.kiri = new Node("L");
        // pohonMorse.kiri.kanan.kanan.kiri = new Node("P");
        // pohonMorse.kiri.kanan.kanan.kanan = new Node("J");
        // pohonMorse.kanan.kiri.kiri.kiri = new Node("B");
        // pohonMorse.kanan.kiri.kiri.kanan = new Node("X");
        // pohonMorse.kanan.kiri.kanan.kiri = new Node("C");
        // pohonMorse.kanan.kiri.kanan.kanan = new Node("Y");
        // pohonMorse.kanan.kanan.kiri.kiri = new Node("Z");
        // pohonMorse.kanan.kanan.kiri.kanan = new Node("Q");
    }

    private static void buatPohonMorse() {
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
