package main.singlyLinkedList.contohBrone;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner masukan = new Scanner(System.in);

        Data awal=null, akhir=null, baru=null, bantu=null;
        boolean keluar = false;
        char tombol;
        int jmlData = 1;

        System.out.println("Program menyimpan data dengan Linklist");

        do {
            baru = new Data();
            System.out.print("Masukkan nama temanmu : ");
            baru.nama = masukan.next();
            System.out.print("Masukkan alamat temanmu : ");
            baru.alamat = masukan.next();
            System.out.print("Masukkan noHP temanmu : ");
            baru.noHP = masukan.next();
            baru.dataBerikutnya = null;

            if (jmlData == 1){
                awal = baru;
                akhir = awal;
            }
            else {
                akhir.dataBerikutnya = baru;
                akhir = baru;
            }

            System.out.println("Apakah ingin menambah data lagi?(Y/T)");
            tombol = masukan.next().charAt(0);
            if ((tombol == 't') || (tombol == 'T'))
                keluar = true;

            jmlData++;
        }while(keluar == false);

        int i = 1;
        bantu = awal;
        while(bantu != null) {
            System.out.println("Data ke-" + i + " : ");
            System.out.println("nama = " + bantu.nama);
            System.out.println("alamat = " + bantu.alamat);
            System.out.println("noHP = " + bantu.noHP);
            System.out.println();
            i++;
            bantu = bantu.dataBerikutnya;
        }
        
        masukan.close();
    }
}