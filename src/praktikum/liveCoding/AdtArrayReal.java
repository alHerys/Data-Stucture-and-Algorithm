package praktikum.liveCoding;

import java.util.Scanner;

public class AdtArrayReal {
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

        double sum = 0;
        int totalAngka = 0;
        
        int indexArray = 0;
        for (int i = 0; i < jumlahBaris; i++) {

            for (int j = 0; j < jumlahKolom; j++) {
                arrayDuaDimensi[i][j] = array[indexArray];
                indexArray++;

                if ((i + 1) % 2 != 0) {
                    sum += arrayDuaDimensi[i][j];
                    totalAngka++;
                }
            }
        }

        System.out.printf("Rata-rata bilangan pada baris ganjil = %.2f", sum / totalAngka);

        scan.close();
    }
}
