package HW2.Unit;

import HW2.Unit.Unit;

public class Marine extends Unit {
    public Marine() {
        this.name = "Marine";
        this.healthPoints = 40;
        this.max = 40;
        say();
    }
    @Override
    public void say() {
        System.out.println("Marine: Go go go!");
    }

    @Override
    public boolean isWorker() {
        return false;
    }

    @Override
    public void attack(Unit target) {
        target.healthPoints -= 20;
        System.out.printf("Marine has dealt 20 damage to InfestedKerrigan. (InfestedKerrigan’s remaining HP: %d)\n", target.healthPoints);
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
