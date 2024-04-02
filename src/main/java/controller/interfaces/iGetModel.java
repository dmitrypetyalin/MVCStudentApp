package controller.interfaces;

import model.domain.Student;

import java.util.List;

/**
 * @author PetSoft
 * @date 25.03.2024 22:07
 */
public interface iGetModel {
    List<Student> getAllStudents();
    Student delete(int id);
    Student find(int id);
}
