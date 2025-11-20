package praktikum.pretest.sorting.tugas;

public class TugasDuaPegawai {

    // Data Class Pegawai
    static class Pegawai {
        String nip;
        String nama;

        Pegawai(String nip, String nama) {
            this.nip = nip;
            this.nama = nama;
        }

        void tampil() {
            System.out.println(nip + " - " + nama);
        }
    }

    // Algoritma Sorting (dari Bubble Sort)
    static void sortPegawai(Pegawai[] arr, boolean isAscending, boolean isByNip) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {

                // Mengambil dua objek yang akan dibandingkan
                Pegawai p1 = arr[j - 1]; 
                Pegawai p2 = arr[j];

                int hasilBanding;

                // Tentukan mau bandingkan NIP atau Nama
                if (isByNip) {
                    hasilBanding = p1.nip.compareTo(p2.nip);
                } else {
                    hasilBanding = p1.nama.compareTo(p2.nama);
                }

                boolean tukar = false;

                // Jika Ascending: tukar kalau kiri > kanan (hasilBanding > 0)
                // Jika Descending: tukar kalau kiri < kanan (hasilBanding < 0)
                if (isAscending) {
                    if (hasilBanding > 0)
                        tukar = true;
                } else {
                    if (hasilBanding < 0)
                        tukar = true;
                }

                // Eksekusi penukaran
                if (tukar) {
                    Pegawai temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    static void printPegawai(Pegawai[] arr) {
        for (Pegawai p : arr) {
            p.tampil();
        }
    }

    public static void main(String[] args) {
        Pegawai[] data = {
                new Pegawai("105", "Budi"),
                new Pegawai("102", "Andi"),
                new Pegawai("108", "Zara"),
                new Pegawai("101", "Citra"),
                new Pegawai("103", "Dedi")
        };

        System.out.println("--- Data Awal ---");
        printPegawai(data);

        // 1. Sort by NIP (Ascending)
        sortPegawai(data, true, true);
        System.out.println("\n--- Urut NIP (Ascending) ---");
        printPegawai(data);

        // 2. Sort by Nama (Descending)
        sortPegawai(data, false, false);
        System.out.println("\n--- Urut Nama (Descending) ---");
        printPegawai(data);
    }

}