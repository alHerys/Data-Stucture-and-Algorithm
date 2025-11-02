package main.caseBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class untuk membangun struktur data Binary Tree untuk kode Morse.
 */
public class PohonMorse {
    // Node root sebagai awal dari pohon.
    private static Node root;
    // Urutan karakter morse sesuai standar level-order.
    private static String urutanPohonMorse = "ETIANMSURWDKGOHVF L PJ BXC YZQ";

    // Static block untuk memastikan pohon dibuat sekali saat class dimuat.
    static {
        buatPohonMorse();
    }

    /**
     * Membangun pohon morse menggunakan metode insert level-order dengan Queue.
     */
    private static void buatPohonMorse() {
        // Buat root dengan data kosong.
        root = new Node(' ');

        // Siapkan queue untuk proses insert level-order.
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        // Loop untuk setiap karakter yang akan dimasukkan ke pohon.
        for (char huruf : urutanPohonMorse.toCharArray()) {
            // Lihat node induk saat ini di antrian.
            Node nodeSekarang = nodes.peek();

            // Jika anak kiri kosong, isi dengan huruf baru.
            if (nodeSekarang.kiri == null) {
                nodeSekarang.kiri = new Node(huruf);
                // Tambahkan node anak baru ke antrian.
                nodes.add(nodeSekarang.kiri); 

            } else if (nodeSekarang.kanan == null) {
                // Jika anak kiri sudah terisi, isi anak kanan.
                nodeSekarang.kanan = new Node(huruf);
                // Tambahkan node anak baru ke antrian.
                nodes.add(nodeSekarang.kanan); 
                // Hapus node induk dari antrian karena sudah punya 2 anak.
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