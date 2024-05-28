package HW3;

import java.util.Scanner;

public class Oven extends CookingTool{
    private int temperature;

    Oven() {
        name = "Oven";
    }
    @Override
    public String getName() {
        return name+"|"+temperature+"|";
    }

    @Override
    public void setup(Scanner sc) {
        int t = sc.nextInt();

        if(t != 100 && t != 150 && t != 200 && t != 250) {
            System.out.println("An Error Occurred: Invalid temperature\n");
            return;
        }

        temperature = t;
    }

    @Override
    public int getValue() {
        return temperature;
    }
}
