package Week3;

import java.util.Scanner;
import java.lang.Math;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a, b, c;
        System.out.println("Enter the coefficients (a, b, c):");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();

        double x1, x2;
        double tmp = b*b - 4*a*c;
        x1 = (-b + Math.sqrt(tmp)) / ((double)2*a);
        x2 = (-b - Math.sqrt(tmp)) / ((double)2*a);

        System.out.printf("x1: %.3f x2: %.3f", x1, x2);

    }
}
