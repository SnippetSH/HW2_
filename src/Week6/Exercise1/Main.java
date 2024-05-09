package Week6.Exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter information for Person 1:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Birth year: ");
        int year = sc.nextInt();
        System.out.print("Birth month: ");
        int month = sc.nextInt();
        System.out.print("Birth day: ");
        int day = sc.nextInt();
        sc.nextLine();
        Person p1 = new Person(name, day, month, year);

        System.out.println("Enter information for Person 2:");
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Birth year: ");
        int year1 = sc.nextInt();
        System.out.print("Birth month: ");
        int month1 = sc.nextInt();
        System.out.print("Birth day: ");
        int day1 = sc.nextInt();

        Person p2 = new Person(name1, day1, month1, year1);

        AgeCalculator cal = new AgeCalculator();

        if(cal.isOlder(p1, p2)  == 1) {
            System.out.printf("%s is older than %s\n", p2.name, p1.name);
        } else if(cal.isOlder(p1, p2) == 0) {
            System.out.printf("%s and %s are of the same age\n", p1.name, p2.name);
        } else if(cal.isOlder(p1, p2) == -1){
            System.out.printf("%s is older than %s\n", p1.name, p2.name);
        }
    }
}
