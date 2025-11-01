package main.caseBinaryTree.morseDecoder;

public class PenerjemahMorse {
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
        pohonMorse.kiri.kiri.kanan.kanan = new Node("");
        pohonMorse.kiri.kanan.kiri.kiri = new Node("L");
        pohonMorse.kiri.kanan.kiri.kanan = new Node("");
        pohonMorse.kiri.kanan.kanan.kiri = new Node("P");
        pohonMorse.kiri.kanan.kanan.kanan = new Node("J");

        pohonMorse.kanan.kiri.kiri.kiri = new Node("B");
        pohonMorse.kanan.kiri.kiri.kanan = new Node("X");
        pohonMorse.kanan.kiri.kanan.kiri = new Node("C");
        pohonMorse.kanan.kiri.kanan.kanan = new Node("Y");
        pohonMorse.kanan.kanan.kiri.kiri = new Node("Z");
        pohonMorse.kanan.kanan.kiri.kanan = new Node("Q");
        pohonMorse.kanan.kanan.kanan.kiri = new Node("");
        pohonMorse.kanan.kanan.kanan.kanan = new Node("");
    }

    public void decode(String morse) {
        String[] kata = morse.split(" ");

        StringBuilder hasil = new StringBuilder();

        for (String huruf : kata) {
            Node current = pohonMorse;

            if (huruf.equals("/")) {

                hasil.append(" ");
                 
            } else {

                String[] karakter = huruf.split("");

                for (String i : karakter) {
                    if (i.equals(".")) {
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
