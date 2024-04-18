package HW2;

import java.util.Scanner;
import HW2.Unit.*;
import HW2.Building.*;

public class Main {
    private static int InputSafety(Scanner sc, int min, int max) {
        int input = sc.nextInt();
        while(input < min || input > max) {
            System.out.print("Please enter a valid number.\n<< ");
            input = sc.nextInt();
        }

        return input;
    }
    private static void UnitSelection(Scanner sc, GameStatus gs) {
        if(gs.unitList.isEmpty()) {
            System.out.println("You don't have any units.");
            return;
        }

        System.out.printf("Enter unit number to select (1~%d) (0 to cancel):\n<< ", gs.unitList.size());
        int unitIdx = InputSafety(sc, 0, gs.unitList.size());

        if(unitIdx == 0) {
            return;
        }

        Unit unit = gs.unitList.get(unitIdx - 1);
        if(unit.isWorker()) {
            WorkerAction(sc, gs, unit);
        } else {
            unit.attack(gs.enemy);
            if(unit.HP() <= 0) {
                gs.unitList.remove(unit);
            }
        }
    }

    private static void WorkerAction(Scanner sc, GameStatus gs, Unit unit) {
        System.out.println("Choose the action for the Unit to perform (0 to cancel):");
        System.out.println("(1) Gather resources (Earn $100)");
        System.out.println("(2) Construct building");
        System.out.print("(3) Attack enemy\n<< ");
        int act = InputSafety(sc, 0, 3);

        switch (act) {
            case 0:
                return;
            case 1:
                ((SCV) unit).gather(gs);
                break;
            case 2:
                ((SCV) unit).build(gs, sc);
                break;
            case 3:
                unit.attack(gs.enemy);
                if(unit.HP() <= 0) {
                    gs.unitList.remove(unit);
                }
                break;
        }
    }

    public static void BuildingSelection(Scanner sc, GameStatus gs) {
        System.out.printf("Enter building number to select (1~%d) (0 to cancel)\n<< ", gs.buildingList.size());
        int buildingIdx = InputSafety(sc, 0, gs.buildingList.size());

        if(buildingIdx == 0) return;

        Building building = gs.buildingList.get(buildingIdx - 1);
        building.createUnit(gs);
    }

    public static void main(String[] args) {
        GameStatus gameStatus = new GameStatus();
        //gameStatus.gameProcess();

        Scanner sc = new Scanner(System.in);
        while(true) {
            boolean exit = false;
            if(gameStatus.enemy.HP() <= 0) {
                System.out.println("Congratulations! You have defeated the enemy.");
                break;
            }
            if(gameStatus.money <= 0 && gameStatus.unitList.isEmpty()) {
                System.out.println("Unfortunately, you have no further actions to take. You have lost.");
                break;
            }

            System.out.printf("%s\n", gameStatus);
            System.out.println("Enter your action");
            System.out.println("(1) select a unit");
            System.out.println("(2) select a building (produce a unit)");
            System.out.println("(3) exit (surrender)");
            System.out.print("<< ");
            int base = InputSafety(sc, 1, 3);

            switch(base) {
                case 1:
                    UnitSelection(sc, gameStatus);
                    break;
                case 2:
                    BuildingSelection(sc, gameStatus);
                    break;
                case 3:
                    System.out.println("Bye.");
                    exit = true;
                    break;
                default:
                    break;
            }

            if(exit) break;
        }
    }
}
