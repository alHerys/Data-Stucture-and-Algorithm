package main.caseBinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner niel = new Scanner(System.in);
        MorseDecoder decoder = new MorseDecoder();
        MorseEncoder encoder = new MorseEncoder();

        int pilihan;
        do {
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║        PROGRAM PENERJEMAH MORSE      ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Encode (Teks → Morse)            ║");
            System.out.println("║  2. Decode (Morse → Teks)            ║");
            System.out.println("║  3. Keluar                           ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print(">> Pilih menu [1-3]: ");
            pilihan = niel.nextInt();
            niel.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n======================= MODE ENCODE ========================");
                    System.out.print("Masukkan teks: ");
                    String teks = niel.nextLine().toUpperCase();
                    System.out.print("Hasil encode: ");
                    encoder.encode(teks);
                    System.out.println("============================================================");
                    break;

                case 2:
                    System.out.println("\n======================= MODE DECODE ========================");
                    System.out.print("Masukkan kode morse (gunakan '/' untuk spasi): ");
                    String morse = niel.nextLine();
                    System.out.print("Hasil decode: ");
                    decoder.decode(morse);
                    System.out.println("============================================================");
                    break;

                case 3:
                    System.out.println("\nTerima kasih telah menggunakan program Morse Code!");
                    System.out.println("Semoga harimu menyenangkan :)");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid, silakan coba lagi!");
            }

        } while (pilihan != 3);

        niel.close();
    }
}