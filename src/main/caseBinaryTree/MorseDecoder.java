package main.caseBinaryTree;

/**
 * Class untuk menerjemahkan (decode) kode Morse ke teks.
 */
public class MorseDecoder {
    // Ambil root dari pohon morse yang sudah dibuat.
    private static Node root = PohonMorse.getRoot();

    /**
     * Menerjemahkan String morse menjadi teks biasa.
     * @param morse Input String kode morse.
     */
    public void decode(String morse) {
        // Pisahkan kode morse per huruf contoh: (.-- ... ---) .
        String[] kata = morse.split(" ");

        // Siapkan penampung hasil terjemahan.
        StringBuilder hasil = new StringBuilder();

        // Loop untuk setiap kode huruf.
        for (String huruf : kata) {
            // Mulai lagi dari root untuk setiap huruf baru.
            Node current = root;

            if (huruf.equals("/")) {
                // Jika "/", tambahkan spasi antar kata.
                hasil.append(" ");
                 
            } else {
                // Loop untuk setiap simbol titik (.) atau garis (-).
                for (char simbol : huruf.toCharArray()) {
                    if (simbol == '.') {
                        // Titik: ke kiri.
                        current = current.kiri;
                    } else {
                        // Garis: ke kanan.
                        current = current.kanan;
                    }
                }
                // Tambahkan karakter yang ditemukan ke hasil.
                hasil.append(current.data);
            }
        }
        // Tampilkan hasil akhir.
        System.out.println(hasil.toString());
    }
}