package praktikum.liveCoding;
import java.util.*;

class Light{
    String color;
    Light next;
    
    public Light(String color) {
        this.color = color;
        this.next = null;
    }
}

class TrafficLightSystem {
    private Light head;
    private Light current;
    
    public TrafficLightSystem() {
        head = null;
        current = null;
    }
    
    public void addLight(String color) {
        Light newLight = new Light(color);
        newLight.next = newLight;
        
        if (head == null) {
            head = newLight;
        } else {
            Light temp = head;
            
            while (temp.next != head) {
                temp = temp.next;
            }
            
            temp.next = newLight;
            newLight.next = head;
        }
    }
    
    public void currentLight() {
        if (head == null) {
            System.out.println("EMPTY");
            return;
        } 
        
        if (current == null){
            current = head;
        } 
        
        System.out.println(current.color);
    }
    
    public void nextLight(int steps) {
        if (head == null) {
            return;
        }
        
        if (current == null) {
            current = head;
        }
        
        for (int i = 0; i < steps; i++) {
            current = current.next;
        }
        
        System.out.println(current.color);
    }
    
    public void removeLight(String color) {
        if (head == null) {
            System.out.println("NOT_FOUND");
            return;
        }
        
        Light prev, temp;
        prev = null;
        temp = head;
        
        boolean found = false;
        
        do {
            if (temp.color.equals(color)) {
                found = true;
            } else {
                prev = temp;
                temp = temp.next;
            }
        } while (!found && temp != head);
        
        if (found) {
            
            if (current != null && current.color.equals(color)) {
                current = current.next;
            }
            
            Light tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            
            if (head.next == head) {
                head = tail = null;
            } else if (prev == null) {
                head = head.next;
                tail.next = head;
                
                
            } else {
                if (tail == temp) {
                    tail = prev;
                }
                prev.next = temp.next;
            }
            
            System.out.println(temp.color + " REMOVED");
        } else {
            System.out.println("NOT_FOUND");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrafficLightSystem system = new TrafficLightSystem();
        
        while(sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            
            if(input.equals("")) continue;
            
            if(input.startsWith("ADD ")) {
                String color = input.substring(4);
                system.addLight(color);
            } else if (input.equals("CURRENT")) {
                system.currentLight();
            } else if (input.startsWith("NEXT ")) {
                int steps = Integer.parseInt(input.substring(5).trim());
                system.nextLight(steps);
            } else if (input.startsWith("REMOVE ")) {
                String color = input.substring(7);
                system.removeLight(color);
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai");
                break;
            }
        }
        
        sc.close();
    }
}