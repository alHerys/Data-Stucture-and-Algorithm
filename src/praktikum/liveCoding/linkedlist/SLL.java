package praktikum.liveCoding.linkedlist;
import java.util.Scanner;

public class SLL {
    static class Node{
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class LinkedList {
        Node head;
        
        void insert(int data) {
            if (head == null) {
                head = new Node(data);
            } else {
                Node newNode = new Node(data);
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        
        void delete(int data) {
            if (head.data == data) {
                if (head.next == null) {
                    head = null;
                } else {
                    head = head.next;
                }
                return;
            }
            
            Node current = head;
            while (current.next != null || current.next.data != data) {
                current = current.next;
            }
            
            if (current.next == null) {
                return;
            }
            
            current.next = current.next.next;
        }
        
        void tampilkan() {
            if (head == null) {
                System.out.println("EMPTY");
            } else {
                Node current = head;
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
            }
        }
        
        void reverse() {
            
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int pilihan;
        
        while(true) {
            pilihan = sc.nextInt();
            
            if (pilihan == 1) {
                int angka = sc.nextInt();
                list.insert(angka);
            } else if(pilihan == 2) {
                int del = sc.nextInt();
                list.delete(del);
            } else if(pilihan == 3) {
                list.tampilkan();
            } else if (pilihan == 4) {
                list.reverse();
            } else if (pilihan == 5) {
                System.out.println("Program Selesai");
                break;
            }
        }
        
        sc.close();
    }
 }