package praktikum.pretest.dll;

public class Main {
    public static void main(String[] args) {
        // Membuat objek DLL untuk menyimpan data Mahasiswa
        DLL<Mahasiswa> dllMahasiswa = new DLL<>();
        
        // Inisialisasi DLL
        dllMahasiswa.inisialisasi();
        
        System.out.println("===== PROGRAM TEST DOUBLY LINKED LIST MAHASISWA =====\n");
        
        // Membuat 5 objek Mahasiswa
        Mahasiswa mhs1 = new Mahasiswa("2024001", "Ahmad Rizki", 3.85);
        Mahasiswa mhs2 = new Mahasiswa("2024002", "Budi Santoso", 3.65);
        Mahasiswa mhs3 = new Mahasiswa("2024003", "Citra Dewi", 3.92);
        Mahasiswa mhs4 = new Mahasiswa("2024004", "Dian Pratama", 3.45);
        Mahasiswa mhs5 = new Mahasiswa("2024005", "Eka Putri", 3.78);
        
        // TEST 1: Cek apakah DLL kosong
        System.out.println("TEST 1: CEK STATUS AWAL DLL");
        System.out.println("Apakah DLL kosong? " + dllMahasiswa.isEmpty());
        System.out.println("Ukuran DLL: " + dllMahasiswa.size());
        System.out.println();
        
        // TEST 2: Menambahkan data dengan add() dan addLast()
        System.out.println("TEST 2: MENAMBAHKAN DATA DENGAN add() dan addLast()");
        dllMahasiswa.add(mhs1);
        System.out.println("Menambahkan: " + mhs1);
        dllMahasiswa.addLast(mhs2);
        System.out.println("Menambahkan di akhir: " + mhs2);
        System.out.println("Ukuran DLL sekarang: " + dllMahasiswa.size());
        System.out.println("\nIsi DLL:");
        System.out.println(dllMahasiswa.toString());
        
        // TEST 3: Menambahkan data dengan addFirst()
        System.out.println("TEST 3: MENAMBAHKAN DATA DI AWAL dengan addFirst()");
        dllMahasiswa.addFirst(mhs3);
        System.out.println("Menambahkan di awal: " + mhs3);
        System.out.println("Ukuran DLL sekarang: " + dllMahasiswa.size());
        System.out.println("\nIsi DLL:");
        System.out.println(dllMahasiswa.toString());
        
        // TEST 4: Menambahkan data pada index tertentu
        System.out.println("TEST 4: MENAMBAHKAN DATA PADA INDEX TERTENTU");
        dllMahasiswa.addAtIndex(1, mhs4);
        System.out.println("Menambahkan pada index 1: " + mhs4);
        System.out.println("Ukuran DLL sekarang: " + dllMahasiswa.size());
        System.out.println("\nIsi DLL:");
        System.out.println(dllMahasiswa.toString());
        
        // Tambahkan mhs5 untuk memiliki 5 mahasiswa
        dllMahasiswa.add(mhs5);
        System.out.println("Menambahkan: " + mhs5);
        System.out.println("Ukuran DLL sekarang: " + dllMahasiswa.size());
        System.out.println("\nIsi DLL lengkap (5 Mahasiswa):");
        System.out.println(dllMahasiswa.toString());
        
        // TEST 5: Mengakses data
        System.out.println("TEST 5: MENGAKSES DATA");
        System.out.println("Data pertama: " + dllMahasiswa.getFirst());
        System.out.println("Data terakhir: " + dllMahasiswa.getLast());
        System.out.println("Data pada index 2: " + dllMahasiswa.getAtIndex(2));
        System.out.println();
        
        // TEST 6: Mencari data
        System.out.println("TEST 6: PENCARIAN DATA");
        System.out.println("Apakah DLL mengandung " + mhs3.getNama() + "? " + 
                          dllMahasiswa.isContain(mhs3));
        
        // Membuat mahasiswa baru yang tidak ada di DLL
        Mahasiswa mhsTidakAda = new Mahasiswa("2024999", "Tidak Ada", 3.00);
        System.out.println("Apakah DLL mengandung " + mhsTidakAda.getNama() + "? " + 
                          dllMahasiswa.isContain(mhsTidakAda));
        
        System.out.println("Index dari " + mhs2.getNama() + ": " + 
                          dllMahasiswa.indexOf(mhs2));
        System.out.println("Index dari " + mhsTidakAda.getNama() + ": " + 
                          dllMahasiswa.indexOf(mhsTidakAda));
        System.out.println();
        
        // TEST 7: Menghapus data
        System.out.println("TEST 7: PENGHAPUSAN DATA");
        System.out.println("Ukuran DLL sebelum penghapusan: " + dllMahasiswa.size());
        
        System.out.println("\nMenghapus data pertama...");
        dllMahasiswa.removeFirst();
        System.out.println("Ukuran DLL: " + dllMahasiswa.size());
        System.out.println("Isi DLL:");
        System.out.println(dllMahasiswa.toString());
        
        System.out.println("Menghapus data terakhir...");
        dllMahasiswa.removeLast();
        System.out.println("Ukuran DLL: " + dllMahasiswa.size());
        System.out.println("Isi DLL:");
        System.out.println(dllMahasiswa.toString());
        
        System.out.println("Menghapus data pada index 1...");
        dllMahasiswa.removeAtIndex(1);
        System.out.println("Ukuran DLL: " + dllMahasiswa.size());
        System.out.println("Isi DLL:");
        System.out.println(dllMahasiswa.toString());
        
        // TEST 8: Error handling untuk index yang salah
        System.out.println("TEST 8: ERROR HANDLING");
        try {
            System.out.println("Mencoba mengakses index yang tidak valid (index 10):");
            dllMahasiswa.getAtIndex(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error tertangkap: " + e.getMessage());
        }
        
        try {
            System.out.println("Mencoba menghapus pada index negatif (index -1):");
            dllMahasiswa.removeAtIndex(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error tertangkap: " + e.getMessage());
        }
        System.out.println();
        
        // TEST 9: Menghapus semua data
        System.out.println("TEST 9: MENGHAPUS SEMUA DATA");
        System.out.println("Ukuran DLL sebelum removeAll(): " + dllMahasiswa.size());
        dllMahasiswa.removeAll();
        System.out.println("Ukuran DLL setelah removeAll(): " + dllMahasiswa.size());
        System.out.println("Apakah DLL kosong? " + dllMahasiswa.isEmpty());
        System.out.println("Isi DLL: " + dllMahasiswa.toString());
        System.out.println();
        
        // TEST 10: Operasi pada DLL kosong
        System.out.println("TEST 10: OPERASI PADA DLL KOSONG");
        System.out.println("Mencoba removeFirst() pada DLL kosong...");
        dllMahasiswa.removeFirst();
        System.out.println("Tidak terjadi error.");
        
        System.out.println("Mencoba removeLast() pada DLL kosong...");
        dllMahasiswa.removeLast();
        System.out.println("Tidak terjadi error.");
        System.out.println();
    }
}