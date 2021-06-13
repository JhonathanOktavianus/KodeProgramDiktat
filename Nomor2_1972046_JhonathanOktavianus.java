/**1972046 Jhonathan Oktavianus**/

import java.util.Scanner;

public class Nomor2_1972046_JhonathanOktavianus {
    public static void main(String[] args) {
        double bilangan, hasil1, hasil2, hasil3, hasil4, hasil5;

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan Bilangan : ");
        bilangan = sc.nextDouble();
        hasil1 = Math.pow(bilangan, 2);
        System.out.println("Hasil kuadrat: " + hasil1);
        hasil2 = Math.pow(bilangan, 5);
        System.out.println("Hasil pangkat 5: " + hasil2);
        hasil3 = Math.sqrt(bilangan);
        System.out.println("Hasil akar kuadrat: " + hasil3);
        hasil4 = Math.abs(bilangan);
        System.out.println("Hasil absolut: " + hasil4);
        hasil5 = Math.round(bilangan);
        System.out.println("Hasil pembulatan: " + hasil5);
    }
}