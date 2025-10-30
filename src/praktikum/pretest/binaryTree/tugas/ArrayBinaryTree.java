package praktikum.pretest.binaryTree.tugas;

public class ArrayBinaryTree {
    int arr[];
    int count;

    public ArrayBinaryTree(int size) {
        this.arr = new int[size];
        this.count = 0;
    }

    public void insert(int data) {
        if (count < arr.length) {
            arr[count] = data;
            count++;
        } else {
            System.out.println("Tree penuh");
        }
    }

    public void preorderTraversal() {
        if (count == 0) {
            System.out.println("Tree kosong");
        } else {
            preorder(0);
        }
    }

    private void preorder(int index) {
        if (index < count) {
            System.out.print(arr[index] + " "); // print
            preorder(index * 2 + 1); // kunjungi node kiri
            preorder(index * 2 + 2); // kunjungi node kanan
        }
    }

    public void inorderTraversal() {
        if (count == 0) {
            System.out.println("Tree kosong");
        } else {
            inorder(0);
            System.out.println();
        }
    }

    private void inorder(int index) {
        if (index < count) {
            inorder(index * 2 + 1); // kunjungi node kiri
            System.out.print(arr[index] + " "); // print
            inorder(index * 2 + 2); // kunjungi node kanan
        }
    }

    public void postorderTraversal() {
        if (count == 0) {
            System.out.println("Tree kosong");
        } else {
            postorder(0);
            System.out.println();
        }
    }

    private void postorder(int index) {
        if (index < count) {
            postorder(index * 2 + 1); // kunjungi node kiri
            postorder(index * 2 + 2); // kunjungi node kanan
            System.out.print(arr[index] + " "); // print
        }
    }

    public void levelorderTraversal() {
        if (count == 0) {
            System.out.println("Tree kosong");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.print(arr[i] + " "); // Lansung print dari awal sampai akhir
            }
            System.out.println();
        }
    }
}
