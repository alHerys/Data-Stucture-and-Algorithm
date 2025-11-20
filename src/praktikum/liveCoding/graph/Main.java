package praktikum.liveCoding.graph;
import java.util.*;

class Graph {
    int jumlahTempat;
    ArrayList<ArrayList<Integer>> daftarJalan;
    
    public Graph(int n) {
        this.jumlahTempat = n;
        this.daftarJalan = new ArrayList<>();
        
        for (int i = 0; i<n;i++) {
            this.daftarJalan.add(new ArrayList<>());
        }
    }
    
    public void tambahJalan(int asal, int tujuan) {
        daftarJalan.get(asal).add(tujuan);
        daftarJalan.get(tujuan).add(asal);
    }
    
    public void tampilkanPeta() {
        for (int i = 0; i < daftarJalan.size(); i++) {
            System.out.print("[" + i + "]");
            ArrayList<Integer> teman = daftarJalan.get(i);
            for (int t : teman) {
                System.out.print(" -> " + t);
            }
            
            System.out.println();
        }
    }
    
    public int hitungTempat() {
        return this.jumlahTempat;
    }
    
    public int hitungJalan() {
        int totalKoneksi = 0;
        for (ArrayList<Integer> jalan: daftarJalan) {
            totalKoneksi += jalan.size();
        }
        
        return totalKoneksi / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Graph graph = null;
        
        String input;
        
        while(scan.hasNextLine()) {
            input = scan.nextLine().trim();
            
            if (input.equals("")) continue;
            
            if(input.startsWith("CREATE ")) {
                int n = Integer.parseInt(input.substring(7));
                graph = new Graph(n);
            } else if (input.equals("DISPLAY")) {
                graph.tampilkanPeta();
            } else if (input.startsWith("ADD ")) {
                String[] inputAdd = input.substring(4).split(" ");
                int asal = Integer.parseInt(inputAdd[0]);
                int tujuan = Integer.parseInt(inputAdd[1]);
                graph.tambahJalan(asal, tujuan);
            } else if (input.equals("COUNT_NODE")) {
                System.out.println(graph.hitungTempat());
            } else if (input.equals("COUNT_EDGE")) {
                System.out.println(graph.hitungJalan());
            } else if (input.equals("EXIT")) {
                System.out.println("Program Selesai");
                break;
            }
        }
        
        scan.close();
    }
}