package praktikum.pretest.graph.latihan;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addAdj(0, 3);
        g.addAdj(0, 1);
        g.addAdj(1, 4);
        g.addAdj(1, 2);
        g.addAdj(2, 4);
        g.addAdj(2, 1);
        g.addAdj(4, 3);

        g.cetak("Representasi Adjacency List:");
        System.out.println("---------------------------------");

        System.out.println("--- Menguji Method Latihan ---");

        System.out.println("Node 1:");
        System.out.println("  Jumlah Edge Keluar (Out-Degree): " + g.getJumlahEdgeKeluar(1));
        System.out.println("  Jumlah Tetangga: " + g.getJumlahTetangga(1));
        System.out.println("  Jumlah Edge Masuk (In-Degree): " + g.getJumlahEdgeMasuk(1));

        System.out.println("\nNode 3:");
        System.out.println("  Jumlah Edge Keluar (Out-Degree): " + g.getJumlahEdgeKeluar(3));
        System.out.println("  Jumlah Edge Masuk (In-Degree): " + g.getJumlahEdgeMasuk(3));

        System.out.println("\nNode 4:");
        System.out.println("  Jumlah Edge Keluar (Out-Degree): " + g.getJumlahEdgeKeluar(4));
        System.out.println("  Jumlah Edge Masuk (In-Degree): " + g.getJumlahEdgeMasuk(4));
    }
}
