package HW3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidRecipeFileException, IOException {
        CookingSimulator simulator = new CookingSimulator();
        simulator.simulate();
    }
}
