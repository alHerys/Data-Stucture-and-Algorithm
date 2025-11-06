package main.caseBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class untuk membangun struktur data Binary Tree untuk kode Morse.
 */
public class PohonMorse {
    
    private static Node root;

    private static String urutanPohonMorse = "ETIANMSURWDKGOHVF L PJ BXC YZQ";

    static {
        buatPohonMorse();
    }

    /**
     * Membangun pohon morse menggunakan metode insert level-order dengan Queue.
     */
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

    /**
     * Mengembalikan node root dari pohon morse.
     * @return Node root.
     */
    public static Node getRoot() {
        return root;
    }
}