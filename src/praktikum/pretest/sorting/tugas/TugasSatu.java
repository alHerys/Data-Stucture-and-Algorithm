package praktikum.pretest.sorting.tugas;
import java.util.Random;

public class TugasSatu {

    public static void main(String[] args) {
        // 1. Membuat 50 Data Acak
        int[] dataAwal = new int[50];
        Random rand = new Random();
        
        System.out.println("\n=== DATA AWAL (50 Angka Acak) ===");
        for(int i=0; i<50; i++){
            dataAwal[i] = rand.nextInt(100); // Angka 0-99
            System.out.print(dataAwal[i] + " ");
        }
        System.out.println("\n");

        // Clone array agar kedua algoritma mengurutkan data yang sama persis
        int[] dataUntukBubble = dataAwal.clone();
        int[] dataUntukSelection = dataAwal.clone();

        // Bubble Sort
        int iterasiBubble = runBubbleSort(dataUntukBubble);
        System.out.println("Bubble Sort selesai dalam " + iterasiBubble + " iterasi.");

        // Selection Sort
        int iterasiSelection = runSelectionSort(dataUntukSelection);
        System.out.println("Selection Sort selesai dalam " + iterasiSelection + " iterasi.");

        System.out.println();
    }

    // Bubble Sort 
    static int runBubbleSort(int[] arr) {
        int n = arr.length;
        int totalIterasi = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                totalIterasi++;
                if (arr[j - 1] > arr[j]) { // Ascending
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return totalIterasi;
    }

    // Selection Sort 
    static int runSelectionSort(int[] arr) {
        int n = arr.length;
        int totalIterasi = 0;
        int u = n - 1;
        
        for (int j = 0; j < n; j++) {
            int maxIdx = 0;
            for (int k = 1; k <= u; k++) {
                totalIterasi++;
                if (arr[k] > arr[maxIdx]) { // Ascending
                    maxIdx = k;
                }
            }
            int temp = arr[u];
            arr[u] = arr[maxIdx];
            arr[maxIdx] = temp;
            u--;
        }
        return totalIterasi;
    }
}