package HW2.Building;

import HW2.Unit.*;
import HW2.GameStatus;

public class Barracks extends Building {
    public Barracks() {
        this.name = "Barracks";
    }
    @Override
    public void createUnit(GameStatus gameStatus) {
        if(gameStatus.unitList.size() >= 9)  {
            System.out.println("You already have 9 Units.");
        } else if(gameStatus.money < 50) {
            System.out.println("You don't have enough money (need $50)");
        } else {
            Marine marine = new Marine();
            gameStatus.unitList.add(marine);
            gameStatus.money -= 50;
        }
    }
}
