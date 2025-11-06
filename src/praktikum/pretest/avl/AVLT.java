package praktikum.pretest.avl;

public class AVLT {
    private Node root;

    public AVLT() {
        root = null;
    }

    // cari dt di tree, mengembalikan true jika ditemukan
    // dan false jika tidak
    public boolean cariDt(int dt) {
        Node temp = root;
        while (temp != null) {
            if (dt == temp.data) {
                return true;
            }
            // cariDt subtree pKiri
            else if (dt < temp.data) {
                temp = temp.pKiri;
            }
            // cariDt subtree pKanan
            else {
                temp = temp.pKanan;
            }
        }
        // dt tidak ditemukan
        return false;
    }

    // sisip dt ke dalam tree, returns true if berhasil,
    // false jika gagal
    // tree diseimbangkan menggunakan algoritma AVL
    public boolean sisipDt(int dt) {
        if (root == null) {
            // sisip dt di root
            root = new Node(dt, 1, null, null, null);
            return true;
        }
        // tree tidak kosong
        else {
            // mulai dari root
            Node temp = root;
            Node prev = null;
            // cari lokasi penyisipan dt
            while (temp != null) {
                if (dt == temp.data) {
                    return false;
                }
                // sisip dt di subtree pKiri
                else if (dt < temp.data) {
                    prev = temp;
                    temp = temp.pKiri;
                }
                // sisip dt di subtree pKanan
                else {
                    prev = temp;
                    temp = temp.pKanan;
                }
            }
            // buat node baru
            temp = new Node(dt, 1, null, null, prev);
            if (dt < prev.data) {
                prev.pKiri = temp; // sisip di
            } else {
                prev.pKanan = temp;
            }

            // mulai dari node yang disisipkan dan
            // bergerak menuju root
            return seimbangkan(temp);
        }
    }

    public int tinggi() {
        return root.tinggi;
    }

    private int tinggi(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.tinggi;
        }
    }

    // hitung node-node dari tree
    public int jumlahNode() {
        return jumlahNode(root);
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node r) {
        if (r == null) {
            return;
        }
        inOrder(r.pKiri);
        System.out.printf("-%d", r.data);
        inOrder(r.pKanan);
    }

    // hitung node-node dari tree
    private int jumlahNode(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + jumlahNode(node.pKiri)
                    + jumlahNode(node.pKanan);
        }
    }

// * Mulai disini soal Latihannya
    /**
     * Melakukan rotasi kanan tunggal 
     * 
     * @param A Node yang tidak seimbang (memiliki tinggi pKiri > pKanan).
     * @return Node yang menjadi root baru dari subtree setelah rotasi.
     */
    private Node putarKanan(Node A) {
        // B adalah anak kiri A, yang akan menjadi root baru
        Node B = A.pKiri;
        // T2 adalah subtree kanan B, yang akan menjadi anak kiri A
        Node T2 = B.pKanan;

        // Lakukan rotasi
        B.pKanan = A;
        A.pKiri = T2;

        // Update pointer pInduk
        B.pInduk = A.pInduk;
        A.pInduk = B; 
        if (T2 != null) {
            T2.pInduk = A; 
        }

        // Hitung ulang tinggi SETELAH rotasi
        A.tinggi = Math.max(tinggi(A.pKiri), tinggi(A.pKanan)) + 1;
        B.tinggi = Math.max(tinggi(B.pKiri), tinggi(B.pKanan)) + 1;

        // Kembalikan root baru dari subtree
        return B;
    }

    /**
     * Melakukan rotasi kiri tunggal 
     * 
     * @param A Node yang tidak seimbang (memiliki tinggi pKanan > pKiri).
     * @return Node yang menjadi root baru dari subtree setelah rotasi.
     */
    private Node putarKiri(Node A) {
        // B adalah anak kanan A, yang akan menjadi root baru
        Node B = A.pKanan;
        // T2 adalah subtree kiri B, yang akan menjadi anak kanan A
        Node T2 = B.pKiri;

        // Lakukan rotasi
        B.pKiri = A;
        A.pKanan = T2;

        // Update pointer pInduk
        B.pInduk = A.pInduk; 
        A.pInduk = B; 
        if (T2 != null) {
            T2.pInduk = A;
        }

        // Hitung ulang tinggi SETELAH rotasi
        A.tinggi = Math.max(tinggi(A.pKiri), tinggi(A.pKanan)) + 1;
        B.tinggi = Math.max(tinggi(B.pKiri), tinggi(B.pKanan)) + 1;

        return B;
    }

    /**
     * Melakukan rotasi ganda Kiri-Kanan 
     * 
     * @param A Node yang tidak seimbang.
     * @return Node yang menjadi root baru dari subtree setelah rotasi.
     */
    private Node putarKiriKanan(Node A) {
        // Lakukan putarKiri pada anak kiri
        A.pKiri = putarKiri(A.pKiri);
        // Lakukan putarKanan pada A
        return putarKanan(A);
    }

    /**
     * Melakukan rotasi ganda Kanan-Kiri 
     * 
     * @param A Node yang tidak seimbang.
     * @return Node yang menjadi root baru dari subtree setelah rotasi.
     */
    private Node putarKananKiri(Node A) {
        // Lakukan putarKanan pada anak kanan
        A.pKanan = putarKanan(A.pKanan);
        // putarKiri pada A
        return putarKiri(A);
    }

