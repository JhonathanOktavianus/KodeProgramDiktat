/**
 * @author Jhonathan Oktavianus 1972046
 */
import java.util.Arrays;
import java.util.Scanner;

public class CaseStudyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] angka = new int[5];
        System.out.println("## Proses Input angka ##");
        for (int i=0; i<5; i++){
            System.out.print("Input array ke-"+(i+1)+": ");
            angka[i] = sc.nextInt();
        }
        System.out.println("## Proses Input angka ##");
        for (int i=0; i<5; i++){
            System.out.println(angka[i]);
        }
        System.out.println("## Array setelah diurutkan ##");
        Arrays.sort(angka);
        for (int i=0; i<5; i++){
            System.out.println(angka[i]);
        }
    }
}