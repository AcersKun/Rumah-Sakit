public class AntreanRumahSakit implements AntreanADT {
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
}