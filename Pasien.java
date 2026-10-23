public class Pasien {
    protected int nomor;
    protected String nama;
    protected String status;

    public Pasien(int nomor, String nama) {
        this.nomor = nomor;
        this.nama = nama;
        this.status = "MENUNGGU";
    }

    public int getNomor() {
        return nomor;
    }

    public String getNama() {
        return nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int tingkatPrioritas() {
        return 3;
    }

    public String getJenis() {
        return "Biasa";
    }

    public void tampilkanInfo() {
        System.out.println(
            "No: " + nomor
            + " | Nama: " + nama
            + " | Jenis: " + getJenis()
            + " | Status: " + status
        );
    }
}