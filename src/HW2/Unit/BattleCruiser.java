package HW2.Unit;

import HW2.Unit.Unit;

public class BattleCruiser extends Unit {
    public BattleCruiser() {
        this.name = "BattleCruiser";
        this.healthPoints = 300;
        this.max = 300;
        say();
    }
    @Override
    public void say() {
        System.out.println("BattleCruiser: Battlecruiser operational!");
    }

    @Override
    public boolean isWorker() {
        return false;
    }

    @Override
    public void attack(Unit target) {
        target.healthPoints -= 100;
        System.out.printf("BattleCruiser has dealt 100 damage to InfestedKerrigan. (InfestedKerrigan’s remaining HP: %d)\n", target.healthPoints);
        if(target.HP() <= 0) {
            System.out.printf("%s died!\n", target.name);
            return;
        }
        target.attack(this);
    }

    @Override
    public int HP() {
        return this.healthPoints;
    }
}
