package main.tugas.playlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyPlaylist playlist = new DoublyPlaylist();
        Scanner scan = new Scanner(System.in);
        String pilihan = "";
        String judul = "";
        String artis = "";
        String genre = "";

        System.out.println("""
        ╔════════════════════════════════════════════════════════════════════════════════════╗
        ║                                .:: SELAMAT DATANG ::.                              ║
        ╚════════════════════════════════════════════════════════════════════════════════════╝
        """);

        do {
            System.out.println("[1] Tambah Lagu");
            System.out.println("[2] Lihat Daftar Lagu");
            System.out.println("[3] Keluar");
            System.out.print("Pilihan (1/2/3): ");
            pilihan = scan.next();

            if (pilihan.equals("1")) {

                System.out.print("Silahkan masukkan judul lagu: ");
                judul = scan.nextLine();
                System.out.print("Silahkan masukkan nama artis: ");
                artis = scan.nextLine();
                System.out.print("Silahkan masukkan nama genre: ");
                genre = scan.nextLine();

                Music music = new Music(judul, artis, genre);
                playlist.add(music);

            } else if (pilihan.equals("2")) {
                System.out.println(playlist);
            } else if (pilihan.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }

        } while (true);

        scan.close();
    }
}
