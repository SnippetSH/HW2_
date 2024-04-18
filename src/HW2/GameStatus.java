package HW2;

import HW2.Building.*;
import HW2.Unit.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameStatus {
    public int money;
    public ArrayList<Unit> unitList;
    public ArrayList<Building> buildingList;
    public Unit enemy;
    GameStatus() {
        this.money = 50;
        unitList = new ArrayList<Unit>();
        buildingList = new ArrayList<Building>();
        enemy = new InfestedKerrigan();
        CommandCenter command = new CommandCenter();
        buildingList.add(command);
    }

    private String listEntity(ArrayList<?> list) {
        StringBuilder builder = new StringBuilder();
        int i = 1;
        for(Object it : list) {
            if(it instanceof Unit) {
                builder.append("[").append(i++).append("]").append(((Unit) it).name).append("(HP: ").append(((Unit) it).HP()).append("/").append(((Unit) it).max).append(")\n");
            } else if(it instanceof  Building) {
                builder.append("[").append(i++).append("]").append(((Building) it).name).append("\n");
            }
        }
        return builder.toString();
    }

    public String toString() {
        return "Money: $" + money +
                "\nThe enemy's HP: " + enemy.HP() +
                "\nUnits:\n" + listEntity(unitList) +
                "Buildings:\n" + listEntity(buildingList);
    }
}
