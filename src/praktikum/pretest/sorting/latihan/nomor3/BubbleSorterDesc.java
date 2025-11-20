package praktikum.pretest.sorting.latihan.nomor3;

public class BubbleSorterDesc {

    int[] data = { 25, 27, 10, 8, 76, 21 };

    public void bubbleSortDesc() {
        int i, j;
        int Max = data.length;
        int temp;

        // LATIHAN NOMOR 3: Variabel penghitung perbandingan dan pergeseran
        int countPerbandingan = 0;
        int countPergeseran = 0;

        for (i = 0; i < Max - 1; i++) {
            System.out.println("\nLangkah " + (i + 1) + ":");
            for (j = Max - 1; j > i; j--) {

                // LATIHAN NOMOR 3: Menghitung jumlah perbandingan
                countPerbandingan++;

                if (data[j - 1] < data[j]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;

                    // LATIHAN NOMOR 3: Menghitung jumlah pergeseran
                    countPergeseran++;
                }
                System.out.println(data[j] + " index = " + (j + 1));
            }
            System.out.println(data[j] + " index = " + (j + 1));
        }
        System.out.println("\nHasil akhir bubble sort descending:");
        for (i = 0; i <= 5; i++) {
            System.out.println(data[i] + " index: " + (i + 1));
        }

        // LATIHAN NOMOR 3: Menampilkan jumlah perbandingan dan pergeseran
        System.out.println("\nJumlah Perbandingan: " + countPerbandingan);
        System.out.println("Jumlah Pergeseran: " + countPergeseran);
    }

    public static void main(String[] args) {
        BubbleSorterDesc sorter = new BubbleSorterDesc();
        sorter.bubbleSortDesc();
    }
}
