package praktikum.personal;

import java.util.Arrays;

/**
 * <h3> Latihan </h3>
 * Terdapat array dengan data 30, 87, 90, 3, 1, 50, 23, 4, 25, 23, 40, 35, 47, 2, 33. <br/>
 * 1. Buatlah Kodenya dalam bahasa Java. <br/>
 * 2. Jalankan dan pastikan tidak ada errornya. <br/>
 * 
 * <h3> Tugas 1 </h3>
 * 1. Urutkan data pada array tersebut. <br/>
 * 2. Hitung rata-rata data tersebut. <br/>
 * 3. Hitung nilai maksimal dan minimalnya. <br/>
 * 4. Tampilkan data yang bilangan ganjil saja dan prima saja. <br/>
 * 5. Dari data tersebut, buatlah array 2 dimensi dengan format 3 baris dan 5 kolom.
 */
public class Tugas1 {
    public static void main(String[] args) {

        // Data awal (Latihan)
        int[] data = { 30, 87, 90, 3, 1, 50, 23, 4, 25, 23, 40, 35, 47, 2, 33 };

        System.out.println("\nArray data = " + Arrays.toString(data));

        // Ini Tugas 1
        // Arrays.sort() untuk sortir data secara permanen
        Arrays.sort(data);
        // toString() untuk print array 1 dimensi
        System.out.println("Data yang sudah diurutkan " + Arrays.toString(data));

        System.out.println("Rata-rata dari data adalah " + hitungRataRata(data));
        System.out.println("Nilai maksimum: " + nilaiMaks(data));
        System.out.println("Nilai minimum: " + nilaiMin(data));

        tampilkanPrimaGanjil(data);
        tampilkanGanjil(data);
        tampilkanPrima(data);

        // method deepToString khusus untuk array multi dimensi
        System.out.println("Array 2 dimensi: " + Arrays.deepToString(bagiArray(data)));

        System.out.println();
    }

    /** Hitung rata-rata dari isi array */
    static int hitungRataRata(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }

    /** Cari nilai paling besar (max) */
    static int nilaiMaks(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    /** Cari nilai paling kecil (min) */
    static int nilaiMin(int[] array) {
        Arrays.sort(array);
        return array[0];
    }

    /** Tampilkan angka yang ganjil sekaligus prima */
    static void tampilkanPrimaGanjil(int[] array) {
        System.out.print("Data yang ganjil dan prima: [");
        boolean isFirst = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && cekBilanganPrima(array[i])) {
                if (!isFirst) {
                    System.out.print(", ");
                }
                System.out.print(array[i]);
                isFirst = false;
            }
        }
        System.out.print("]\n");
    }

    /** Tampilkan angka yang ganjil saja */
    static void tampilkanGanjil(int[] array) {
        System.out.print("Data yang ganjil saja: [");
        boolean isFirst = true;
        for (int i : array) {
            if (i % 2 != 0) {
                if (!isFirst) {
                    System.out.print(", ");
                }
                System.out.print(i);
                isFirst = false;
            }
        }
        System.out.print("]\n");
    }

    /** Tampilkan angka yang prima saja */
    static void tampilkanPrima(int[] array) {
        System.out.print("Data yang prima saja: [");
        boolean isFirst = true;
        for (int i : array) {
            if (cekBilanganPrima(i)) {
                if (!isFirst) {
                    System.out.print(", ");
                }
                System.out.print(i);
                isFirst = false;
            }
        }
        System.out.print("]\n");
    }

    /** Ubah array 1 dimensi jadi array 2 dimensi dengan 3 baris x 5 kolom */
    static int[][] bagiArray(int[] array) {
        int[][] arrayBaru = new int[3][5];
        for (int i = 0, j = 0; i < 3; i++) {
            for (int k = 0; k < 5; k++) {
                arrayBaru[i][k] = array[j];
                j++;
            }
        }
        return arrayBaru;
    }

    /** Cek apakah angka itu bilangan prima */
    static boolean cekBilanganPrima(int number) {
        if (number <= 1)
            return false;
        else if (number == 2)
            return true;
        else if (number % 2 == 0)
            return false;

        // cek pembagi mulai dari 3 sampai akar kuadrat
        // i += 2 untuk melompati angka genap
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
