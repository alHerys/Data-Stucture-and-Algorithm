package praktikum.pretest.circular.csll;

/**
 * Ini dibuat dengan Claude AI untuk memaksimalkan proses test case CSLL
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("PENGUJIAN CIRCULAR SINGLE LINKED LIST");
        System.out.println("=".repeat(70));
        
        // TEST 1: SisipDataDiAwal pada list kosong
        System.out.println("\n[TEST 1] SisipDataDiAwal pada list kosong");
        CircularSingleLinkedList list1 = new CircularSingleLinkedList();
        list1.cetak("Sebelum: ");
        list1.SisipDataDiAwal(10);
        list1.cetak("Setelah SisipDataDiAwal(10): ");
        
        // TEST 2: SisipDataDiAwal pada list yang sudah ada data
        System.out.println("\n[TEST 2] SisipDataDiAwal pada list yang sudah ada data");
        list1.cetak("Sebelum: ");
        list1.SisipDataDiAwal(20);
        list1.cetak("Setelah SisipDataDiAwal(20): ");
        list1.SisipDataDiAwal(30);
        list1.cetak("Setelah SisipDataDiAwal(30): ");
        
        // TEST 3: SisipDataDiAkhir pada list kosong
        System.out.println("\n[TEST 3] SisipDataDiAkhir pada list kosong");
        CircularSingleLinkedList list2 = new CircularSingleLinkedList();
        list2.cetak("Sebelum: ");
        list2.SisipDataDiAkhir(100);
        list2.cetak("Setelah SisipDataDiAkhir(100): ");
        
        // TEST 4: SisipDataDiAkhir pada list yang sudah ada data
        System.out.println("\n[TEST 4] SisipDataDiAkhir pada list yang sudah ada data");
        list2.cetak("Sebelum: ");
        list2.SisipDataDiAkhir(200);
        list2.cetak("Setelah SisipDataDiAkhir(200): ");
        list2.SisipDataDiAkhir(300);
        list2.cetak("Setelah SisipDataDiAkhir(300): ");
        
        // TEST 5: Kombinasi SisipDataDiAwal dan SisipDataDiAkhir
        System.out.println("\n[TEST 5] Kombinasi SisipDataDiAwal dan SisipDataDiAkhir");
        CircularSingleLinkedList list3 = new CircularSingleLinkedList();
        list3.SisipDataDiAwal(50);
        list3.cetak("Setelah SisipDataDiAwal(50): ");
        list3.SisipDataDiAkhir(60);
        list3.cetak("Setelah SisipDataDiAkhir(60): ");
        list3.SisipDataDiAwal(40);
        list3.cetak("Setelah SisipDataDiAwal(40): ");
        list3.SisipDataDiAkhir(70);
        list3.cetak("Setelah SisipDataDiAkhir(70): ");
        
        // TEST 6: hapusData - data di tengah
        System.out.println("\n[TEST 6] hapusData - menghapus data di tengah");
        CircularSingleLinkedList list4 = new CircularSingleLinkedList();
        list4.SisipDataDiAkhir(1);
        list4.SisipDataDiAkhir(2);
        list4.SisipDataDiAkhir(3);
        list4.SisipDataDiAkhir(4);
        list4.cetak("Sebelum hapusData(3): ");
        list4.hapusData(3);
        list4.cetak("Setelah hapusData(3): ");
        
        // TEST 7: hapusData - data di awal (head)
        System.out.println("\n[TEST 7] hapusData - menghapus data di awal (head)");
        list4.cetak("Sebelum hapusData(1): ");
        list4.hapusData(1);
        list4.cetak("Setelah hapusData(1): ");
        
        // TEST 8: hapusData - data di akhir (tail)
        System.out.println("\n[TEST 8] hapusData - menghapus data di akhir (tail)");
        list4.cetak("Sebelum hapusData(4): ");
        list4.hapusData(4);
        list4.cetak("Setelah hapusData(4): ");
        
        // TEST 9: hapusData - data yang tidak ada
        System.out.println("\n[TEST 9] hapusData - menghapus data yang tidak ada");
        list4.cetak("Sebelum hapusData(999): ");
        list4.hapusData(999);
        list4.cetak("Setelah hapusData(999): ");
        
        // TEST 10: hapusData - satu-satunya data dalam list
        System.out.println("\n[TEST 10] hapusData - menghapus satu-satunya data");
        CircularSingleLinkedList list5 = new CircularSingleLinkedList();
        list5.SisipDataDiAwal(555);
        list5.cetak("Sebelum hapusData(555): ");
        list5.hapusData(555);
        list5.cetak("Setelah hapusData(555): ");
        
        // TEST 11: hapusData pada list kosong
        System.out.println("\n[TEST 11] hapusData pada list kosong");
        CircularSingleLinkedList list6 = new CircularSingleLinkedList();
        list6.cetak("Sebelum hapusData(100): ");
        list6.hapusData(100);
        list6.cetak("Setelah hapusData(100): ");
        
        // TEST 12: hapusSatuDataDiAwal pada list dengan banyak data
        System.out.println("\n[TEST 12] hapusSatuDataDiAwal pada list dengan banyak data");
        CircularSingleLinkedList list7 = new CircularSingleLinkedList();
        list7.SisipDataDiAkhir("A");
        list7.SisipDataDiAkhir("B");
        list7.SisipDataDiAkhir("C");
        list7.SisipDataDiAkhir("D");
        list7.cetak("Sebelum hapusSatuDataDiAwal: ");
        list7.hapusSatuDataDiAwal();
        list7.cetak("Setelah hapusSatuDataDiAwal: ");
        
        // TEST 13: hapusSatuDataDiAwal pada list dengan satu data
        System.out.println("\n[TEST 13] hapusSatuDataDiAwal pada list dengan satu data");
        CircularSingleLinkedList list8 = new CircularSingleLinkedList();
        list8.SisipDataDiAwal("SOLO");
        list8.cetak("Sebelum hapusSatuDataDiAwal: ");
        list8.hapusSatuDataDiAwal();
        list8.cetak("Setelah hapusSatuDataDiAwal: ");
        
        // TEST 14: hapusSatuDataDiAwal pada list kosong
        System.out.println("\n[TEST 14] hapusSatuDataDiAwal pada list kosong");
        CircularSingleLinkedList list9 = new CircularSingleLinkedList();
        list9.cetak("Sebelum hapusSatuDataDiAwal: ");
        list9.hapusSatuDataDiAwal();
        list9.cetak("Setelah hapusSatuDataDiAwal: ");
        
        // TEST 15: hapusSatuDataDiAkhir pada list dengan banyak data
        System.out.println("\n[TEST 15] hapusSatuDataDiAkhir pada list dengan banyak data");
        CircularSingleLinkedList list10 = new CircularSingleLinkedList();
        list10.SisipDataDiAkhir("X");
        list10.SisipDataDiAkhir("Y");
        list10.SisipDataDiAkhir("Z");
        list10.cetak("Sebelum hapusSatuDataDiAkhir: ");
        list10.hapusSatuDataDiAkhir();
        list10.cetak("Setelah hapusSatuDataDiAkhir: ");
        
        // TEST 16: hapusSatuDataDiAkhir pada list dengan satu data
        System.out.println("\n[TEST 16] hapusSatuDataDiAkhir pada list dengan satu data");
        CircularSingleLinkedList list11 = new CircularSingleLinkedList();
        list11.SisipDataDiAwal("SINGLE");
        list11.cetak("Sebelum hapusSatuDataDiAkhir: ");
        list11.hapusSatuDataDiAkhir();
        list11.cetak("Setelah hapusSatuDataDiAkhir: ");
        
        // TEST 17: hapusSatuDataDiAkhir pada list kosong
        System.out.println("\n[TEST 17] hapusSatuDataDiAkhir pada list kosong");
        CircularSingleLinkedList list12 = new CircularSingleLinkedList();
        list12.cetak("Sebelum hapusSatuDataDiAkhir: ");
        list12.hapusSatuDataDiAkhir();
        list12.cetak("Setelah hapusSatuDataDiAkhir: ");
        
        // TEST 18: Operasi berurutan kompleks
        System.out.println("\n[TEST 18] Operasi berurutan kompleks");
        CircularSingleLinkedList list13 = new CircularSingleLinkedList();
        list13.SisipDataDiAwal(5);
        list13.cetak("Setelah SisipDataDiAwal(5): ");
        list13.SisipDataDiAkhir(10);
        list13.cetak("Setelah SisipDataDiAkhir(10): ");
        list13.SisipDataDiAwal(1);
        list13.cetak("Setelah SisipDataDiAwal(1): ");
        list13.SisipDataDiAkhir(15);
        list13.cetak("Setelah SisipDataDiAkhir(15): ");
        list13.hapusSatuDataDiAwal();
        list13.cetak("Setelah hapusSatuDataDiAwal: ");
        list13.hapusSatuDataDiAkhir();
        list13.cetak("Setelah hapusSatuDataDiAkhir: ");
        list13.hapusData(5);
        list13.cetak("Setelah hapusData(5): ");
        
        // TEST 19: Hapus berurutan sampai list kosong
        System.out.println("\n[TEST 19] Hapus berurutan sampai list kosong");
        CircularSingleLinkedList list14 = new CircularSingleLinkedList();
        list14.SisipDataDiAkhir(11);
        list14.SisipDataDiAkhir(22);
        list14.SisipDataDiAkhir(33);
        list14.cetak("List awal: ");
        list14.hapusSatuDataDiAwal();
        list14.cetak("Setelah hapus di awal: ");
        list14.hapusSatuDataDiAkhir();
        list14.cetak("Setelah hapus di akhir: ");
        list14.hapusSatuDataDiAwal();
        list14.cetak("Setelah hapus di awal lagi: ");
        
        // TEST 20: Test dengan tipe data berbeda (String dan Integer)
        System.out.println("\n[TEST 20] Test dengan tipe data berbeda");
        CircularSingleLinkedList list15 = new CircularSingleLinkedList();
        list15.SisipDataDiAkhir("Hello");
        list15.SisipDataDiAkhir(123);
        list15.SisipDataDiAkhir("World");
        list15.SisipDataDiAkhir(456);
        list15.cetak("List dengan berbagai tipe data: ");
        list15.hapusData("Hello");
        list15.cetak("Setelah hapusData(\"Hello\"): ");
        list15.hapusData(456);
        list15.cetak("Setelah hapusData(456): ");
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PENGUJIAN SELESAI");
        System.out.println("=".repeat(70));
    }
}