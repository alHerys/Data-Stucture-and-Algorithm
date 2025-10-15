package main.tugas.queue;

public class Main {
    public static void main(String[] args) {

        // 1. Membuat dan mengisi Priority Queue
        MyPriorityQueue<Integer> antrianAsli = new MyPriorityQueue<>();
        antrianAsli.add(50);
        antrianAsli.add(20);
        antrianAsli.add(80);

        // Menampilkan priority queue
        System.out.println("### Keadaan Awal ###");
        System.out.println("Antrian Asli: " + antrianAsli);
        System.out.println("----------------------------------------");

        // 2. Menggunakan metode clone() untuk membuat salinan
        MyPriorityQueue<Integer> antrianHasilClone = null; // mula-mula di isi dengan null
        try {

            // Melakukan clone
            antrianHasilClone = antrianAsli.clone();

            // Menampilkan hasil clone
            System.out.println("### Proses Cloning ###");
            System.out.println("Antrian Hasil Clone: " + antrianHasilClone);
            System.out.println("----------------------------------------");
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning gagal: " + e.getMessage());
        }

        // 3. Membuktikan bahwa kedua antrian adalah objek yang berbeda
        System.out.println("### Pembuktian Independensi ###");
        // Menambahkan elemen baru HANYA ke antrian hasil clone
        antrianHasilClone.add(10);
        System.out.println("Aksi: Menambahkan elemen '10' ke antrian hasil clone.");

        // Menampilkan elemen asli dengan hasil clone nya
        System.out.println("\n--- Hasil Akhir ---");
        System.out.println("Antrian Asli (tidak berubah): " + antrianAsli);
        System.out.println("Antrian Hasil Clone (berubah):  " + antrianHasilClone);

        // Membandingkan alamat memori kedua objek untuk menguji deep clone
        boolean isSameObject = (antrianAsli == antrianHasilClone);
        System.out.println("\nApakah kedua variabel menunjuk ke objek yang sama di memori? " + isSameObject);
    }
}
