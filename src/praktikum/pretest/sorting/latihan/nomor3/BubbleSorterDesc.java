package praktikum.pretest.sorting.latihan.nomor3;

public class BubbleSorterDesc {

    int[] data = { 25, 27, 10, 8, 76, 21 };

    public void bubbleSortDesc() {
        int i, j;
        int Max = data.length;
        int temp;

        int countPerbandingan = 0;
        int countPergeseran = 0;

        for (i = 0; i < Max - 1; i++) {
            System.out.println("Langkah " + (i + 1) + ":");
            for (j = Max - 1; j > i; j--) {

                // LATIHAN NOMOR 2: Menghitung jumlah perbandingan
                countPerbandingan++;

                // LATIHAN NOMOR 1: Perubahan yang terjadi di sini
                // Mengubah tanda '<' menjadi '>' agar sorting dilakukan secara descending
                if (data[j - 1] < data[j]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                    // LATIHAN NOMOR 2: Menghitung jumlah pergeseran
                    countPergeseran++;
                }
                System.out.println(data[j] + " index = " + (j + 1));
            }
            System.out.println(data[j] + " index = " + (j + 1));
        }
        System.out.println("Hasil akhir bubble sort descending:");
        for (i = 0; i <= 5; i++) {
            System.out.println(data[i] + " index: " + (i + 1));
        }
    }

    public static void main(String[] args) {
        BubbleSorterDesc sorter = new BubbleSorterDesc();
        sorter.bubbleSortDesc();
    }
}
