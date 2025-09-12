package praktikum.liveCoding;

import java.util.Scanner;

public class AdtArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int panjangArray = scan.nextInt();

        int[] array = new int[panjangArray];
        for (int i = 0; i < panjangArray; i++) {
            array[i] = scan.nextInt();
        }

        int jumlahBaris = scan.nextInt();
        int jumlahKolom = scan.nextInt();

        int[][] arrayDuaDimensi = new int[jumlahBaris][jumlahKolom];

        int arrayIndex = 0;
        for (int i = 0; i < jumlahBaris; i++) {
            for (int k = 0; k < jumlahKolom; k++) {
                arrayDuaDimensi[i][k] = array[arrayIndex];
                arrayIndex++;
            }
        }

        // System.out.println(Arrays.deepToString(arrayDuaDimensi));

        double sum = 0;
        int totalAngka = 0;
        for (int i = 0; i < jumlahBaris; i += 2) {
            for (int j = 0; j < jumlahKolom; j++) {
                sum += arrayDuaDimensi[i][j];
                totalAngka++;
            }
        }

        System.out.printf("Rata-rata bilangan pada baris ganjil = %.2f",sum / totalAngka);

        scan.close();
    }
}
