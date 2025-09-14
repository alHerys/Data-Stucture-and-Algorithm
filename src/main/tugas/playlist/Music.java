package main.tugas.playlist;

public class Music {
    private String title;
    private String artist;

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", title, artist);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
