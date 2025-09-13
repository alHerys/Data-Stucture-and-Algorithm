package main.tugas.playlist;

public class Music {
    String title;
    String artist;

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", title, artist);
    }
}