// * Soal Tugas Mulai dari sini kak

    /**
     * Menghapus data dari tree.
     * Tree diseimbangkan kembali setelah penghapusan.
     * @param data Data yang akan dihapus.
     * @return true jika berhasil, false jika tidak.
     */
    public boolean hapusDt(int data) {
        // Cari node yang akan dihapus
        Node nodeHapus = root;
        while (nodeHapus != null) {
            if (data == nodeHapus.data) {
                break; 
            } else if (data < nodeHapus.data) {
                nodeHapus = nodeHapus.pKiri;
            } else {
                nodeHapus = nodeHapus.pKanan;
            }
        }

        // Jika node tidak ditemukan, keluar
        if (nodeHapus == null) {
            return false;
        }

        // Tentukan node untuk memulai penyeimbangan
        Node nodeSeimbangMulai = null;
        Node parentHapus = nodeHapus.pInduk;

        //? Node adalah daun (tidak punya anak)
        if (nodeHapus.pKiri == null && nodeHapus.pKanan == null) {
            nodeSeimbangMulai = parentHapus; 
            sambungkanKeParent(nodeHapus, parentHapus, null); // Hapus node
        }
        
        //? Node punya satu anak
        else if (nodeHapus.pKiri == null || nodeHapus.pKanan == null) {
            nodeSeimbangMulai = parentHapus; 
            Node anak = (nodeHapus.pKiri != null) ? nodeHapus.pKiri : nodeHapus.pKanan;
            sambungkanKeParent(nodeHapus, parentHapus, anak); 
        }

        //? Node punya dua anak
        else {
            // Cari node terkecil di subtree kanan
            Node kananTerkecil = cariSuksesor(nodeHapus);

            nodeHapus.data = kananTerkecil.data;

            Node parentKananTerkecil = kananTerkecil.pInduk;
            Node anakKananTerkecil = kananTerkecil.pKanan; 

            nodeSeimbangMulai = parentKananTerkecil;

            if (parentKananTerkecil == nodeHapus) {
                nodeSeimbangMulai = kananTerkecil;
            }

            sambungkanKeParent(kananTerkecil, parentKananTerkecil, anakKananTerkecil);
        }

        // Seimbangkan tree
        if (nodeSeimbangMulai != null || root != null) {
            if (nodeSeimbangMulai == null) {
                nodeSeimbangMulai = root;
            }
            seimbangkan(nodeSeimbangMulai);
        }
        
        return true;
    }
    
    private boolean seimbangkan(Node nodeMulai) {
        Node temp = nodeMulai;

        while (temp != null) {
            // subtree pKiri dan pKanan memenuhi kondisi AVL
            if (Math.abs(tinggi(temp.pKiri) - tinggi(temp.pKanan)) <= 1) {
                temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
            }

            // kasus 1 algoritma AVL
            else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2
                    && tinggi(temp.pKiri.pKiri) >= tinggi(temp.pKiri.pKanan)) {
                Node parent = temp.pInduk;
                Node subRootBaru = putarKanan(temp);

                sambungkanKeParent(temp, parent, subRootBaru);

                temp = subRootBaru;
            }
            // case 2 algoritma AVL
            else if (tinggi(temp.pKanan) -
                    tinggi(temp.pKiri) >= 2 &&
                    tinggi(temp.pKanan.pKanan) >= tinggi(temp.pKanan.pKiri)) {
                Node parent = temp.pInduk;
                Node subRootBaru = putarKiri(temp);

                // Menyambungkan kembali root baru ke parent
                sambungkanKeParent(temp, parent, subRootBaru);

                // Lanjutkan loop dari root subtree yang baru
                temp = subRootBaru;
            }
            // kasus 3 dari algoritma AVL
            else if (tinggi(temp.pKiri) -
                    tinggi(temp.pKanan) >= 2 &&
                    tinggi(temp.pKiri.pKanan) >= tinggi(temp.pKiri.pKiri)) {
                Node parent = temp.pInduk;
                Node subRootBaru = putarKiriKanan(temp);

                // Sambungkan kembali root baru ke parent
                sambungkanKeParent(temp, parent, subRootBaru);

                temp = subRootBaru;
            }

            // kasus 4 dari algoritma AVL
            else if (tinggi(temp.pKanan) -
                    tinggi(temp.pKiri) >= 2 &&
                    tinggi(temp.pKanan.pKiri) >= tinggi(temp.pKanan.pKanan)) {
                Node parent = temp.pInduk;
                Node subRootBaru = putarKananKiri(temp);

                // Sambungkan root baru ke parent
                sambungkanKeParent(temp, parent, subRootBaru);

                temp = subRootBaru;
            }
            temp = temp.pInduk;
        }
        // penyisipan berhasil
        return true;
    }

    private void sambungkanKeParent(Node nodeMulai, Node parent, Node subRootBaru) {
        if (parent == null) {
            root = subRootBaru;
        } else if (parent.pKiri == nodeMulai) {
            parent.pKiri = subRootBaru;
        } else {
            parent.pKanan = subRootBaru;
        }
    }

    /**
     * Mencari node terkecil di subtree kanan.
     * @param node Node yang ingin dicari suksesornya.
     * @return Node suksesor.
     */
    private Node cariSuksesor(Node node) {
        Node temp = node.pKanan;
        while (temp.pKiri != null) {
            temp = temp.pKiri;
        }
        return temp;
    }


}