package controller.interfaces;

import model.domain.Student;

import java.util.List;

/**
 * @author PetSoft
 * @date 25.03.2024 22:07
 */
public interface iGetView {
    public void printAllStudents(List<Student> students);
    public String prompt(String msg);
}
