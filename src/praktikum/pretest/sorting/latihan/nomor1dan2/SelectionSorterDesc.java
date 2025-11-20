package praktikum.pretest.sorting.latihan.nomor1dan2;

public class SelectionSorterDesc {
    int[] data = { 25, 27, 10, 8, 76, 21 };

    void selectionSortDesc() {
        int j, k, i, temp;
        int jmax;
        int u = data.length - 1; // mulai dari indeks paling kanan

        // LATIHAN NOMOR 3: Menambahkan variabel penghitung perbandingan dan pergeseran
        int countPerbandingan = 0;
        int countPergeseran = 0;

        for (j = 0; j < 6; j++) {

            // LATIHAN NOMOR 3: Menghitung pergeseran untuk setiap iterasi luar
            countPergeseran++; 

            jmax = 0;
            System.out.println("\nLangkah " + (j + 1) + ":");
            for (k = 1; k <= u; k++) {

                // LATIHAN NOMOR 3: Menghitung jumlah perbandingan
                countPerbandingan++;

                if (data[k] < data[jmax]) {
                    jmax = k;
                }
            }
            temp = data[u];
            data[u] = data[jmax];
            data[jmax] = temp;
            u--;

            // melihat hasil tiap langkah
            for (i = 0; i <= 5; i++) {
                System.out.println(data[i] + " index:" + (i + 1));
            }
            System.out.println("\nHasil akhir selection sort descending:");
            for (i = 0; i <= 5; i++) {
                System.out.println(data[i] + " index:" + (i + 1));
            }

            // LATIHAN NOMOR 3: Menampilkan jumlah perbandingan dan pergeseran
            System.out.println("\nJumlah Perbandingan: " + countPerbandingan);
            System.out.println("Jumlah Pergeseran: " + countPergeseran);
        }
    }

    public static void main(String[] args) {
        SelectionSorterDesc sorter = new SelectionSorterDesc();
        sorter.selectionSortDesc();
    }
}
