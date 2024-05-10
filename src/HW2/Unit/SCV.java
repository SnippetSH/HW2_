package HW2.Unit;

import HW2.Building.*;
import HW2.GameStatus;
import java.util.Scanner;

public class SCV extends Unit {
    public String[] buildings;
    public SCV() {
       this.healthPoints = 60;
       this.max = 60;
       this.name = "SCV";
       this.buildings = new String[] {"CommandCenter", "Barracks", "Factory", "StarPort"};
       say();
    }
    @Override
    public void say() {
        System.out.println("SCV: SCV good to go, sir!");
    }
    @Override
    public boolean isWorker() {
        return true;
    }
    @Override
    public void attack(Unit target) {
        target.healthPoints -= 5;
        System.out.printf("SCV has dealt 5 damage to InfestedKerrigan. (InfestedKerrigan’s remaining HP: %d)\n", target.healthPoints);
        if(target.HP() <= 0) {
            System.out.printf("%s died!\n", target.name);
            return;
        }
        target.attack(this);
    }

    @Override
    public int HP() {
        return this.healthPoints;
    }

    public void gather(GameStatus gameStatus) {
        gameStatus.money+=100;
    }
    public void build(GameStatus gameStatus, Scanner sc) {
        while(true) {
            System.out.println("Choose which building to construct. (0 to cancel):");
            for (int i = 0; i < 4; i++) {
                System.out.printf("(%d) %s\n", i + 1, this.buildings[i]);
            }
            System.out.print("<< ");
            int choose = sc.nextInt();

            boolean ck = false;
            boolean exit = false;
            boolean isDefault = false;
            switch (choose) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    CommandCenter command = new CommandCenter();
                    gameStatus.buildingList.add(command);
                    ck = true;
                    break;
                case 2:
                    for (Building it : gameStatus.buildingList) {
                        if (it instanceof CommandCenter) {
                            Barracks barracks = new Barracks();
                            gameStatus.buildingList.add(barracks);
                            ck = true;
                            break;
                        }
                    }
                    break;
                case 3:
                    for (Building it : gameStatus.buildingList) {
                        if (it instanceof Barracks) {
                            Factory factory = new Factory();
                            gameStatus.buildingList.add(factory);
                            ck = true;
                            break;
                        }
                    }
                    break;
                case 4:
                    for (Building it : gameStatus.buildingList) {
                        if (it instanceof Factory) {
                            StarPort starport = new StarPort();
                            gameStatus.buildingList.add(starport);
                            ck = true;
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Please enter a valid number.");
                    isDefault = true;
                    break;
            }
            if(ck) {
                System.out.println("SCV: Job finished!");
                break;
            } else if(!isDefault && choose >= 2) {
                System.out.printf("To construct a %s, you must first build a %s.\n", buildings[choose-1], buildings[choose-2]);
            }
            if(exit){
                break;
            }
        }
    }
}
