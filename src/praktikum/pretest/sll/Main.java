package praktikum.pretest.sll;

public class Main {

    public static void main(String[] args) {
        // Membuat objek list yang akan digunakan di semua method pengujian
        SLL<Mahasiswa> list = new SLL<>();

        // Memanggil setiap method pengujian fungsionalitas utama
        testInisialisasiDanKondisiAwal(list); // Sebenarnya method inisialisasi tidak berguna karena sudah ada constructor di Node 
        testPenambahan(list);
        testPengaksesan(list);
        testPencarian(list);
        testPenyisipan(list);
        testPenghapusan(list);

        // Memanggil method pengujian exception 
        testEmptyListExceptions();
        testIndexOutOfBoundsExceptions();
    }

    /**
     * Menguji inisialisasi, isEmpty(), dan size() pada list yang baru dibuat.
     */
    public static void testInisialisasiDanKondisiAwal(SLL<Mahasiswa> list) {
        System.out.println("--- Operasi Inisialisasi & Cek Kondisi Awal ---");
        list.inisialisasi();
        System.out.println("List baru berhasil dibuat dan diinisialisasi.");
        System.out.println("Apakah list kosong (isEmpty)? " + list.isEmpty()); // Harusnya true
        System.out.println("Ukuran list (size): " + list.size() + "\n"); // Harusnya 0
    }

    /**
     * Menguji penambahan data menggunakan addFirst() dan addLast().
     */
    public static void testPenambahan(SLL<Mahasiswa> list) {
        System.out.println("--- Operasi Penambahan ---");
        // Membuat objek Mahasiswa untuk pengujian
        Mahasiswa mhs1 = new Mahasiswa("245150700111022", "Hery", 3.0);
        Mahasiswa mhs2 = new Mahasiswa("245150401111035", "Budi Santoso", 3.55);
        Mahasiswa mhs3 = new Mahasiswa("245150207111011", "Citra Kirana", 3.82);
        Mahasiswa mhs4 = new Mahasiswa("245150300111048", "Dewi Lestari", 2.97);
        Mahasiswa mhs5 = new Mahasiswa("245150601111057", "Eka Wijaya", 3.21);

        System.out.println("Menambahkan 'Budi' dan 'Citra' menggunakan addFirst...");
        list.addFirst(mhs3); // List: [Citra]
        list.addFirst(mhs2); // List: [Budi, Citra]
        System.out.println("Menambahkan 'Hery', 'Dewi', dan 'Eka' menggunakan addLast...");
        list.addLast(mhs1);  // List: [Budi, Citra, Hery]
        list.addLast(mhs4);
        list.addLast(mhs5);
        
        System.out.println("List Final Setelah Penambahan:");
        System.out.println(list);
        System.out.println("Ukuran list saat ini: " + list.size() + "\n"); // Harusnya 5
    }
    
    /**
     * Menguji akses data menggunakan getFirst(), getLast(), dan getAtIndex().
     */
    public static void testPengaksesan(SLL<Mahasiswa> list) {
        System.out.println("--- perasi Pengaksesan ---");
        System.out.println("List saat ini:\n" + list);
        System.out.println("Mengambil data pertama (getFirst): " + list.getFirst()); // Harusnya Budi
        System.out.println("Mengambil data terakhir (getLast): " + list.getLast()); // Harusnya Eka
        System.out.println("Mengambil data di index 2 (getAtIndex(2)): " + list.getAtIndex(2) + "\n"); // Harusnya Hery
    }
    
    /**
     * Menguji pencarian data menggunakan indexOf() dan contain().
     */
    public static void testPencarian(SLL<Mahasiswa> list) {
        System.out.println("--- Operasi Pencarian ---");
        Mahasiswa mhs4 = new Mahasiswa("245150300111048", "Dewi Lestari", 2.97);
        Mahasiswa mhs3 = new Mahasiswa("245150207111011", "Citra Kirana", 3.82);

        System.out.println("List saat ini:\n" + list);
        System.out.println("Mencari index dari 'Dewi Lestari' (indexOf)...");
        System.out.println("Hasil: " + list.indexOf(mhs4)); // Harusnya 3
        System.out.println("Mengecek keberadaan 'Citra Kirana' (contain)...");
        System.out.println("Hasil: " + list.contain(mhs3) + "\n"); // Harusnya true
    }
    
