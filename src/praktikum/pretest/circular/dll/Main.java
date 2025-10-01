package praktikum.pretest.circular.dll;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("PENGUJIAN CIRCULAR DOUBLE LINKED LIST");
        System.out.println("=".repeat(70));
        
        // TEST 1: SisipDataDiAwal pada list kosong
        System.out.println("\n[TEST 1] SisipDataDiAwal pada list kosong");
        CircularDoubleLinkedList list1 = new CircularDoubleLinkedList();
        list1.cetak("Sebelum: ");
        list1.SisipDataDiAwal(10);
        list1.cetak("Setelah SisipDataDiAwal(10): ");
        System.out.println("Size: " + list1.getSize());
        
        // TEST 2: SisipDataDiAwal pada list yang sudah ada data
        System.out.println("\n[TEST 2] SisipDataDiAwal pada list yang sudah ada data");
        list1.cetak("Sebelum: ");
        list1.SisipDataDiAwal(20);
        list1.cetak("Setelah SisipDataDiAwal(20): ");
        list1.SisipDataDiAwal(30);
        list1.cetak("Setelah SisipDataDiAwal(30): ");
        list1.SisipDataDiAwal(40);
        list1.cetak("Setelah SisipDataDiAwal(40): ");
        System.out.println("Size: " + list1.getSize());
        
        // TEST 3: SisipDataDiAkhir pada list kosong
        System.out.println("\n[TEST 3] SisipDataDiAkhir pada list kosong");
        CircularDoubleLinkedList list2 = new CircularDoubleLinkedList();
        list2.cetak("Sebelum: ");
        list2.SisipDataDiAkhir(100);
        list2.cetak("Setelah SisipDataDiAkhir(100): ");
        System.out.println("Size: " + list2.getSize());
        
        // TEST 4: SisipDataDiAkhir pada list yang sudah ada data
        System.out.println("\n[TEST 4] SisipDataDiAkhir pada list yang sudah ada data");
        list2.cetak("Sebelum: ");
        list2.SisipDataDiAkhir(200);
        list2.cetak("Setelah SisipDataDiAkhir(200): ");
        list2.SisipDataDiAkhir(300);
        list2.cetak("Setelah SisipDataDiAkhir(300): ");
        list2.SisipDataDiAkhir(400);
        list2.cetak("Setelah SisipDataDiAkhir(400): ");
        System.out.println("Size: " + list2.getSize());
        
        // TEST 5: Kombinasi SisipDataDiAwal dan SisipDataDiAkhir
        System.out.println("\n[TEST 5] Kombinasi SisipDataDiAwal dan SisipDataDiAkhir");
        CircularDoubleLinkedList list3 = new CircularDoubleLinkedList();
        list3.SisipDataDiAwal(50);
        list3.cetak("Setelah SisipDataDiAwal(50): ");
        list3.SisipDataDiAkhir(60);
        list3.cetak("Setelah SisipDataDiAkhir(60): ");
        list3.SisipDataDiAwal(40);
        list3.cetak("Setelah SisipDataDiAwal(40): ");
        list3.SisipDataDiAkhir(70);
        list3.cetak("Setelah SisipDataDiAkhir(70): ");
        list3.SisipDataDiAwal(30);
        list3.cetak("Setelah SisipDataDiAwal(30): ");
        System.out.println("Size: " + list3.getSize());
        
        // TEST 6: hapusData - data di tengah
        System.out.println("\n[TEST 6] hapusData - menghapus data di tengah");
        CircularDoubleLinkedList list4 = new CircularDoubleLinkedList();
        list4.SisipDataDiAkhir(1);
        list4.SisipDataDiAkhir(2);
        list4.SisipDataDiAkhir(3);
        list4.SisipDataDiAkhir(4);
        list4.SisipDataDiAkhir(5);
        list4.cetak("Sebelum hapusData(3): ");
        System.out.println("Size sebelum: " + list4.getSize());
        list4.hapusData(3);
        list4.cetak("Setelah hapusData(3): ");
        System.out.println("Size setelah: " + list4.getSize());
        
        // TEST 7: hapusData - data di awal (head)
        System.out.println("\n[TEST 7] hapusData - menghapus data di awal (head)");
        list4.cetak("Sebelum hapusData(1): ");
        System.out.println("Size sebelum: " + list4.getSize());
        list4.hapusData(1);
        list4.cetak("Setelah hapusData(1): ");
        System.out.println("Size setelah: " + list4.getSize());
        
        // TEST 8: hapusData - data di akhir (tail)
        System.out.println("\n[TEST 8] hapusData - menghapus data di akhir (tail)");
        list4.cetak("Sebelum hapusData(5): ");
        System.out.println("Size sebelum: " + list4.getSize());
        list4.hapusData(5);
        list4.cetak("Setelah hapusData(5): ");
        System.out.println("Size setelah: " + list4.getSize());
        
        // TEST 9: hapusData - data yang tidak ada
        System.out.println("\n[TEST 9] hapusData - menghapus data yang tidak ada");
        list4.cetak("Sebelum hapusData(999): ");
        System.out.println("Size sebelum: " + list4.getSize());
        list4.hapusData(999);
        list4.cetak("Setelah hapusData(999): ");
        System.out.println("Size setelah: " + list4.getSize());
        
        // TEST 10: hapusData - satu-satunya data dalam list
        System.out.println("\n[TEST 10] hapusData - menghapus satu-satunya data");
        CircularDoubleLinkedList list5 = new CircularDoubleLinkedList();
        list5.SisipDataDiAwal(555);
        list5.cetak("Sebelum hapusData(555): ");
        System.out.println("Size sebelum: " + list5.getSize());
        list5.hapusData(555);
        list5.cetak("Setelah hapusData(555): ");
        System.out.println("Size setelah: " + list5.getSize());
        
        // TEST 11: hapusData pada list kosong
        System.out.println("\n[TEST 11] hapusData pada list kosong");
        CircularDoubleLinkedList list6 = new CircularDoubleLinkedList();
        list6.cetak("Sebelum hapusData(100): ");
        System.out.println("Size sebelum: " + list6.getSize());
        list6.hapusData(100);
        list6.cetak("Setelah hapusData(100): ");
        System.out.println("Size setelah: " + list6.getSize());
        
        // TEST 12: Hapus semua data satu per satu dari awal
        System.out.println("\n[TEST 12] Hapus semua data satu per satu dari awal");
        CircularDoubleLinkedList list7 = new CircularDoubleLinkedList();
        list7.SisipDataDiAkhir("A");
        list7.SisipDataDiAkhir("B");
        list7.SisipDataDiAkhir("C");
        list7.cetak("List awal: ");
        System.out.println("Size: " + list7.getSize());
        list7.hapusData("A");
        list7.cetak("Setelah hapus A: ");
        System.out.println("Size: " + list7.getSize());
        list7.hapusData("B");
        list7.cetak("Setelah hapus B: ");
        System.out.println("Size: " + list7.getSize());
        list7.hapusData("C");
        list7.cetak("Setelah hapus C: ");
        System.out.println("Size: " + list7.getSize());
        
        // TEST 13: Operasi berurutan kompleks
        System.out.println("\n[TEST 13] Operasi berurutan kompleks");
        CircularDoubleLinkedList list8 = new CircularDoubleLinkedList();
        list8.SisipDataDiAwal(5);
        list8.cetak("Setelah SisipDataDiAwal(5): ");
        list8.SisipDataDiAkhir(10);
        list8.cetak("Setelah SisipDataDiAkhir(10): ");
        list8.SisipDataDiAwal(1);
        list8.cetak("Setelah SisipDataDiAwal(1): ");
        list8.SisipDataDiAkhir(15);
        list8.cetak("Setelah SisipDataDiAkhir(15): ");
        list8.SisipDataDiAwal(-5);
        list8.cetak("Setelah SisipDataDiAwal(-5): ");
        System.out.println("Size: " + list8.getSize());
        list8.hapusData(1);
        list8.cetak("Setelah hapusData(1): ");
        list8.hapusData(15);
        list8.cetak("Setelah hapusData(15): ");
        list8.hapusData(5);
        list8.cetak("Setelah hapusData(5): ");
        System.out.println("Size: " + list8.getSize());
        
        // TEST 14: Test dengan banyak data
        System.out.println("\n[TEST 14] Test dengan banyak data");
        CircularDoubleLinkedList list9 = new CircularDoubleLinkedList();
        for (int i = 1; i <= 10; i++) {
            list9.SisipDataDiAkhir(i * 10);
        }
        list9.cetak("List dengan 10 data: ");
        System.out.println("Size: " + list9.getSize());
        list9.hapusData(50);
        list9.cetak("Setelah hapusData(50): ");
        list9.hapusData(10);
        list9.cetak("Setelah hapusData(10): ");
        list9.hapusData(100);
        list9.cetak("Setelah hapusData(100): ");
        System.out.println("Size: " + list9.getSize());
        
        // TEST 15: Test dengan tipe data berbeda
        System.out.println("\n[TEST 15] Test dengan tipe data berbeda (String dan Integer)");
        CircularDoubleLinkedList list10 = new CircularDoubleLinkedList();
        list10.SisipDataDiAkhir("Hello");
        list10.SisipDataDiAkhir(123);
        list10.SisipDataDiAkhir("World");
        list10.SisipDataDiAkhir(456);
        list10.SisipDataDiAkhir("Java");
        list10.cetak("List dengan berbagai tipe data: ");
        System.out.println("Size: " + list10.getSize());
        list10.hapusData("Hello");
        list10.cetak("Setelah hapusData(\"Hello\"): ");
        list10.hapusData(456);
        list10.cetak("Setelah hapusData(456): ");
        System.out.println("Size: " + list10.getSize());
    }

}