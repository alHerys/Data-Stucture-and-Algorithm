package praktikum.pretest.sll;

public class Mahasiswa {
    private String nim;
    private String nama;
    private double ipk;

    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getIpk() {
        return ipk;
    }

    // Ini method tambahan saja kak untuk print output mahasiswanya
    // Ketika Object Mahasiswa ini coba dipanggil baik itu dengan print atau method lain, maka
    // ia akan return String tersebut
    @Override
    public String toString() {
        return "Mahasiswa [nim=" + nim + ", nama=" + nama + ", ipk=" + ipk + "]";
    }

}
