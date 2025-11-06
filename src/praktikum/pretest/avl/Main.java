package praktikum.pretest.avl;

public class Main {
    public static void main(String[] args) {
        AVLT t = new AVLT();

        // --- PENGUJIAN PENYISIPAN (SOAL LATIHAN) ---
        System.out.println("Menyisipkan 3:");
        t.sisipDt(3);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 4:");
        t.sisipDt(4);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 6 (Trigger Rotasi Kiri/Kasus 2):");
        t.sisipDt(6);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 5 (Trigger Rotasi Kanan-Kiri/Kasus 4):");
        t.sisipDt(5);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 15:");
        t.sisipDt(15);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 10 (Trigger Rotasi Kanan-Kiri/Kasus 4):");
        t.sisipDt(10);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 20:");
        t.sisipDt(20);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 17 (Trigger Rotasi Kanan-Kiri/Kasus 4):");
        t.sisipDt(17);
        t.inOrderTraversal();
        System.out.println("\n");

        System.out.println("Menyisipkan 25:");
        t.sisipDt(25);
        t.inOrderTraversal(); // Output akhir sisip: -3-4-5-6-10-15-17-20-25-
        System.out.println("\n");

        // --- PENGUJIAN PENGHAPUSAN (SOAL TUGAS) ---
        System.out.println("-------------------------------------------");
        System.out.println("MULAI PENGUJIAN HAPUS (SOAL TUGAS)");
        System.out.println("Tree saat ini: -3-4-5-6-10-15-17-20-25-");
        System.out.println("-------------------------------------------\n");

        // KASUS 1: Menghapus node daun (contoh: 15)
        System.out.println("Menghapus 15 (Kasus 1: Node Daun):");
        t.hapusDt(15);
        t.inOrderTraversal();
        System.out.println("\n"); // Harusnya: -3-4-5-6-10-17-20-25-

        // KASUS 2: Menghapus node dengan 1 anak (contoh: 20)
        // (Node 20 memiliki 1 anak, yaitu 25)
        System.out.println("Menghapus 20 (Kasus 2: 1 Anak):");
        t.hapusDt(20);
        t.inOrderTraversal();
        System.out.println("\n"); // Harusnya: -3-4-5-6-10-17-25-

        // KASUS 3: Menghapus node dengan 2 anak (contoh: 6)
        // (Node 6 memiliki 2 anak, 5 dan 10. Suksesornya 10)
        System.out.println("Menghapus 6 (Kasus 3: 2 Anak):");
        t.hapusDt(6);
        t.inOrderTraversal();
        System.out.println("\n"); // Harusnya: -3-4-5-10-17-25-

        System.out.println("--- PENGUJIAN HAPUS SELESAI ---");
    }
}