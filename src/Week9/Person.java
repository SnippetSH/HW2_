package Week9;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age ) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    @Override
    public boolean equals(Object O) {
        if(this == O) return true;
        if(O == null || getClass() != O.getClass()) return false;
        Person person = (Person) O;
        return age == person.age && name.equals(person.name);
    }
}
