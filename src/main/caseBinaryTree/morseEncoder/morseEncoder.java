package main.caseBinaryTree.morseEncoder;

public class morseEncoder {
    static Node pohonMorse;

    static {
        pohonMorse = new Node(" ");

        // 1st Level
        pohonMorse.kiri = new Node("E");
        pohonMorse.kanan = new Node("T");

        // 2nd Level
        pohonMorse.kiri.kiri = new Node("I");
        pohonMorse.kiri.kanan = new Node("A");
        pohonMorse.kanan.kiri = new Node("N");
        pohonMorse.kanan.kanan = new Node("M");

        // 3rd Level
        pohonMorse.kiri.kiri.kiri = new Node("S");
        pohonMorse.kiri.kiri.kanan = new Node("U");
        pohonMorse.kiri.kanan.kiri = new Node("R");
        pohonMorse.kiri.kanan.kanan = new Node("W");
        pohonMorse.kanan.kiri.kiri = new Node("D");
        pohonMorse.kanan.kiri.kanan = new Node("K");
        pohonMorse.kanan.kanan.kiri = new Node("G");
        pohonMorse.kanan.kanan.kanan = new Node("O");

        // 4th Level
        pohonMorse.kiri.kiri.kiri.kiri = new Node("H");
        pohonMorse.kiri.kiri.kiri.kanan = new Node("V");
        pohonMorse.kiri.kiri.kanan.kiri = new Node("F");
        pohonMorse.kiri.kanan.kiri.kiri = new Node("L");
        pohonMorse.kiri.kanan.kanan.kiri = new Node("P");
        pohonMorse.kiri.kanan.kanan.kanan = new Node("J");
        pohonMorse.kanan.kiri.kiri.kiri = new Node("B");
        pohonMorse.kanan.kiri.kiri.kanan = new Node("X");
        pohonMorse.kanan.kiri.kanan.kiri = new Node("C");
        pohonMorse.kanan.kiri.kanan.kanan = new Node("Y");
        pohonMorse.kanan.kanan.kiri.kiri = new Node("Z");
        pohonMorse.kanan.kanan.kiri.kanan = new Node("Q");
    }

    // Fungsi rekursif untuk mencari huruf di tree
    private String cariKode(Node node, String huruf, String kode) {
        if (node == null) {
            return null;
        }

        // Kalau huruf ditemukan
        if (node.data.equalsIgnoreCase(huruf)) {
            return kode;
        }

        // kiri (.)
        String kiri = cariKode(node.kiri, huruf, kode + ".");
        if (kiri != null) {
            return kiri;
        }

        // kanan (-)
        String kanan = cariKode(node.kanan, huruf, kode + "-");
        if (kanan != null) {
            return kanan;
        }

        return null;
    }

    // Encode teks ke kode morse
    public void encode(String teks) {
        teks = teks.toUpperCase();
        StringBuilder hasil = new StringBuilder();

        for (char c : teks.toCharArray()) {
            if (c == ' ') {
                hasil.append("/ ");
            } else {
                String morse = cariKode(pohonMorse, String.valueOf(c), "");
                if (morse != null) {
                    hasil.append(morse).append(" ");
                } else {
                    hasil.append("? ");
                }
            }
        }

        System.out.println("Encoded: " + hasil.toString().trim());
    }
}
