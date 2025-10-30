package praktikum.pretest.binaryTree.tugas;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n### Uji Coba 1: Tree dengan beberapa elemen ###");
        ArrayBinaryTree tree = new ArrayBinaryTree(10);
        int[] dataToInsert = {50, 30, 70, 20, 40, 60, 80};

        System.out.print("Data yang dimasukkan: ");
        for (int data : dataToInsert) {
            System.out.print(data + " ");
            tree.insert(data);
        }
        System.out.println("\n");

        System.out.print("Pre-order Traversal  : ");
        tree.preorderTraversal();
        System.out.println(); 

        System.out.print("In-order Traversal   : ");
        tree.inorderTraversal();

        System.out.print("Post-order Traversal : ");
        tree.postorderTraversal();

        System.out.print("Level-order Traversal: ");
        tree.levelorderTraversal();

        System.out.println("\n--------------------------------------------------\n");

        System.out.println("### Uji Coba 2: Tree Kosong ###");
        ArrayBinaryTree emptyTree = new ArrayBinaryTree(5);
        System.out.print("Pre-order (kosong)  : ");
        emptyTree.preorderTraversal(); 
        
        System.out.println("\n--------------------------------------------------\n");

        System.out.println("### Uji Coba 3: Menyisipkan data hingga tree penuh ###");
        ArrayBinaryTree fullTree = new ArrayBinaryTree(3);
        System.out.println("Ukuran tree: 3");
        fullTree.insert(10);
        System.out.println("Menyisipkan 10");
        fullTree.insert(20);
        System.out.println("Menyisipkan 20");
        fullTree.insert(30);
        System.out.println("Menyisipkan 30");
        
        System.out.println("Menyisipkan 40");
        fullTree.insert(40); 
        
        System.out.print("\nLevel-order (penuh)  : ");
        fullTree.levelorderTraversal();
    }
}