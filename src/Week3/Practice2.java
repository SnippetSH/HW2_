package Week3;

import java.util.Scanner;

public class Practice2 {
    String name;
    int quantity;
    double price;
    double total;
    Practice2(String name, int quantity, double price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = price*(double)quantity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practice2[] list = new Practice2[3];
        double subtotal = 0, total, tax;

        for(int i = 0; i < 3; i++) {
            System.out.printf("Enter name of item %d:\n", i+1);
            String name = sc.nextLine();
            System.out.printf("Enter quantity of item %d:\n", i+1);
            int quantity = sc.nextInt();
            System.out.printf("Enter price of item %d:\n", i+1);
            double price = sc.nextDouble();
            sc.nextLine();

            list[i] = new Practice2(name, quantity, price);
            subtotal+=list[i].total;
        }

        tax = subtotal*0.0625;
        total = subtotal + tax;

        System.out.println("Your bill:\n");
        String a = "ITEM", b = "QUANTITY", c = "PRICE", d = "TOTAL";
        System.out.printf("%-30s%-10s%-10s%-10s\n", a, b, c, d);

        for(int i = 0; i < 3; i++) {
            System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", list[i].name, list[i].quantity, list[i].price, list[i].total);
        }
        System.out.println();
        System.out.printf("%-50s%-10.2f\n", "SUBTOTAL", subtotal);
        System.out.printf("%-50s%-10.2f\n", "6.25% SALES TAX", tax);
        System.out.printf("%-50s%-10.2f\n", "TOTAL", total);
    }
}
