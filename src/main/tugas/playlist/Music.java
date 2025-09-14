package main.tugas.playlist;

public class Music {
    private String title;
    private String artist;
    private String genre;

    public Music(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }
}
