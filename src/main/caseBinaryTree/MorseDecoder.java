package main.caseBinaryTree;

public class MorseDecoder {
    private static Node root = PohonMorse.getRoot();

    public void decode(String morse) {
        String[] kata = morse.split(" ");

        StringBuilder hasil = new StringBuilder();

        for (String huruf : kata) {
            Node current = root;

            if (huruf.equals("/")) {

                hasil.append(" ");
                 
            } else {

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
