public class PasienPrioritas extends Pasien {
    private String keteranganDarurat;

    public PasienPrioritas(int nomor, String nama, String keteranganDarurat) {
        super(nomor, nama); 
        this.keteranganDarurat = keteranganDarurat;
    }

    public String getKeteranganDarurat() {
        return keteranganDarurat;
    }

    public void setKeteranganDarurat(String keteranganDarurat) {
        this.keteranganDarurat = keteranganDarurat;
    }
    @Override
    public int tingkatPrioritas() {
        return 1; 
    }
    @Override
    public String getJenis() {
        return "Prioritas";
    }
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