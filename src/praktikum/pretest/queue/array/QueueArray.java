package praktikum.pretest.queue.array;

public class QueueArray {
    char arr[];
    int count;

    public QueueArray(int size) {
        this.arr = new char[size];
    }

    /**
     * Tambah di depan antrian (enqueue).
     */
    public void enqueue(char item) throws Exception {
        if (isFull()) {
            throw new Exception("## Queue Penuh");
        }

        shiftToRight();
        arr[0] = item;
        count++;
    }

    /**
     * Mengambil elemen terdepan, lalu mengurangi count.
     */
    public char dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("## Queue kosong");
        }

        char front = arr[count - 1];
        count--;
        return front;
    }

    /**
     * Mengambil elemen terdepan, tanpa mengurangi count.
     */
    public char peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("## Queue kosong");
        }

        return arr[count - 1];
    }

    /**
     * Memeriksa apakah antrian dalam keadaan kosong.
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }

        return false;
    }

    /**
     * Memeriksa apakah antrian dalam keadaan penuh.
     */
    public boolean isFull() {
        if (count == arr.length) {
            return true;
        }

        return false;
    }

    /**
     * Mengembalikan jumlah elemen yang saat ini ada di dalam antrian.
     */
    public int currentSize() {
        return count;
    }

    /**
     * Mencetak semua elemen yang ada di dalam antrian dalam format [A, B, C].
     * Jika kosong, cukup print []
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
     * Menggeser semua elemen array satu posisi ke kanan untuk memberi ruang pada elemen baru di indeks 0.
     */
    private void shiftToRight() {
        for (int i = count; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
    }
}