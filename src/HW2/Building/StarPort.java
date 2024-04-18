package HW2.Building;

import HW2.Unit.*;
import HW2.GameStatus;

public class StarPort extends Building {
    public StarPort() {
        this.name = "StarPort";
    }
    @Override
    public void createUnit(GameStatus gameStatus) {
        if(gameStatus.unitList.size() >= 9)  {
            System.out.println("You already have 9 Units.");
        } else if(gameStatus.money < 200) {
            System.out.println("You don't have enough money (need $200)");
        }else {
            BattleCruiser battleCruiser = new BattleCruiser();
            gameStatus.unitList.add(battleCruiser);
            gameStatus.money -= 200;
        }
    }
}
