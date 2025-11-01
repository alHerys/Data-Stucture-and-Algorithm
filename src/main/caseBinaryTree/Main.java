package main.caseBinaryTree;

import main.caseBinaryTree.morseDecoder.PenerjemahMorse;

public class Main {
    public static void main(String[] args) {
        PenerjemahMorse penerjemahMorse = new PenerjemahMorse();

        penerjemahMorse.decode("... --- ...");
    }
}
