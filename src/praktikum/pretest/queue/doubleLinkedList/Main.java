package praktikum.pretest.queue.doubleLinkedList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        QueueDLL<String> queue = new QueueDLL<>();
        boolean keluar = false;

        System.out.println("\n=========================================");
        System.out.println("| Selamat Datang di Program Queue (DLL) |");
        System.out.println("=========================================");

        while (!keluar) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Enqueue (Tambah Data)");
            System.out.println("2. Dequeue (Hapus Data)");
            System.out.println("3. Print (Cetak Semua Data)");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda (1-4): ");

            // Memeriksa apakah input adalah angka
            if (!scan.hasNextInt()) {
                System.out.println("\n# PERINGATAN: Input harus berupa angka!");
                scan.next(); // Membersihkan input yang salah
                continue;
            }
            
            int pilihan = scan.nextInt();
            scan.nextLine(); // Membersihkan newline character dari buffer

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan data yang akan di-enqueue: ");
                    String dataMasuk = scan.nextLine();
                    queue.enqueue(dataMasuk);
                    System.out.println("\n-> Sukses! Data '" + dataMasuk + "' telah ditambahkan ke dalam queue.");
                    break;

                case 2:
                    try {
                        String dataKeluar = queue.dequeue();
                        System.out.println("\n-> Sukses! Data '" + dataKeluar + "' telah dihapus dari queue.");
                    } catch (NoSuchElementException e) {
                        System.out.println("\n-> Gagal! " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\nIsi Queue saat ini: " + queue);
                    break;

                case 4:
                    keluar = true;
                    System.out.println("\nTerima kasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("\n# PERINGATAN: Pilihan tidak valid, silakan masukkan angka 1-4.");
                    break;
            }
        }
        
        scan.close(); 

    }
}