// Class turunan (subclass) dari Pasien untuk menangani pasien prioritas/darurat.
public class PasienPrioritas extends Pasien {
    private String keteranganDarurat; // Contoh atribut tambahan (misal: "Kecelakaan", "Sesak Napas")

    public PasienPrioritas(int nomor, String nama, String keteranganDarurat) {
        super(nomor, nama); // Memanggil constructor dari superclass (Pasien)
        this.keteranganDarurat = keteranganDarurat;
    }

    public String getKeteranganDarurat() {
        return keteranganDarurat;
    }

    public void setKeteranganDarurat(String keteranganDarurat) {
        this.keteranganDarurat = keteranganDarurat;
    }

    // Override tingkat prioritas: Nilai 1 berarti prioritas tertinggi.
    @Override
    public int tingkatPrioritas() {
        return 1; 
    }

    // Override jenis pasien agar tampil sebagai "Prioritas" atau "Darurat".
    @Override
    public String getJenis() {
        return "Prioritas";
    }

    // Opsional: Memodifikasi/menambahkan informasi khusus pada method tampilkanInfo()
    @Override
    public void tampilkanInfo() {
        System.out.println(
            "No: " + nomor
            + " | Nama: " + nama
            + " | Jenis: " + getJenis()
            + " | Keterangan: " + keteranganDarurat
            + " | Status: " + status
        );
    }
}