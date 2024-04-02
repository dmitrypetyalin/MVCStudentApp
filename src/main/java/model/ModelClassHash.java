package model;

import controller.interfaces.iGetModel;
import model.domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PetSoft
 * @date 28.03.2024 21:46
 */
public class ModelClassHash implements iGetModel {
    private HashMap<Integer, Student> students;

    public ModelClassHash(Map<Integer, Student> students) {
        this.students = (HashMap<Integer, Student>) students;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student delete(int id) {
        return students.remove(id);
    }

    @Override
    public Student find(int id) {
        return students.remove(id);
    }
}
