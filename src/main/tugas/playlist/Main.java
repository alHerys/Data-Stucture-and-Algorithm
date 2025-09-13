package main.tugas.playlist;

public class Main {
    public static void main(String[] args) {
        DoublyPlaylist playlist1 = new DoublyPlaylist();

        // Contoh
        Music indonesiaRaya = new Music("Indonesia Raya", "W.R. Soepratman");
        Music rajaBrawijaya = new Music("Raja Brawijaya", "Univ Brawijaya");
        playlist1.add(indonesiaRaya);
        playlist1.add(rajaBrawijaya);
        System.out.println(playlist1);
    }
}
