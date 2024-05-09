package Week7;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        ArrayStack newStack = new ArrayStack();
        String[] menu = {"Push", "Pop", "Peek", "Display Stack", "Exit"};
        Scanner sc = new Scanner(System.in);
        while(true) {
            boolean exit = false;
            System.out.println("Choose operation:");
            for(int i = 1; i <= 5; i++) {
                System.out.printf("%d. %s\n", i, menu[i-1]);
            }
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int n = sc.nextInt();
                    newStack.push(n);
                    break;
                case 2:
                    System.out.printf("Popped element: %d\n\n", newStack.pop());
                    break;
                case 3:
                    System.out.printf("Peaked element: %d\n\n", newStack.peek());
                    break;
                case 4:
                    System.out.print("Stack: ");
                    for(int i = 0; i < newStack.cur_len; i++) {
                        System.out.printf("%d ", newStack.stack[i]);
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    break;
            }
            if(exit) break;
        }
    }
}
