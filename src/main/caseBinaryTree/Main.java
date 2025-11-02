package main.caseBinaryTree;

public class Main {
    public static void main(String[] args) {
        MorseDecoder penerjemahMorse = new MorseDecoder();
        MorseEncoder encoder = new MorseEncoder();

        penerjemahMorse.decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -..");
        encoder.encode("HELLO WORLD");
    }
}