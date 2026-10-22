public class AntreanRumahSakit implements AntreanADT{
    private static class NodeAntrean {
        Pasien pasien;
        NodeAntrean next;

        NodeAntrean(Pasien pasien) {
            this.pasien = pasien;
            this.next = null;
        }
    }
    private NodeAntrean head;
     private static class NodeRiwayat {
        Pasien pasien;
        NodeRiwayat prev;
        NodeRiwayat next;

        NodeRiwayat(Pasien pasien) {
            this.pasien = pasien;
            this.prev = null;
            this.next = null;
        }
    }
    private NodeRiwayat headRiwayat;
    private NodeRiwayat tailRiwayat;
    private Pasien sedangDiperiksa;
    private int nomorBerikutnya = 1;

    public void daftarPasien(String nama, String alasan) {
        Pasien pasien;
         if (alasan.equalsIgnoreCase("Darurat")
                || alasan.equalsIgnoreCase("Lansia")) {

            pasien = new PasienPrioritas(
                nomorBerikutnya, nama, alasan
            );

        } else {
            pasien = new Pasien(nomorBerikutnya, nama);
        }

        nomorBerikutnya++;
        tambahPasien(pasien);
    }
    @Override
    public void tambahPasien(Pasien pasien) {
        NodeAntrean baru = new NodeAntrean(pasien);
        if (head == null) {
            head = baru;
        }
        else if (pasien.tingkatPrioritas()
                < head.pasien.tingkatPrioritas()) {

            baru.next = head;
            head = baru;
        }
         else {
            NodeAntrean current = head;

        
            while (current.next != null
                    && current.next.pasien.tingkatPrioritas()
                    <= pasien.tingkatPrioritas()) {

                current = current.next;
            }

            baru.next = current.next;
            current.next = baru;
        }

        System.out.println(
            "Pasien berhasil didaftarkan: " + pasien.getNama()
        );
    }
@Override
    public void tampilkanAntrean() {
        if (head == null) {
            System.out.println("Antrean sedang kosong.");
            return;
        }

        NodeAntrean current = head;

        System.out.println("\n=== DAFTAR ANTREAN ===");

        while (current != null) {
            current.pasien.tampilkanInfo();
            current = current.next;
        }
    }
    private void tambahRiwayat(Pasien pasien) {
        NodeRiwayat baru = new NodeRiwayat(pasien);
        if (headRiwayat == null) {
            headRiwayat = tailRiwayat = baru;
        } else {
            tailRiwayat.next = baru;
            baru.prev = tailRiwayat;

            tailRiwayat = baru;
        }
    }
      @Override
    public void panggilPasien() {
        if (sedangDiperiksa != null) {
            System.out.println(
                "Selesaikan pemeriksaan pasien sebelumnya dahulu."
            );
            return;
        }

        if (head == null) {
            System.out.println("Tidak ada pasien yang menunggu.");
            return;
        }
        sedangDiperiksa = head.pasien;
        head = head.next;
        sedangDiperiksa.setStatus("DIPERIKSA");
        tambahRiwayat(sedangDiperiksa);
         System.out.println(
            "Memanggil pasien: " + sedangDiperiksa.getNama()
        );
        sedangDiperiksa.tampilkanInfo();
    }
     @Override
    public void selesaikanPemeriksaan() {
        if (sedangDiperiksa == null) {
            System.out.println("Tidak ada pasien yang diperiksa.");
            return;
        }

        sedangDiperiksa.setStatus("SELESAI");

        System.out.println(
            "Pemeriksaan selesai: " + sedangDiperiksa.getNama()
        );

        sedangDiperiksa = null;
    }
     @Override
    public void skipAntrean() {
        if (head == null) {
            System.out.println("Tidak ada antrean untuk di-skip.");
            return;
        }
         Pasien dibatalkan = head.pasien;
        head = head.next;

        dibatalkan.setStatus("DIBATALKAN");
        tambahRiwayat(dibatalkan);

        System.out.println(
            "Antrean dibatalkan untuk: " + dibatalkan.getNama()
        );
    }
    @Override
    public void tampilkanRiwayat() {
        if (headRiwayat == null) {
            System.out.println("Riwayat masih kosong.");
            return;
        }

        NodeRiwayat current = headRiwayat;

        System.out.println("\n=== RIWAYAT PASIEN ===");
        while (current != null) {
            current.pasien.tampilkanInfo();
            current = current.next;
        }
    }
     public void tampilkanRiwayatMundur() {
        if (tailRiwayat == null) {
            System.out.println("Riwayat masih kosong.");
            return;
        }

        NodeRiwayat current = tailRiwayat;

        System.out.println("\n=== RIWAYAT TERBARU ===");
         while (current != null) {
            current.pasien.tampilkanInfo();
            current = current.prev;
        }
    }
}