package praktikum.liveCoding.binarytree;

import java.util.Scanner;

class Node {
    int nilai;
    Node kiri, kanan;

    public Node(int nilai) {
        this.nilai = nilai;
        this.kiri = null;
        this.kanan = null;
    }
}

class BinarySearchTree {
    Node root;

    public void insert(int nilai) {
        root = insertRec(root, nilai);
    }

    private Node insertRec(Node root, int nilai) {
        if (root == null) {
            return new Node(nilai);
        }

        if (nilai < root.nilai) {
            root.kiri = insertRec(root.kiri, nilai);
        } else if (nilai > root.nilai) {
            root.kanan = insertRec(root.kanan, nilai);
        }

        return root;
    }

    public boolean search(int nilai) {
        return searchRec(root, nilai);
    }

    private boolean searchRec(Node root, int nilai) {
        if (root == null)
            return false;
        if (root.nilai == nilai)
            return true;

        return nilai < root.nilai ? searchRec(root.kiri, nilai) : searchRec(root.kanan, nilai);
    }

    public void display() {
        if (root == null) {
            System.out.println("EMPTY");
        } else {
            inorderRec(root);
            System.out.println();
        }
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.kiri);
            System.out.print(root.nilai + " ");
            inorderRec(root.kanan);
        }
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null)
            return 0;
        return 1 + countNodesRec(root.kiri) + countNodesRec(root.kanan);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        while (scan.hasNextLine()) {
            String input = scan.nextLine().trim();

            if (input.equals(""))
                continue;

            if (input.startsWith("INSERT ")) {
                int n = Integer.parseInt(input.substring(7));
                tree.insert(n);
            } else if (input.equals("DISPLAY")) {
                tree.display();
            } else if (input.startsWith("SEARCH ")) {
                int n = Integer.parseInt(input.substring(7));

                if (tree.search(n)) {
                    System.out.println("Found");
                } else {
                    System.out.println("Not Found");
                }

            } else if (input.equals("COUNT")) {
                System.out.println("Total nodes: " + tree.countNodes());
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai");
                break;
            }
        }

        scan.close();
    }
}