package main.caseBinaryTree;

/**
 * Class untuk menerjemahkan (decode) kode Morse ke teks.
 */
public class MorseDecoder {
    
    private static Node root = PohonMorse.getRoot();

    /**
     * Menerjemahkan String morse menjadi teks biasa.
     * @param morse Input String kode morse.
     */
    public void decode(String morse) {

        String[] kata = morse.split(" ");

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

                        current = current.kiri;
                    } else {

                        current = current.kanan;
                    }
                }

                hasil.append(current.data);
            }
        }

        System.out.println(hasil.toString());
    }
}