package praktikum.pretest.sll;

import java.util.LinkedList;

public class MainOpsional {
    public static void main(String[] args) {
        SLL list = new SLL<>();

        list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.addLast("Aku");
        list.addLast(new Mahasiswa("1248218758215", "Alvianto Hery Sarborn", 3.00));

        System.out.println(list);

        // LinkedList<Integer> linkedList = new LinkedList<>();

    }
}
