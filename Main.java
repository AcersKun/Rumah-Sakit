import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AntreanRumahSakit sistem = new AntreanRumahSakit();

        int pilihan;

        do {
            System.out.println("\n===== SISTEM ANTREAN RUMAH SAKIT =====");
            System.out.println("1. Daftar pasien");
            System.out.println("2. Tampilkan antrean");
            System.out.println("3. Panggil pasien");
            System.out.println("4. Selesaikan pemeriksaan");
            System.out.println("5. Skip / batalkan antrean terdepan");
            System.out.println("6. Tampilkan riwayat");
            System.out.println("7. Tampilkan riwayat dari terbaru");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan nomor menu yang valid.");
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Nama pasien: ");
                    String nama = input.nextLine();

                    System.out.println("Jenis pasien:");
                    System.out.println("1. Biasa");
                    System.out.println("2. Lansia");
                    System.out.println("3. Darurat");
                    System.out.print("Pilih jenis: ");

                    String jenis = input.nextLine();
                    String alasan;
                    String keteranganDarurat = "-";

                    switch (jenis) {
                        case "2":
                            alasan = "Lansia";
                            break;
                        case "3":
                            alasan = "Darurat";
                            System.out.print("Masukkan keterangan darurat (mis: Sesak Napas / Kecelakaan): ");
                            keteranganDarurat = input.nextLine();
                            break;
                        default:
                            alasan = "Biasa";
                    }

                    sistem.daftarPasien(nama, alasan, keteranganDarurat);
                    break;

                case 2:
                    sistem.tampilkanAntrean();
                    break;

                case 3:
                    sistem.panggilPasien();
                    break;

                case 4:
                    sistem.selesaikanPemeriksaan();
                    break;

                case 5:
                    sistem.skipAntrean();
                    break;

                case 6:
                    sistem.tampilkanRiwayat();
                    break;

                case 7:
                    sistem.tampilkanRiwayatMundur();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }
}