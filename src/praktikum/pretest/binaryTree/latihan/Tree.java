package praktikum.pretest.binaryTree.latihan;

import java.util.Random;

class Node {
    int data;
    Node nodeKiri;
    Node nodeKanan;

    public Node(int dt) {
        data = dt;
        nodeKiri = nodeKanan = null;
    }

    public void sisipDt(int dtSisip) {
        if (dtSisip < data) {
            if (nodeKiri == null)
                nodeKiri = new Node(dtSisip);
            else
                nodeKiri.sisipDt(dtSisip);
        } else if (dtSisip > data) {
            if (nodeKanan == null)
                nodeKanan = new Node(dtSisip);
            else
                nodeKanan.sisipDt(dtSisip);
        }
    }
}

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void sisipDtNode(int dtSisip) {
        if (root == null)
            root = new Node(dtSisip);
        else
            root.sisipDt(dtSisip);
    }

    public void preorderTraversal() {
        preorder(root);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    /**
     * Method untuk menghitung banyaknya node
     */
    public void jumlahNode() {
        System.out.println("Banyaknya Node: " + getSize(root));
    }

    /**
     * Method untuk menghitung banyaknya daun
     */
    public void jumlahDaun() {
        System.out.println("Jumlah daun: " + getCountLeaf(root));
    }

    /**
     * Method untuk menghitung tinggi pohon
     */
    public void tinggi() {
        System.out.println("Tinggi tree: " + getHeight(root));
    }

    /**
     * Method yang menerima Tree lalu menghitung panjangnya
     */
    public void panjang(Tree tree) {
        int panjang = getHeight(tree.root);
        System.out.println("Panjang tree tersebut adalah: " + panjang);
    }
 
    /**
     * Method rekursif untuk nomor 1
     */
    private int getSize(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.nodeKiri) + getSize(node.nodeKanan);
        }
    }

    /**
     * Method rekursif untuk nomor 2
     */
    private int getCountLeaf(Node node) {
        if (node == null) {
            return 0;
        } else if (node.nodeKiri == null && node.nodeKanan == null) {
            return 1;
        } else {
            return getCountLeaf(node.nodeKiri) + getCountLeaf(node.nodeKanan);
        }
    }

    /**
     * Method rekursif untuk nomor 3 dan 4
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.nodeKiri);
            int rightHeight = getHeight(node.nodeKanan);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        preorder(node.nodeKiri);
        preorder(node.nodeKanan);
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.nodeKiri);
        System.out.printf("%d ", node.data);
        inorder(node.nodeKanan);
    }

    private void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.nodeKiri);
        postorder(node.nodeKanan);
        System.out.printf("%d ", node.data);
    }

    public static void main(String args[]) {
        Tree tree = new Tree();
        int nilai;
        Random randomNumber = new Random();
        System.out.println("\nsisip nilai data berikut : ");
        // sisipDt 10 bilangan acak dari 0-99 ke dalam tree
        for (int i = 1; i <= 10; i++) {
            nilai = randomNumber.nextInt(100);
            System.out.print(nilai + " ");
            tree.sisipDtNode(nilai);
        }
        System.out.println("\n\nPreorder traversal");
        tree.preorderTraversal();
        System.out.println("\n\nInorder traversal");
        tree.inorderTraversal();
        System.out.println("\n\nPostorder traversal");
        tree.postorderTraversal();
        System.out.println();

        System.out.println("\nJawaban Latihan No. 1 - 3");
        tree.jumlahNode(); // Method nomor 1
        tree.jumlahDaun(); // Method nomor 2
        tree.tinggi(); // Method nomor 3

        System.out.println("\nJawaban Latihan No. 4");
        Tree tree2 = new Tree();
        int nilai2;
        Random randomNumber2 = new Random();
        System.out.println("sisip nilai data berikut untuk tree2: ");
        // sisipDt 10 bilangan acak dari 0-99 ke dalam tree
        for (int i = 1; i <= 10; i++) {
            nilai2 = randomNumber2.nextInt(100);
            System.out.print(nilai2 + " ");
            tree2.sisipDtNode(nilai2);
        }
        System.out.println();
        tree.panjang(tree2); // Method nomor 4
        System.out.println();
    }
}