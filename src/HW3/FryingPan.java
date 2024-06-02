package HW3;

import java.util.Scanner;

public class FryingPan extends CookingTool{
    private int intensity;

    FryingPan(int intensity) {
        this.intensity = intensity;
        name = "FryingPan";
    }
    @Override
    public String getName() {
        return name+"|"+intensity+"|";
    }

    @Override
    public void setup(Scanner sc) {
        int it = sc.nextInt();
        if(it < 1 || it > 3) {
            System.out.println("An Error Occurred: Invalid input.");
            return;
        }
        intensity = it;
    }

    @Override
    public int getValue() {
        return intensity;
    }

    public String toString() {
        return name;
    }
}
