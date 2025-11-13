package praktikum.liveCoding.avl;

import java.util.Scanner;

class Node {
    int tinggi;
    int height;
    Node kiri, kanan;

    public Node(int tinggi) {
        this.tinggi = tinggi;
        this.height = 1;
    }
}

class AVLTree {
    private Node root;
    
    public void insert(int tinggi) {
        root = insertRec(root, tinggi);
    }
    
    private Node insertRec(Node node, int tinggi) {
        if (node == null) {
            node = new Node(tinggi);
        } else if (tinggi < node.tinggi) {
            node.kiri = insertRec(node.kiri, tinggi);
        } else if (tinggi > node.tinggi) {
            node.kanan = insertRec(node.kanan, tinggi);
        } else {
            return node;
        }
        
        node.height = Math.max(tinggi(node.kiri), tinggi(node.kanan)) + 1; 
        
        int balance = faktorKeseimbangan(node);
        
        if (balance > 1 && tinggi < node.kiri.tinggi) {
            return putarKanan(node);
        } else if (balance < -1 && tinggi > node.kanan.tinggi) {
            return putarKiri(node);
        } else if (balance > 1 && tinggi > node.kiri.tinggi) {
            node.kiri = putarKiri(node.kiri);
            return putarKanan(node);
        } else if (balance < -1 && tinggi < node.kanan.tinggi) {
            node.kanan = putarKanan(node.kanan);
            return putarKiri(node);
        }
        
        return node;
    }
    
    private Node putarKanan(Node node) {
        Node leftChild = node.kiri;
        Node temp = leftChild.kanan;
        
        leftChild.kanan = node;
        node.kiri = temp;
        
        node.height = Math.max(tinggi(node.kiri), tinggi(node.kanan)) + 1; 
        leftChild.height = Math.max(tinggi(leftChild.kiri), tinggi(leftChild.kanan)) + 1; 
        
        return leftChild;
    }
    
    private Node putarKiri(Node node) {
        Node rightChild = node.kanan;
        Node temp = rightChild.kiri;
        
        rightChild.kiri = node;
        node.kanan = temp;
        
        node.height = Math.max(tinggi(node.kiri), tinggi(node.kanan)) + 1; 
        rightChild.height = Math.max(tinggi(rightChild.kiri), tinggi(rightChild.kanan)) + 1; 
        
        return rightChild;
    } 
    
    private int faktorKeseimbangan(Node node) {
        if (node == null) {
            return 0;
        } else {
            return tinggi(node.kiri) - tinggi(node.kanan);
        }
    }
    
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }
    
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node node) {
        if (node == null) return;
        
        inorderRec(node.kiri);
        System.out.print(node.tinggi + " ");
        inorderRec(node.kanan);
    }
    
    private void preorderRec(Node node) {
        if (node == null) return;
        
        System.out.print(node.tinggi + " ");
        preorderRec(node.kiri);
        preorderRec(node.kanan);
    }
    
    private void postorderRec(Node node) {
        if (node == null) return;
        
        postorderRec(node.kiri);
        postorderRec(node.kanan);
        System.out.print(node.tinggi + " ");
    }
    
    private int tinggi(Node node) {
         if (node == null) {
             return 0;
         } else {
             return node.height;
         }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AVLTree tree = new AVLTree();
        
        String input;
        
        while (scan.hasNextLine()) {
            input = scan.nextLine().trim();
            
            if (input.equals("")) continue;
            
            if (input.startsWith("INSERT ")) {
                String str = input.substring(7);
                tree.insert(Integer.parseInt(str));
            } else if (input.equals("PREORDER")) {
                tree.preorder();
            } else if (input.equals("INORDER")) {
                tree.inorder();
            } else if (input.equals("POSTORDER")) {
                tree.postorder();
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai");
                break;
            }
        }
        
        scan.close();
    }
}