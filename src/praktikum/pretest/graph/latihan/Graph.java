package praktikum.pretest.graph.latihan;

public class Graph {
    private Node[] node;
    private int jNode;

    public Graph(int n) {
        this.jNode = n;
        this.node = new Node[jNode];
    }

    public void addAdj(int head, int adj) {
        Node newNode = new Node(adj, node[head]);
        node[head] = newNode;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < jNode; i++) {
            System.out.print("[" + i + "]");
            Node n = node[i];
            while (n != null) {
                System.out.print("->" + n.getData());
                n = n.getNext();
            }
            System.out.println();
        }
    }

// DISINI MULAI BAGIAN LATIHAN
    // Menghitung jumlah edge keluar
    // Menghitung jumlah tetangga
    public int getJumlahEdgeKeluar(int vertexData) {
        int count = 0;
        Node curr = node[vertexData]; // Mulai dari list node[vertexData]

        while (curr != null) {
            count++;
            curr = curr.getNext();
        }

        return count;
    }

    public int getJumlahTetangga(int vertexData) {
        return getJumlahEdgeKeluar(vertexData);
    }

    public int getJumlahEdgeMasuk(int vertexData) {
        int count = 0;
        
        // Loop SEMUA node di graph
        for (int i = 0; i < jNode; i++) {
            
            // Telusuri adj list milik node 'i'
            Node curr = node[i];
            while (curr != null) {
                
                // Jika node[i] menunjuk ke 'vertexData', tambah hitungan
                if (curr.getData() == vertexData) {
                    count++;
                }
                curr = curr.getNext();
            }
        }
        return count;
    }
// DISINI AKHIR BAGIAN LATIHAN
}
