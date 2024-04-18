package HW2.Building;

import HW2.GameStatus;
import HW2.Unit.*;

public class CommandCenter extends Building {
    public CommandCenter() {
        this.name = "CommandCenter";
    }
    @Override
    public void createUnit(GameStatus gameStatus) {
        if(gameStatus.unitList.size() >= 9)  {
            System.out.println("You already have 9 Units.");
        } else if(gameStatus.money < 50) {
            System.out.println("You don't have enough money (need $50)");
        }else {
            SCV scv = new SCV();
            gameStatus.unitList.add(scv);
            gameStatus.money -= 50;
        }
    }
}
