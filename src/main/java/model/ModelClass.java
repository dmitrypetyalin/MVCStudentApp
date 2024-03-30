package model;

import model.domain.Student;
import controller.interfaces.iGetModel;

import java.util.List;

/**
 * @author PetSoft
 * @date 25.03.2024 22:10
 */
public class ModelClass implements iGetModel {
    private List<Student> students;

    public ModelClass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student deleteStudent(int id) {
        Student deletedStudent = null;
        for (Student student : students) {
            if (student.getId() == id) {
                deletedStudent = students.remove(id);
            }
        }
        return deletedStudent;
    }
}
