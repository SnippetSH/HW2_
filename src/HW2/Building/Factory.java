package HW2.Building;

import HW2.GameStatus;
import HW2.Unit.*;

public class Factory extends Building {
    public Factory() {
        this.name = "Factory";
    }
    @Override
    public void createUnit(GameStatus gameStatus) {
        if(gameStatus.unitList.size() >= 9)  {
            System.out.println("You already have 9 Units.");
        } else if(gameStatus.money < 100) {
            System.out.println("You don't have enough money (need $100)");
        } else {
            Tank tank = new Tank();
            gameStatus.unitList.add(tank);
            gameStatus.money -= 100;
        }
    }
}