    /**
     * Menguji penyisipan data menggunakan addAtIndex().
     */
    public static void testPenyisipan(SLL<Mahasiswa> list) {
        System.out.println("--- Operasi Penyisipan ---");
        Mahasiswa mhs6 = new Mahasiswa("212314718271", "Andre Suryono", 3.56);
        System.out.println("List Sebelum:\n" + list);
        System.out.println("Menyisipkan 'Andre Suryono' di index 2 (addAtIndex)...");
        list.addAtIndex(2, mhs6);
        System.out.println("List Sesudah:\n" + list);
        System.out.println("Ukuran list saat ini: " + list.size() + "\n"); // Harusnya 6
    }

    /**
     * Menguji penghapusan data menggunakan removeFirst(), removeLast(), removeAtIndex(), dan clear().
     */
    public static void testPenghapusan(SLL<Mahasiswa> list) {
        System.out.println("--- Operasi Penghapusan ---");
        System.out.println("List Sebelum:\n" + list);
        System.out.println("Menghapus data pertama (removeFirst)...");
        list.removeFirst();
        System.out.println("List Sesudah:\n" + list);

        System.out.println("Menghapus data terakhir (removeLast)...");
        list.removeLast();
        System.out.println("List Sesudah:\n" + list);

        System.out.println("Menghapus data di index 1 (removeAtIndex(1))...");
        list.removeAtIndex(1);
        System.out.println("List Sesudah:\n" + list);
        
        System.out.println("Mengosongkan seluruh list (clear)...");
        list.clear();
        System.out.println("List Sesudah di-clear:\n" + list);
        System.out.println("Ukuran list setelah clear: " + list.size() + "\n"); // Harusnya 0
    }

    /**
     * Menguji kasus-kasus yang melemparkan NoSuchElementException pada list kosong.
     */
    public static void testEmptyListExceptions() {
        System.out.println("--- pengujian Exception pada List Kosong ---");
        SLL<Mahasiswa> listKosong = new SLL<>();

        try {
            System.out.print("Mencoba getFirst() pada list kosong: ");
            listKosong.getFirst();
        } catch (Exception e) {
            System.out.println("Exception tertangkap -> " + e.getMessage());
        }
        try {
            System.out.print("Mencoba removeLast() pada list kosong: ");
            listKosong.removeLast();
        } catch (Exception e) {
            System.out.println("Exception tertangkap -> " + e.getMessage());
        }
        try {
            System.out.print("Mencoba getAtIndex(0) pada list kosong: ");
            listKosong.getAtIndex(0);
        } catch (Exception e) {
            System.out.println("Exception tertangkap -> " + e.getMessage());
        }
    }

    /**
     * Menguji kasus-kasus yang melemparkan IndexOutOfBoundsException.
     */
    public static void testIndexOutOfBoundsExceptions() {
        System.out.println("\n--- Pengujian Exception Index di Luar Batas ---");
        SLL<Mahasiswa> listTest = new SLL<>();
        listTest.addFirst(new Mahasiswa("000", "Tester", 4.0));
        System.out.println("List untuk pengujian dibuat dengan 1 data:");
        System.out.println(listTest);
        
        try {
            System.out.print("Mencoba addAtIndex(5, data) pada list ukuran 1: ");
            listTest.addAtIndex(5, new Mahasiswa("111", "Tester 2", 3.0));
        } catch (Exception e) {
            System.out.println("Exception tertangkap -> " + e.getMessage());
        }
        try {
            System.out.print("Mencoba getAtIndex(1) pada list ukuran 1: ");
            listTest.getAtIndex(1);
        } catch (Exception e) {
            System.out.println("Exception tertangkap -> " + e.getMessage());
        }
        try {
            System.out.print("Mencoba removeAtIndex(-1) dengan index negatif: ");
            listTest.removeAtIndex(-1);
        } catch (Exception e) {
            System.out.println("Exception tertangkap -> " + e.getMessage());
        }
    }
}