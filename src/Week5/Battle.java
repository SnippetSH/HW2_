package Week5;

import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName, enemyName;
        int userAttack, enemyAttack, userDefense, enemyDefense, userHealth, enemyHealth;
        System.out.println("User's name:");
        userName = sc.nextLine();
        System.out.println("User's attack:");
        userAttack = sc.nextInt();
        System.out.println("User's defense:");
        userDefense = sc.nextInt();
        System.out.println("User's health:");
        userHealth = sc.nextInt();

        sc.nextLine();
        System.out.println("Enemy's name:");
        enemyName = sc.nextLine();
        System.out.println("Enemy's attack:");
        enemyAttack = sc.nextInt();
        System.out.println("Enemy's defense");
        enemyDefense = sc.nextInt();
        System.out.println("Enemy's health:");
        enemyHealth = sc.nextInt();

        Player user = new Player(userName, userAttack, userDefense, userHealth);
        Player enemy = new Player(enemyName, enemyAttack, enemyDefense, enemyHealth);

        System.out.printf("[%s]\nAttack: %d\nDefense: %d\nHealth: %d\n\n", userName, userAttack, userDefense, userHealth);
        System.out.printf("[%s]\nAttack: %d\nDefense: %d\nHealth: %d\n\n", enemyName, enemyAttack, enemyDefense, enemyHealth);

        while(true) {
            System.out.println("It's your turn.");
            System.out.println("Choose an action:");
            System.out.println("1. Attack\n2. Defend");
            int c = sc.nextInt();
            if(c == 1) {
                user.attack(enemy);
            } else if(c == 2) {
                user.setHealth(10);
                System.out.printf("%s defends and restores 10 health points. (%s's hp: %d)\n", user.getName(), user.getName(), user.getHealth());
                continue;
            }

            if(!enemy.isAlive()) {
                System.out.printf("The player %s wins!\n", user.getName());
                break;
            }

            System.out.println("It's enemy's turn.");
            enemy.attack(user);

            if(!user.isAlive()) {
                System.out.printf("The player %s wins!\n", enemy.getName());
                break;
            }

        }
    }
}
