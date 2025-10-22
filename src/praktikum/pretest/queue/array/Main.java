package praktikum.pretest.queue.array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean keluar = false;

        System.out.println("\n=========================================");
        System.out.println("| Selamat Datang di Program Queue Array |");
        System.out.println("=========================================");

        System.out.print("Silahkan masukkan ukuran queue Anda: ");
        int size = scan.nextInt();
        QueueArray queue = new QueueArray(size);

        while (!keluar) {
            System.out.println("\n============== MENU UTAMA ==============");
            System.out.println("1. Enqueue (Tambah Elemen)");
            System.out.println("2. Dequeue (Hapus Elemen)");
            System.out.println("3. Peek (Lihat Elemen Depan)");
            System.out.println("4. Lihat Status Queue");
            System.out.println("5. Print Semua Elemen");
            System.out.println("6. Keluar");
            System.out.println("========================================");
            System.out.print("Pilihan Anda (1-6): ");

            if (!scan.hasNextInt()) {
                System.out.println("\n# PERINGATAN: Input harus berupa angka!");
                scan.next();
                continue;
            }

            int pilihan = scan.nextInt();
            scan.nextLine();

            System.out.println();

            switch (pilihan) {
                case 1:
                    String input;
                    do {
                        System.out.print("--> Masukkan satu karakter yang akan di-enqueue: ");
                        input = scan.nextLine();
                        if (input.length() == 1) {
                            break;
                        }
                        System.out.println("# PERINGATAN: Anda harus memasukkan satu karakter saja.\n");
                    } while (true);

                    char itemToAdd = input.charAt(0);
                    try {
                        queue.enqueue(itemToAdd);
                        System.out.println("-> Sukses! Karakter '" + itemToAdd + "' telah ditambahkan.");
                    } catch (Exception e) {
                        System.out.println("-> Gagal! " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        char itemRemoved = queue.dequeue();
                        System.out.println("-> Sukses! Karakter '" + itemRemoved + "' telah dihapus.");
                    } catch (Exception e) {
                        System.out.println("-> Gagal! " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        char frontItem = queue.peek();
                        System.out.println("-> Elemen paling depan (front) saat ini adalah: '" + frontItem + "'");
                    } catch (Exception e) {
                        System.out.println("-> Gagal! " + e.getMessage());
                    }
                    break;

                case 4:
                    printQueueStatus(queue, size); // Panggil method untuk menampilkan status
                    break;

                case 5:
                    System.out.print("-> Isi Queue saat ini: ");
                    queue.printAll();
                    break;

                case 6:
                    keluar = true;
                    System.out.println("Terima kasih telah menggunakan program ini! 👋");
                    break;

                default:
                    System.out.println("# PERINGATAN: Pilihan tidak valid, pilihan harus angka 1-6.");
                    break;
            }
        }

        scan.close();
    }

    /**
     * Mencetak status queue terkini, termasuk ukuran, dan apakah queue kosong atau penuh.
     * @param queue Objek QueueArray yang statusnya akan ditampilkan.
     */
    private static void printQueueStatus(QueueArray queue, int size) {
        
        System.out.println("----------------------------------------");
        System.out.println("           STATUS QUEUE SAAT INI");
        System.out.println("----------------------------------------");
        System.out.println("- Ukuran    : " + queue.currentSize() + " / " + size);
        System.out.println("- Kosong?   : " + (queue.isEmpty() ? "Ya" : "Tidak"));
        System.out.println("- Penuh?    : " + (queue.isFull() ? "Ya" : "Tidak"));
        System.out.println("----------------------------------------");
    }
}