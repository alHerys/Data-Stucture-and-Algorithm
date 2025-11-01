package main.caseBinaryTree.morseDecoder;

public class PohonMorse {
    private static Node root;
    private static String urutanPohonMorse = "ETIANMSURWDKGOHVF L PJ BXC YZQ";

    static {
        root = new Node(' ');

        for (char huruf : urutanPohonMorse.toCharArray()) {
            buatPohonMorse(root, huruf);
        }

        // 1st Level
        root.kiri = new Node('E');
        root.kanan = new Node('T');

        // 2nd Level
        root.kiri.kiri = new Node('I');
        root.kiri.kanan = new Node('A');
        root.kanan.kiri = new Node('N');
        root.kanan.kanan = new Node('M');

        // 3rd Level
        root.kiri.kiri.kiri = new Node('S');
        root.kiri.kiri.kanan = new Node('U');
        root.kiri.kanan.kiri = new Node('R');
        root.kiri.kanan.kanan = new Node('W');

        root.kanan.kiri.kiri = new Node('D');
        root.kanan.kiri.kanan = new Node('K');
        root.kanan.kanan.kiri = new Node('G');
        root.kanan.kanan.kanan = new Node('O');

        // 4th Level
        root.kiri.kiri.kiri.kiri = new Node('H');
        root.kiri.kiri.kiri.kanan = new Node('V');
        root.kiri.kiri.kanan.kiri = new Node('F');
        root.kiri.kiri.kanan.kanan = new Node(' ');
        root.kiri.kanan.kiri.kiri = new Node('L');
        root.kiri.kanan.kiri.kanan = new Node(' ');
        root.kiri.kanan.kanan.kiri = new Node('P');
        root.kiri.kanan.kanan.kanan = new Node('J');

        root.kanan.kiri.kiri.kiri = new Node('B');
        root.kanan.kiri.kiri.kanan = new Node('X');
        root.kanan.kiri.kanan.kiri = new Node('C');
        root.kanan.kiri.kanan.kanan = new Node('Y');
        root.kanan.kanan.kiri.kiri = new Node('Z');
        root.kanan.kanan.kiri.kanan = new Node('Q');
        root.kanan.kanan.kanan.kiri = new Node(' ');
        root.kanan.kanan.kanan.kanan = new Node(' ');
    }

    private static void buatPohonMorse(Node node, char huruf) {
        if (node.kiri == null) {
            node.kiri = new Node(huruf);
            return;
        }

        if (node.kanan == null) {
            node.kanan = new Node(huruf);
            return;
        }

        if (hitungTinggi(node.kiri) <= hitungTinggi(node.kanan)) {
            buatPohonMorse(node.kiri, huruf);
            
        } else {
            buatPohonMorse(node.kanan, huruf);
        }
    }

    private static int hitungTinggi(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(hitungTinggi(node.kiri), hitungTinggi(node.kanan));
    }

    public static Node getRoot() {
        return root;
    }
}
