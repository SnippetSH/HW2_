package HW2.Building;

import HW2.GameStatus;

public abstract class Building {
    public String name;
    public abstract void createUnit(GameStatus gameStatus);
}
