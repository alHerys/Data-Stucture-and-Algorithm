package praktikum.pretest.sorting.latihan.nomor1;

public class SelectionSorterDesc {
    int[] data = { 25, 27, 10, 8, 76, 21 };

    void selectionSortDesc() {
        int j, k, i, temp;
        int jmax;
        int u = data.length - 1; // mulai dari indeks paling kanan

        for (j = 0; j < 6; j++) {
            jmax = 0;
            System.out.println("Langkah " + (j + 1) + ":");
            for (k = 1; k <= u; k++) {

                // Perubahan disini
                // Mengubah tanda '>' menjadi '<' agar sorting dilakukan secara descending
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
            System.out.println("Hasil akhir selection sort descending:");
            for (i = 0; i <= 5; i++) {
                System.out.println(data[i] + " index:" + (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        SelectionSorterDesc sorter = new SelectionSorterDesc();
        sorter.selectionSortDesc();
    }
}
