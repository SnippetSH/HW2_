package Week4;

import java.util.Random;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);
        int num = rn.nextInt(200) + 1;
        int ck = 0;

        System.out.println("Try to guess a number from 1 to 200! You have 7 attempts.");
        while(true) {
            System.out.print("Enter your guess: ");
            int user = sc.nextInt();
            if(user > num) {
                System.out.println("Try a lower number.");
            } else if(user < num) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Congratulations!");
                break;
            }

            if(ck >= 6) {
                System.out.println("Chances left: 0");
                System.out.printf("You didn't guess within 7 attempts. The correct answer: %d\n", num);
                break;
            }
            ck++;
            System.out.printf("Chances left: %d\n", 7-ck);
        }
    }
}