package Week5;

public class Player {
    private String name;
    private int attack;
    private int defense;
    private int health;

    Player(String name, int attack, int defense, int health) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }
    String getName() {
        return this.name;
    }
    int getAttack() {
        return this.attack;
    }
    int getDefense() {
        return this.defense;
    }
    int getHealth() {
        return this.health;
    }
    void attack(Player opponent) {
        int atk = this.getAttack()-opponent.getDefense();
        if(atk < 0) {
            atk = 0;
        }
        opponent.setHealth(-atk);;
        System.out.printf("%s attacks %s for %d damage. (%s's hp: %d)\n", this.name, opponent.getName(), atk, opponent.getName(), opponent.getHealth());
    }
    void setHealth(int health) {
        this.health+=health;
    }
    Boolean isAlive() {
        return this.getHealth() > 0;
    }
}
