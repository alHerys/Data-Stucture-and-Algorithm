package main.singlyLinkedList.contohBrone;

public class Data {
    String nama;
    String alamat;
    String noHp;
    Data dataBerikutnya;
    public String noHP;

    public Data() {
    }

    public Data(String nama, String alamat, String noHp, Data angkaBerikutnya) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.dataBerikutnya = angkaBerikutnya;
    }

    public Data(String nama, String alamat, String noHp) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
    }

}
