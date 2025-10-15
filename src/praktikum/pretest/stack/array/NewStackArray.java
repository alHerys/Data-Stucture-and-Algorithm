package praktikum.pretest.stack.array;

public class NewStackArray {
    private int count; // Jumlah elemen saat ini di array
    private char arr[]; // Array untuk menyimpan data

    /**
     * Konstruktor untuk membuat stack baru.
     * @param size Kapasitas maksimum stack.
     */
    public NewStackArray(int size) {
        this.arr = new char[size];
    }

    /**
     * Menambah elemen ke puncak stack.
     * @param item Elemen yang akan ditambahkan.
     * @throws RuntimeException Jika stack sudah penuh.
     */
    public void push(char item) {
        if (count == arr.length) {
            throw new RuntimeException("Stack penuh");
        }
        shiftToRight();
        arr[0] = item;
        count++;
    }

    /**
     * Menghapus elemen teratas dari stack.
     * @return Elemen teratas yang dihapus.
     * @throws RuntimeException Jika stack kosong.
     */
    public char pop() {
        if (count == 0) {
            throw new RuntimeException("Stack kosong");
        }
        char top = arr[0];
        shiftToLeft();
        count--;
        return top;
    }

    /**
     * Mencetak semua isi stack dari index 0.
     */
    public void printAll() {
        if (count == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[" + arr[0]);
        for (int i = 1; i < count; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("]");
    }

    /**
     * Geser elemen array ke kanan untuk operasi push.
     */
    private void shiftToRight() {
        for (int i = count; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
    }

    /**
     * Geser elemen array ke kiri untuk operasi pop.
     */
    private void shiftToLeft() {
        for (int i = 0; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }
}
