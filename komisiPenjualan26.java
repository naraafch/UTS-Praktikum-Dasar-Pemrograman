import java.util.Scanner;

public class komisiPenjualan26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long omzet;
        int rating;
        String sertifikasi;
        double persenKomisiAwal = 0;
        double persenKomisiAkhir = 0;
        long bonusSertifikasi = 0;
        double totalKomisi;
        boolean inputValid;

        System.out.println("====== Penghitungan Komisi Tenaga Penjualan ======");

        do {
            inputValid = true; 
         
            System.out.print("Masukkan Omzet Bulanan (Rp): ");
            if (sc.hasNextLong()) {
                omzet = sc.nextLong();
                if (omzet < 0) {
                    System.out.println("Omzet tidak boleh negatif. Silakan ulangi.");
                    inputValid = false;
                }
            } else {
                System.out.println("Input omzet tidak valid. Silakan ulangi.");
                omzet = -1; 
                inputValid = false;
                sc.next(); 
            }

            if (inputValid) {
                System.out.print("Masukkan Rating Kinerja (1-100): ");
                if (sc.hasNextInt()) {
                    rating = sc.nextInt();
                    if (rating < 1 || rating > 100) {
                        System.out.println("Rating harus dalam rentang 1 hingga 100. Silakan ulangi.");
                        inputValid = false;
                    }
                } else {
                    System.out.println("Input rating tidak valid. Silakan ulangi.");
                    rating = -1; 
                    inputValid = false;
                    sc.next(); 
                }
            } else {
                rating = -1;
            }

            if (inputValid) {
                System.out.print("Memiliki Sertifikasi Profesional (ya/tidak): ");
                sertifikasi = sc.next().toLowerCase();
                if (!sertifikasi.equals("ya") && !sertifikasi.equals("tidak")) {
                    System.out.println("Input sertifikasi tidak valid. Masukkan 'ya' atau 'tidak'. Silakan ulangi.");
                    inputValid = false;
                }
            } else {
                sertifikasi = "tidak"; 
            }
            sc.nextLine(); 
        } while (!inputValid);

        persenKomisiAwal = 0;
        bonusSertifikasi = 0;
        
        if (rating < 70) {
            persenKomisiAwal = 0;
            System.out.println("\n[Rating di bawah 70. Komisi tidak memenuhi syarat (0%).");
        } else {
            if (omzet < 50000000) { 
                persenKomisiAwal = 0.01; 
            } else if (omzet < 100000000) {
                persenKomisiAwal = 0.02;
            } else { 
                persenKomisiAwal = 0.03; 
            }

            persenKomisiAkhir = persenKomisiAwal; 

            if (rating >= 90) {
                
                persenKomisiAkhir += 0.01; 
                System.out.println("\n[INFO] Bonus Rating Tinggi (+1%): Persentase komisi naik menjadi " + 
                                   String.format("%.0f%%", persenKomisiAkhir * 100));
            }

            if (sertifikasi.equals("ya")) {
                bonusSertifikasi = 500000;
                System.out.println("[INFO] Bonus Sertifikasi diberikan: Rp 500.000");
            }
        }

        double komisiDariOmzet = persenKomisiAkhir * omzet;
        totalKomisi = komisiDariOmzet + bonusSertifikasi;

        System.out.println("---------------RINCIAN KOMISI---------------");
        System.out.println("Omzet Bulanan (Rp)     : " + omzet);
        System.out.println("Rating Kinerja         : " + rating);
        System.out.println("Sertifikasi            : " + (sertifikasi.equals("ya") ? "Ya" : "Tidak"));
        System.out.println("-------------------------------------------------");
        
        System.out.printf("Persentase Awal Komisi : %.0f%%\n", persenKomisiAwal * 100);
        System.out.printf("Persentase Akhir Komisi: %.0f%%\n", persenKomisiAkhir * 100);
        System.out.printf("Komisi dari Omzet (%.0f%%): Rp %,.2f\n", 
                          persenKomisiAkhir * 100, komisiDariOmzet);
        System.out.printf("Bonus Sertifikasi      : Rp %,d\n", bonusSertifikasi);
        System.out.println("-------------------------------------------------");
        System.out.printf("TOTAL KOMISI           : Rp %,.2f\n", totalKomisi);
        System.out.println("=================================================");
    }
}