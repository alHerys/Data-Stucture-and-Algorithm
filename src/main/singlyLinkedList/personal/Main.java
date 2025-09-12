package main.singlyLinkedList.personal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int jumlahData = 1;
        Data newData, firstData = null, lastData = null, printer;
        String jawaban;
        Scanner scan = new Scanner(System.in);

        do {
            newData = new Data();
            System.out.print("\nMasukkan nama: ");
            newData.nama = scan.nextLine();
            System.out.print("Masukkan umur: ");
            newData.umur = scan.nextInt();
            
            newData.nextData = null;
            
            if (jumlahData > 1) {
                lastData.nextData = newData;
                lastData = newData;
            } else {
                lastData = newData;
                firstData = newData;
            }
            
            System.out.println("\nMasukkan data lagi?");
            System.out.print("Jawaban(y/t): ");
            jawaban = scan.next();
            scan.nextLine();

            if (jawaban.equals("t")) {
                break;
            }

            jumlahData++;

        } while (true);

        printer = firstData;
        for (int i = 1; printer != null; i++) {
            System.out.println("\nData ke-" + i);
            System.out.printf("""
                    Nama: %s
                    Umur: %d
                    """, printer.nama, printer.umur);

            printer = printer.nextData;
        }
    }
}
