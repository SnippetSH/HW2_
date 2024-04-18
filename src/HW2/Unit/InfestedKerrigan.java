package HW2.Unit;

import HW2.Unit.Unit;

public class InfestedKerrigan extends Unit {
    public InfestedKerrigan() {
        this.name = "InfestedKerrigan";
        this.healthPoints = 600;
        this.max = 600;
    }
    @Override
    public void say() {
        System.out.println("InfestedKerrigan: ???");
    }

    @Override
    public boolean isWorker() {
        return false;
    }

    @Override
    public void attack(Unit target) {
        target.healthPoints -= 100;
        System.out.printf("InfestedKerrigan has dealt 100 damage to %s. (%s’s remaining HP: %d)\n", target.name, target.name, target.healthPoints);
        if(target.HP() <= 0) {
            System.out.printf("%s died!\n", target.name);
        }
    }
    public int HP() {
        return this.healthPoints;
    }
}
