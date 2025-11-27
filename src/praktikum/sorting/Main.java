package praktikum.sorting;

import java.util.*;

class Sorting {
    private int[] data;
    private int count;

    public Sorting(int size) {
        this.data = new int[size];
    }

    public void insert(int tinggi) {
        data[count] = tinggi;
        count++;
    }

    public void bubbleSort() {
        boolean isSwapping = true;

        while (isSwapping) {
            isSwapping = false;

            for (int i = 0; i < count - 1; i++) {
                if (data[i] > data[i + 1]) {
                    isSwapping = true;
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = data[min];
                data[min] = data[i];
                data[i] = temp;
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < count; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Sorting sort = new Sorting(50);
        Scanner scan = new Scanner(System.in);

        String input;
        while (scan.hasNextLine()) {
            input = scan.nextLine().trim();

            if (input.equals(""))
                continue;

            if (input.startsWith("INSERT ")) {
                int tinggi = Integer.parseInt(input.substring(7));
                sort.insert(tinggi);
            } else if (input.equals("SHOW")) {
                sort.display();
            } else if (input.equals("BUBBLE")) {
                sort.bubbleSort();
            } else if (input.equals("SELECTION")) {
                sort.selectionSort();
            } else if (input.equals("INSERTION")) {
                sort.insertionSort();
            } else if (input.equals("EXIT")) {
                System.out.println("Program selesai");
                break;
            }
        }

        scan.close();
    }
}