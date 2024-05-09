package Week9;

import java.util.Objects;

public class Pediatrician extends Doctor {
    public Pediatrician(String name, int age, String hospital) {
        super(name, age, hospital);
    }
    @Override
    public void examination(Patient p) {
        if(Objects.equals(p.getDep(), "Pediatrics")) {
            System.out.println("I'll take care of you " + p.getName() + "!\n");
        } else {
            System.out.println("Sorry, but it's not my major.");
        }
    }

    @Override
    public String toString() {
        return "[Pediatrics]" + super.toString();
    }
}
