package HW2.Unit;

import HW2.Unit.Unit;

public class Tank extends Unit {
    public Tank() {
        this.name = "Tank";
        this.healthPoints = 150;
        this.max = 150;
        say();
    }
    @Override
    public void say() {
        System.out.println("Tank: Yes, sir!");
    }

    @Override
    public boolean isWorker() {
        return false;
    }

    @Override
    public void attack(Unit target) {
        target.healthPoints -= 50;
        System.out.printf("Tank has dealt 50 damage to InfestedKerrigan. (InfestedKerrigan’s remaining HP: %d)\n", target.healthPoints);
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
