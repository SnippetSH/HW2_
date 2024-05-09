package Week4;

import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {
    static boolean[] isPrime;
    static void Prime(int n) {
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i<=n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sn, en;
        while(true) {
            System.out.print("starting number (1 to 1000): ");
            sn = sc.nextInt();
            if(sn > 0 && sn < 1001) {
                break;
            } else {
                System.out.println("Starting number must be between 1 and 1000.");
            }
        }
        while(true) {
            System.out.print("ending number (1 to 1000): ");
            en = sc.nextInt();
            if(en > 0 && en < 1001 && en > sn) {
                break;
            } else {
                System.out.println("Ending number must be between 1 and 1000.");
            }
        }
        Prime(en);
        System.out.printf("Prime numbers between %d and %d:\n", sn, en);
        for(int i = sn; i <= en; i++) {
            if(isPrime[i]) {
                System.out.printf("%d ", i);
            }
        }
    }
}
