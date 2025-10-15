package praktikum.persiapanUtp.single;

import java.util.*;
public class App {
    
    static class Node {
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
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }

                curr.next = newNode;
            }
        }

        void delete(int data) {
            if (head == null) {
                return;
            } 
            
            if (head.data == data) {
                head = head.next;
            } else {
                Node curr = head;
                while (curr.next != null && curr.next.data != data) {
                    curr = curr.next;
                }

                if (curr.next != null) {
                    curr.next = curr.next.next;
                }
            }
        }

        void tampilkan(){
            if (head == null) {
                System.out.println("EMPTY");
                return;
            }

            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        void reverse() {
            Node prev = null;
            Node curr = head;
            Node next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            head = prev;
            tampilkan();
        }
    }

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int pilihan;

        while (true) {
            pilihan=sc.nextInt();

            if(pilihan==1){
                int angka = sc.nextInt();
                list.insert(angka);
            } else if (pilihan == 2) {
                int del = sc.nextInt();
                list.delete(del);
            } else if(pilihan ==3) {
                list.tampilkan();
            } else if (pilihan==4) {
                list.reverse();
            } else if (pilihan==5) {
                System.out.println("Program selesai");
                break;
            }
        }

        sc.close();
    }
}
