package main.tugas.playlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyPlaylist playlist = new DoublyPlaylist();
        Scanner scan = new Scanner(System.in);
        int pilihan = 0;

        System.out.println("""
        ╔════════════════════════════════════════════════════════════════════════════════════╗
        ║                                    MY PLAYLIST                                     ║
        ╠═════╦══════════════════════════════════╦════════════════════╦══════════════════════╣
        ║ No. ║            Judul                 ║     Nama Artis     ║        Genre         ║
        ╠═════╬══════════════════════════════════╬════════════════════╬══════════════════════╣
        """);

        do {
            System.out.println("[1] Tambah Lagu");
            System.out.println("[2] Lihat Daftar Lagu");
            System.out.println("[3] Keluar");
            System.out.print("Pilihan (1/2/3): ");
            pilihan = scan.nextInt();

            if (pilihan == 1) {

            } else if (pilihan == 2) {

            } else if (pilihan == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }
            
        } while (true);

        scan.close();
    }
}
