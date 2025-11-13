package praktikum.pretest.graph.graphAdjMatrix;

import java.util.Arrays;

import praktikum.pretest.queue.doubleLinkedList.QueueDLL;

public class GraphMatrix {
    private int[][] matrix;
    private int jNode;

    // Constructor
    public GraphMatrix(int n) {
        this.jNode = n;
        this.matrix = new int[n][n];
    }

    /**
     * Menambahkan vertex baru ke dalam graph
     * @param asal data vertex
     * @param tujuan vertex tujuan
     * @param jarak jarak vertex ke vertex tujuan
     */
    public void addEdge(int asal, int tujuan, int jarak) {
        if (asal >= 0 && asal < jNode && tujuan >= 0 && tujuan < jNode) {
            matrix[asal][tujuan] = jarak;
        } else {
            System.out.println("Node tidak valid!");
        }
    }

    /**
     * Melakukan pencarian level order yang dimulai dari vertex awal
     * @param startVertex vertex dimulainya pencarian
     */
    public void BFS(int startVertex) {
        System.out.print("Hasil BFS (mulai dari " + startVertex + "): ");

        boolean[] visited = new boolean[jNode];

        QueueDLL<Integer> queue = new QueueDLL<>();

        visited[startVertex] = true;
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {

            int curr = queue.dequeue();
            System.out.print(curr + " ");

            for (int j = 0; j < jNode; j++) {

                if (matrix[curr][j] != 0 && !visited[j]) {
                    visited[j] = true;
                    queue.enqueue(j);
                }
            }
        }
        System.out.println();
    }

    /**
     * Menjelajahi graph sedalam mungkin terlebih dahulu
     * @param startVertex vertex dimulainya penelusuran
     */
    public void DFS(int startVertex) {
        System.out.print("Hasil DFS (mulai dari " + startVertex + "): ");

        boolean[] visited = new boolean[jNode];

        DFSRecursive(startVertex, visited);

        System.out.println();
    }

    /**
     * Method bantuan rekursif untuk DFS
     * @param curr vertex saat ini
     * @param visited array penanda kunjungan
     */
    private void DFSRecursive(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (int j = 0; j < jNode; j++) {

            if (matrix[curr][j] != 0 && !visited[j]) {

                DFSRecursive(j, visited);
            }
        }
    }

    /**
     * Menghitung jalur terpendek dari startVertex ke semua vertex lainnya
     * @param startVertex
     */
    public void dijkstra(int startVertex) {
        int n = matrix.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] != 0 && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + matrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + matrix[u][v];
                }
            }
        }

        printSolution(distance, startVertex);
    }

    /**
     * Mencetak matrix
     * @param komentar
     */
    public void cetak(String komentar) {
        System.out.println(komentar);

        System.out.print("   ");
        for (int i = 0; i < jNode; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < jNode; i++) {
            System.out.print("- ");
        }
        System.out.println();

        for (int i = 0; i < jNode; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < jNode; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Mencari vertex dengan jarak minimum yang belum dikunjungi
     * @param distance array jarak
     * @param visited array penanda kunjungan
     * @return index vertex dengan jarak minimum
     */
    private static int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < distance.length; v++) {
            if (!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * Mencetak jarak dari startVertex ke semua vertex lainnya
     * @param distance array jarak
     * @param startVertex vertex awal
     */
    private static void printSolution(int[] distance, int startVertex) {
        System.out.println("Jarak dari vertex " + startVertex + " ke seluruh vertex lainnya");
        for (int i = 0; i < distance.length; i++) {
            if (i == startVertex) {
                continue;
            }
            System.out.println("Ke vertex " + i + " --> " + distance[i]);
        }
    }
}
