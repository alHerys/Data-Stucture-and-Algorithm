package praktikum.liveCoding;
import java.util.*;

class Song {
    String title;
    Song next;
    Song prev;
    
    public Song(String title) {
        this.title = title;
        this.next = null;
        this.prev = null;
    }
}

class Playlist {
    private Song head;
    private Song tail;
    
    public Playlist() {
        head = null;
        tail = null;
    }
    
    public void addSong(String title){
        Song newSong = new Song(title);
        
        if (head == null) {
            head = tail = newSong;
        } else {
            newSong.prev = tail;
            tail.next = newSong;
            tail = newSong;
        }
    }
    
    public void playFoward() {
        if (head == null) {
            System.out.println("EMPTY");
            return;
        }
        
        Song curr = head;
        while (curr != null) {
            if (curr.next == null) {
                System.out.println(curr.title);
            } else {
                System.out.print(curr.title + " - ");
            }
            curr = curr.next;
        }
    }
    
    public void playBackward() {
        if (head == null) {
            System.out.println("EMPTY");
            return;
        }
        
        Song curr = tail;
        while (curr != null) {
            if (curr.prev == null) {
                System.out.println(curr.title);
            } else {
                System.out.print(curr.title + " - ");
            }
            curr = curr.prev;
        }
    }
    
    public void deleteSong(String title) {
        if (head == null) {
            System.out.println("NOT_FOUND");
            return;
        }
        
        if (head == tail && head.title.equals(title)) {
            head = tail = null;
            System.out.println(title + " DELETED");
            return;
        }
        
        if (head.title.equals(title)) {
            head = head.next;
            head.prev = null;
            System.out.println(title + " DELETED");
            return;
        }
        
        if (tail.title.equals(title)) {
            tail = tail.prev;
            tail.next = null;
            System.out.println(title + " DELETED");
            return;
        }
        
        Song curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                System.out.println(title + " DELETED");
                return;
            }
            curr = curr.next;
        }
        System.out.println("NOT_FOUND");
    }
    
    public void shuffle() {
        if (head == tail || head.next == null) {
            return;
        }
        
        Song curr = head;
        Song prev = null;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        
        Song temp = head;
        head = tail;
        tail = temp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Playlist playlist = new Playlist();
        
        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            
            if (input.equals("")) continue;
            if (input.startsWith("ADD ")) {
                String title = input.substring(4);
                playlist.addSong(title);
            } else if (input.equals("PLAY_FOWARD")) {
                playlist.playFoward();
            } else if (input.equals("PLAY_BACKWARD")) {
                playlist.playBackward();
            } else if (input.startsWith("DELETE ")) {
                String title = input.substring(7);
                playlist.deleteSong(title);
            } else if (input.equals("SHUFFLE")) {
                playlist.shuffle();
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai");
                break;
            }
        }
        sc.close();
    }
}

















