package praktikum.pretest.sll;

// Saya pakai generic supaya dapat menerima tipe data apapun
public class Node<T> {
    T data;
    Node<T> next;

    // Saya menambahkan Constructor agar memudahkan dalam membuat
    // Object baru tanpa perlu set null manual
    // Juga agar menambahkan data lebih mudah
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
