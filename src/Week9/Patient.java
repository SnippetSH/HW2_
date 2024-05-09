package Week9;

public class Patient extends Person{
    private String department;

    public Patient(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public String toString() {
        return "[Patient]" + super.toString() + ", Department" + department;
    }

    public String getDep() {
        return department;
    }
}
