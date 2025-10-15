package praktikum.pretest.stack.array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean keluar = false;

        System.out.println("\n=========================================");
        System.out.println("| Selamat Datang di Program Stack Array |");
        System.out.println("=========================================");

        System.out.print("Silahkan masukkan ukuran stack anda: ");
        NewStackArray stack = new NewStackArray(scan.nextInt());

        while (!keluar) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Print");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda (1/2/3/4): ");

            // Memeriksan input haruslah angka 1-4
            if (!scan.hasNextInt()) {
                System.out.println("\n# PERINGATAN: Input harus berupa angka!");
                scan.next(); 
                continue;
            }
            
            int pilihan = scan.nextInt();
            scan.nextLine(); // membersihkan newline untuk input selanjutnya

            switch (pilihan) {
                case 1:
                
                    // Memeriksa input haruslah satu karakter saja
                    String input;
                    do {
                        System.out.print("\nMasukkan satu karakter yang akan di-push: ");
                        input = scan.nextLine();
                        
                        if (input.length() == 1) {
                            break;
                        }

                        System.out.println("PERINGATAN: Anda harus memasukkan satu karakter saja");
                    } while (true);

                    char item = input.charAt(0);

                    try {
                        stack.push(item);
                        System.out.println("\n-> Sukses! Karakter '" + item + "' telah ditambahkan.");
                    } catch (RuntimeException e) {
                        System.out.println("\n-> Gagal! " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        char itemTerhapus = stack.pop();
                        System.out.println("\n-> Sukses! Karakter '" + itemTerhapus + "' telah dihapus.");
                    } catch (RuntimeException e) {
                        System.out.println("\n-> Gagal! " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("\nIsi Stack saat ini: ");
                    stack.printAll();
                    break;

                case 4:
                    keluar = true;
                    System.out.println("\nTerima kasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("\n# PERINGATAN: Pilihan tidak valid, pilihan harus angka 1-4.");
                    break;
            }
        }
        
        scan.close(); 
    }
}