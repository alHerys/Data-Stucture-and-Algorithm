package main.singlyLinkedList.real;
import java.util.*;

class Table {
    String id;
    Table next, prev;
    Table (String id) {
        this.id = id;
        this.next = this.prev = null;
    }
}

class Order {
    String tableId;
    String item;
    Order (String tableId, String item) {
        this.tableId = tableId;
        this.item = item;
    }
}

class Cafe {
    private Table head;
    private Table current;
    private Order[] orders = new Order[100];
    private int orderCount = 0;
    
    void addTable(String id) {
        Table newTable = new Table(id);
        newTable.next = newTable;
        newTable.prev = newTable;
        
        if (head == null) {
            head = newTable;
            current = head;
            return;
        }
        
        Table curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        
        curr.next = newTable;
        newTable.prev = curr;
        newTable.next = head;
        head.prev = newTable;
    }
    
    void printTables() {
        if (head == null) {
            System.out.println("EMPTY");
            return;
        }
        
        Table curr = head;
        
        do {
            System.out.print(curr.id);
            if (curr != head) {
                System.out.print(" <-> ");
            }
            curr = curr.next;
        } while (curr != head.next);
        
        
        System.out.println();
    }
    
    String currentTable() {
        if (head == null) {
            return "EMPTY";
        }
        
        if (current == null) {
            current = head;
        }
        
        return current.id;
    }
    
    String moveNext(int steps) {
        if (head == null) {
            return "EMPTY";
        }
        
        if (current == null) {
            current = head;
        }
        
        for (int i = 0; i < steps; i++) {
            current = current.next;
        }
        
        return current.id;
    }
    
    String movePrev(int steps) {
        if (head == null) {
            return "EMPTY";
        }
        
        if (current == null) {
            current = head;
        }
        
        for (int i = 0; i < steps; i++) {
            current = current.prev;
        }
        
        return current.id;
    }
    
    boolean isEmpty() {
        if (head == null) {
            return true;
        }
        
        return false;
        
    }
    
    void addOrder(String item) {
        if (isEmpty()) {
            return;
        }
        
        Order newOrder = new Order(currentTable(), item);
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                orders[i] = newOrder;
                orderCount++;
                return;
            }
        }
    }
    
    void printOrders() {
        if (orderCount == 0) {
            System.out.println("NO ORDERS");
        } else {
            for (int i = 0; i < orderCount; i++) {
                System.out.println(orders[i].tableId + ": " + orders[i].item);
            }
        }
        
    }
}

public class Main {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            Cafe cafe = new Cafe();
            
            while (scan.hasNextLine()) {
                String input = scan.nextLine().trim();
                
                if (input.equals("")) continue;
                
                if (input.startsWith("ADD_TABLE ")) {
                    cafe.addTable(input.substring(10));
                } else if (input.equals("PRINT_TABLES")) {
                    cafe.printTables();
                } else if (input.equals("CURRENT_TABLE")) {
                    System.out.println(cafe.currentTable());
                } else if (input.startsWith("NEXT ")) {
                    System.out.println(cafe.moveNext(Integer.parseInt(input.substring(5))));
                } else if (input.startsWith("PREV ")) {
                    System.out.println(cafe.movePrev(Integer.parseInt(input.substring(5))));
                } else if (input.startsWith("ADD_ORDER ")) {
                    cafe.addOrder(input.substring(10));
                } else if (input.equals("PRINT_ORDERS")) {
                    cafe.printOrders();
                } else if (input.equals("EXIT")) {
                    System.out.println("Program selesai");
                    break;
                }
            }
        }
    }