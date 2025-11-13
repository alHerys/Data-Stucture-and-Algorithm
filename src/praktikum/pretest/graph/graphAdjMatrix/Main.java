package praktikum.pretest.graph.graphAdjMatrix;

public class Main {
    public static void main(String[] args) {

        GraphMatrix g = new GraphMatrix(5);

        System.out.println("Menambahkan edge berbobot...");
        g.addEdge(0, 3, 8);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 4, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 6);
        g.addEdge(2, 1, 7);
        g.addEdge(4, 3, 4);
        System.out.println("----------------------------------------");

        g.cetak("Graf Berbobot (Adjacency Matrix)");
        System.out.println("----------------------------------------");

        System.out.println("Menguji Penelusuran (mulai dari Node 0):");
        g.BFS(0);
        g.DFS(0);
        System.out.println("----------------------------------------");

        g.dijkstra(0);
        System.out.println("----------------------------------------");
    }
}
