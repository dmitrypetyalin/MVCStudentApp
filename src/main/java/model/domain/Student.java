package model.domain;

/**
 * @author PetSoft
 * @date 25.03.2024 22:05
 */
public class Student extends Person implements Comparable<Student> {
    private int id;
    private static int generalId;

    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [age=" + super.getAge() + ", name=" + super.getName() + ", id=" + id + "]";
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(id, o.id);
    }
}
