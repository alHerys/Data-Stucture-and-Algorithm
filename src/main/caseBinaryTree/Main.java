package main.caseBinaryTree;

import main.caseBinaryTree.morseDecoder.PenerjemahMorse;
import main.caseBinaryTree.morseEncoder.morseEncoder;

public class Main {
    public static void main(String[] args) {
        PenerjemahMorse penerjemahMorse = new PenerjemahMorse();
        morseEncoder encoder = new morseEncoder();

        penerjemahMorse.decode("... --- ...");
        encoder.encode("SOS");
    }
}
