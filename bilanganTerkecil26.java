import java.util.Scanner;

public class bilanganTerkecil26 {
    public static void main(String[]args) {
        Scanner sc= new Scanner(System.in);

        int a, b, c, terkecil;

        System.out.print("Masukkan angka pertama: ");
        a= sc.nextInt();
        System.out.print("Masukkan angka kedua  : ");
        b= sc.nextInt();
        System.out.print("Masukkan angka ketiga : ");
        c= sc.nextInt();

        if (a <= b && a <= c) {
            terkecil = a;
        } else if (b <= a && b <= c) {
            terkecil = b;
        } else {
            terkecil = c;
        }

        if ((a == terkecil && b == terkecil) ||
                   (a == terkecil && c == terkecil) ||
                   (b == terkecil && c == terkecil)) {
            System.out.print("Ada beberapa angka terkecil, yaitu: ");
            if (a == terkecil) System.out.print(a + " ");
            if (b == terkecil) System.out.print(b + " ");
            if (c == terkecil) System.out.print(c + " ");
            System.out.println();
        } else {
            System.out.println("Angka terkecil adalah: " + terkecil);
        }

    }
}
        

    
