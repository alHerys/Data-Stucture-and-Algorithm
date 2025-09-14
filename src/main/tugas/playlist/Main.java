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
        ║          .:: SELAMAT DATANG, SAHABAT MUSIK – NIKMATI IRAMA TANPA BATAS ::.         ║
        ╚════════════════════════════════════════════════════════════════════════════════════╝
        """);

        do {
            System.out.println("[1] Tambah Lagu");
            System.out.println("[2] Lihat Daftar Lagu");
            System.out.println("[3] Hapus Lagu");
            System.out.println("[4] Keluar\n");
            System.out.print("Pilihan (1/2/3/4): ");
            pilihan = scan.nextLine();

            if (pilihan.equals("1")) {
                String subPilihan;
                do {
                    System.out.println("\n.:: Tambah Lagu ::.");
                    System.out.println("[1] Tambah di Awal");
                    System.out.println("[2] Tambah di Akhir");
                    System.out.println("[3] Tambah di Posisi Tertentu");
                    System.out.print("Pilih (1/2/3): ");
                    subPilihan = scan.nextLine();

                    if (!subPilihan.equals("1") && !subPilihan.equals("2") && !subPilihan.equals("3")) {
                        System.out.println("Pilihan tidak valid, silahkan pilih 1, 2, atau 3.");
                    }
                } while (!subPilihan.equals("1") && !subPilihan.equals("2") && !subPilihan.equals("3"));

                System.out.print("Masukkan judul lagu: ");
                judul = scan.nextLine();
                System.out.print("Masukkan nama artis: ");
                artis = scan.nextLine();
                System.out.print("Masukkan genre: ");
                genre = scan.nextLine();
                System.out.println();

                Music music = new Music(judul, artis, genre);

                if (subPilihan.equals("1")) {
                    playlist.addFirst(music);
                    System.out.println("Lagu berhasil ditambahkan di awal!\n");
                } else if (subPilihan.equals("2")) {
                    playlist.addLast(music);
                    System.out.println("Lagu berhasil ditambahkan di akhir!\n");
                } else if (subPilihan.equals("3")) {
                    if (!playlist.isEmpty()) {
                        System.out.println("\n.:: Daftar Lagu Saat Ini ::.");
                        System.out.println(playlist);
                    } else {
                        System.out.println("\nPlaylist kosong. Lagu akan ditambahkan sebagai pertama.\n");
                    }

                    System.out.print("Masukkan posisi urutan: ");
                    try {
                        int posisi = Integer.parseInt(scan.nextLine());
                        int index = posisi - 1;
                        playlist.addAtIndex(index, music);
                        System.out.println("Lagu berhasil ditambahkan di urutan ke-" + posisi + "!\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Index tidak valid!\n");
                    }

                }

            } else if (pilihan.equals("2")) {
                if (playlist.isEmpty()) {
                    System.out.println("Playlist kosong.\n");
                } else {
                    System.out.println("\n.:: Daftar Lagu ::.");
                    System.out.println(playlist);
                    System.out.println();
                }

            } else if (pilihan.equals("3")) {
                if (playlist.isEmpty()) {
                    System.out.println("Playlist kosong, tidak ada yang bisa dihapus.\n");
                } else {
                    System.out.println("\n.:: Daftar Lagu ::.");
                    System.out.println(playlist);
                    System.out.print("Masukkan nomor urut lagu yang ingin dihapus: ");
                    try {
                        int index = Integer.parseInt(scan.nextLine()) - 1;
                        playlist.removeAtIndex(index);
                        System.out.println("Lagu berhasil dihapus!\n");
                    } catch (Exception e) {
                        System.out.println("Nomor tidak valid!\n");
                    }
                }

            } else if (pilihan.equals("4")) {
                System.out.println("Terima kasih telah menggunakan aplikasi playlist!");
                break;

            } else {
                System.out.println("Pilihan tidak valid\n");
            }
        } while (true);
    }
}
