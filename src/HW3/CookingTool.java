package HW3;

import java.util.Scanner;

public abstract class CookingTool {
    protected String name;
    public abstract String getName();
    public abstract void setup(Scanner sc);
    public abstract int getValue();
}
