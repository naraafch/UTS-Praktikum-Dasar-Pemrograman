import java.util.Scanner;

public class denyutJantung26{
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int usia, hr, mhr, intensitasmhr;

        System.out.println("-----Zona Denyut Jantung (Target Heart Rate) + Kategori-----");
        System.out.print("Masukkan usia                                   : ");
        usia= sc.nextInt();
        System.out.print("Jumlah detak jantung saat latihan (denyut/menit): ");
        hr= sc.nextInt();

        mhr= 220-usia;
        intensitasmhr= hr/mhr*100;

        System.out.println("\n---------------Kategori Intensitas---------------");
        if (intensitasmhr<50) {
            System.out.println("<50%: Sangat Ringan - Pemanasan, manfaatkan minimal");
        } else if (intensitasmhr>=50 && intensitasmhr<=59) {
            System.out.println("50%-59%: Ringan - Peningkatan dasar kebugaran");
        } else if (intensitasmhr>=60 && intensitasmhr<=69) {
            System.out.println("60%-69%: Sedang - Zona aerobik nyaman");
        } else if (intensitasmhr>=70 && intensitasmhr<=85) {
            System.out.println("70%-85%: Kuat - Meningkatkan kapasitas kardiorespirasi");
        } else {
            System.out.println(">85%: Sangat berat - Beresiko bagi pemula, batasi durasi");
        }
    }
}