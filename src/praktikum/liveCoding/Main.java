package praktikum.liveCoding;
import java.util.*;

class Node {
    String url;
    Node next;
    
    public Node(String url) {
        this.url = url;
        this.next = null;
    }
}

class BrowserHistory {
    private Node current;
    
    public void visit(String url) {
        Node newNode = new Node(url);
        
        if (current == null) {
            current = newNode;
        } else {
            newNode.next = current;
            current = newNode;
        }
    }
    
    public void back() {
        if (current == null || current.next == null) {
            System.out.println("EMPTY");
        } else {
            current = current.next;
            System.out.println("Undo to: " + current.url);
        }
    }
    
    public void currentPage() {
        if (current == null) {
            System.out.println("EMPTY");
        } else {
            System.out.println(current.url);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BrowserHistory browserHistory = new BrowserHistory();
        
        String input;
        while(scan.hasNextLine()) {
            input = scan.nextLine().trim();
            
            if(input.equals("")) continue;
            
            if(input.startsWith("VISIT ")) {
                String url = input.substring(6);
                browserHistory.visit(url);
            } else if (input.equals("CURRENT")) {
                browserHistory.currentPage();
            } else if (input.equals("BACK")) {
                browserHistory.back();
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai");
                break;
            }
        }
        
        scan.close();
    }
}