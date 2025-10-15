package main.tugas.queue;

import java.util.*;

// Definisi class yang akan digunakan untuk clone PriorityQueue.
public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {    

    // Method untuk override clone()
    @Override
    public MyPriorityQueue<E> clone() throws CloneNotSupportedException {
        
        // Membuat objek Queue baru untuk mendukung deep clone.
        MyPriorityQueue<E> newPriorityQueue = new MyPriorityQueue<>();

        // Menambahkan seluruh elemen dari queue saat ini ke queue baru
        newPriorityQueue.addAll(this);

        // Return queue baru yang telah di clone
        return newPriorityQueue;
    };
}
