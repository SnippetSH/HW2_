package HW2.Unit;

public abstract class Unit {
    public String name;
    protected int healthPoints;
    public int max;
    public abstract void say();
    public abstract boolean isWorker();
    public abstract void attack(Unit target);
    public abstract int HP();
}
