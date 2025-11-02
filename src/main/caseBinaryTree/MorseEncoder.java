package main.caseBinaryTree;

public class MorseEncoder {
    private static Node pohonMorse = PohonMorse.getRoot();

    // Fungsi rekursif untuk mencari huruf di tree
    private String cariKode(Node node, char huruf, String kode) {
        if (node == null) {
            return null;
        }

        // Kalau huruf ditemukan
        if (node.data == huruf) {
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
                String morse = cariKode(pohonMorse, c, "");
                if (morse != null) {
                    hasil.append(morse).append(" ");
                } else {
                    hasil.append("? ");
                }
            }
        }

        System.out.println(hasil.toString().trim());
    }
}